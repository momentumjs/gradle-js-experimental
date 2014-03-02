package org.momentumjs.gradle.jsengine.plugins;

import org.gradle.api.Incubating;
import org.momentumjs.gradle.jsengine.JsEngine;
import org.momentumjs.gradle.jsengine.JsEngineDescriptor;

/**
 * Base class available for JsEngine implementations
 */
@Incubating
public abstract class AbstractJsEngine implements JsEngine {

    private final JsEngineDescriptor descriptor;

    public AbstractJsEngine(JsEngineDescriptor descriptor) {
        if (descriptor == null) {
            throw new IllegalArgumentException("JsEngine descriptor cannot be null");
        }
        this.descriptor = descriptor;
    }

    @Override
    public String getName() {
        return descriptor.getEngineName() + "-" + descriptor.getEngineVersion();
    }

    @Override
    public JsEngineDescriptor getDescriptor() {
        return descriptor;
    }

}
