package org.momentumjs.gradle.js.engine.plugins;

import org.gradle.api.Incubating;
import org.momentumjs.gradle.js.engine.JsEngineDescriptor;

@Incubating
public class EmbeddedJsEngine extends AbstractJsEngine {

    public EmbeddedJsEngine(String name, String version, String ecmaVersion) {
        super(new JsEngineDescriptor(name, version, ecmaVersion));
    }
}
