package org.momentumjs.gradle.jsengine.plugins;

import org.momentumjs.gradle.jsengine.JsEngine;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class RhinoJsEngine implements JsEngine {


    public String getDisplayName() {
        return getName() + " " + getEngineVersion();
    }

    public String getEngineName() {
        return getName();
    }

    public String getEngineVersion() {
        return "1.7R3";
    }

    public String getECMAScriptVersion() {
        return "5";
    }

    public String getName() {
        return "Rhino";
    }
}
