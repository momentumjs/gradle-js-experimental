package org.momentumjs.gradle.js.engine.plugins

import org.gradle.api.Incubating
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.model.ModelRule
import org.gradle.model.ModelRules
import org.gradle.plugins.javascript.rhino.RhinoPlugin
import org.momentumjs.gradle.js.JsBasePlugin
import org.momentumjs.gradle.js.engine.internal.JsEngineRegistryInternal

import javax.inject.Inject

/**
 * Plugin to provide gradle's existing rhino javascript engine support
 * via the js-engine-plugin
 */
@Incubating
class RhinoJsEnginePlugin implements Plugin<Project> {

    private final ModelRules modelRules

    @Inject
    RhinoJsEnginePlugin(ModelRules modelRules) {
        this.modelRules = modelRules
    }

    void apply(Project project) {
        project.plugins.apply(JsBasePlugin)
        project.plugins.apply(RhinoPlugin)

        modelRules.rule(new ModelRule() {
            void addJsEngine(JsEngineRegistryInternal registry) {
                registry.registerDefaultJsEngine(new RhinoJsEngine());
            }
        })
    }



}
