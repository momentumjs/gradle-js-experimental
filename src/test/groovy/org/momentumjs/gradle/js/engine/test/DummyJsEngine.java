package org.momentumjs.gradle.js.engine.test;

import org.momentumjs.gradle.js.engine.JsEngineDescriptor;
import org.momentumjs.gradle.js.engine.plugins.AbstractJsEngine;


public class DummyJsEngine extends AbstractJsEngine {

    public DummyJsEngine(String name, String version, String ecmaVersion) {
        super(new JsEngineDescriptor(name, version, ecmaVersion));
    }
}
