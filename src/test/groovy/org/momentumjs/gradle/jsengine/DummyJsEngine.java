package org.momentumjs.gradle.jsengine;

import org.momentumjs.gradle.jsengine.plugins.AbstractJsEngine;


public class DummyJsEngine extends AbstractJsEngine {

    public DummyJsEngine(String name, String version, String ecmaVersion) {
        super(new JsEngineDescriptor(name, version, ecmaVersion));
    }
}
