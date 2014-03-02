package org.momentumjs.gradle.jsengine.plugins;

import org.gradle.plugins.javascript.rhino.RhinoExtension;
import org.momentumjs.gradle.jsengine.JsEngine;
import org.momentumjs.gradle.jsengine.JsEngineDescriptor;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class RhinoJsEngine extends AbstractJsEngine {

    public RhinoJsEngine(JsEngineDescriptor descriptor) {
        super(new JsEngineDescriptor(
                RhinoExtension.NAME,
                RhinoExtension.DEFAULT_RHINO_DEPENDENCY_VERSION,
                "5"
        ));
    }

}
