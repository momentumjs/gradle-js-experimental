package org.momentumjs.gradle.jsengine.plugins;

import org.momentumjs.gradle.jsengine.JsEngine;
import org.momentumjs.gradle.jsengine.JsEngineDescriptor;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 23:35
 * To change this template use File | Settings | File Templates.
 */
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
