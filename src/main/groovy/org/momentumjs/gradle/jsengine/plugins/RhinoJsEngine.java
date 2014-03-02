package org.momentumjs.gradle.jsengine.plugins;

import org.gradle.api.Incubating;
import org.gradle.plugins.javascript.rhino.RhinoExtension;
import org.momentumjs.gradle.jsengine.JsEngineDescriptor;

/**
 * JsEngine providing gradle's existing Rhino plugin
 */
@Incubating
public class RhinoJsEngine extends AbstractJsEngine {

    public static final String RHINO_ECMA_VERSION = "5";

    public RhinoJsEngine() {
        super(new JsEngineDescriptor(
                RhinoExtension.NAME,
                RhinoExtension.DEFAULT_RHINO_DEPENDENCY_VERSION,
                RHINO_ECMA_VERSION
        ));
    }

}
