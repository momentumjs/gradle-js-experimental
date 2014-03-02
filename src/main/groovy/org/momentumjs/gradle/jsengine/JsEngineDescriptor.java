package org.momentumjs.gradle.jsengine;

public final class JsEngineDescriptor implements Comparable<JsEngineDescriptor> {

    public final String engineName;
    public final String engineVersion;
    public final String ecmaScriptVersion;

    public JsEngineDescriptor(String engineName, String engineVersion) {
        this(engineName, engineVersion, null);
    }

    public JsEngineDescriptor(String engineName, String engineVersion, String ecmaScriptVersion) {
        if (engineName == null) {
            throw new IllegalArgumentException("engine name cannot be null");
        }
        if (engineVersion == null) {
            throw new IllegalArgumentException("engine version cannot be null");
        }

        this.engineName = engineName;
        this.engineVersion = engineVersion;
        this.ecmaScriptVersion = ecmaScriptVersion;
    }

    public String getEngineName() {
        return engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public String getEcmaScriptVersion() {
        return ecmaScriptVersion;
    }

    @Override
    public int compareTo(JsEngineDescriptor other) {
        if (other == null) {
            throw new NullPointerException("attempt to compare JsEngine to null");
        }
        if (equals(other)) {
            return 0;
        }

        int compareStandards = compareVersionNumbers(
                ecmaScriptVersion == null ? "0" : ecmaScriptVersion,
                other.ecmaScriptVersion == null ? "0" : other.ecmaScriptVersion);
        if (compareStandards != 0) {
            return compareStandards;
        }

        int compareEngineNames = engineName.compareTo(other.engineName);
        if (compareEngineNames != 0) {
            return compareEngineNames;
        }

        return compareVersionNumbers(engineVersion, other.engineVersion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JsEngineDescriptor that = (JsEngineDescriptor) o;

        if (ecmaScriptVersion != null ? !ecmaScriptVersion.equals(that.ecmaScriptVersion) : that.ecmaScriptVersion != null)
            return false;
        if (!engineName.equals(that.engineName)) return false;
        if (!engineVersion.equals(that.engineVersion)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = engineName.hashCode();
        result = 31 * result + engineVersion.hashCode();
        result = 31 * result + (ecmaScriptVersion != null ? ecmaScriptVersion.hashCode() : 0);
        return result;
    }

    public static int compareVersionNumbers(String x, String y) {
        if (x == y) {
            return 0;
        }
        else if (x == null || y == null) {
            throw new NullPointerException("attempt to compare version number " + x + " to " + y);
        }
        // TODO this is a naive implementation. improve.
        return x.compareToIgnoreCase(y);
    }

}
