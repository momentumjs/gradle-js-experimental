package org.momentumjs.gradle.jsengine.plugins

import org.gradle.api.Incubating
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.model.ModelRule
import org.gradle.model.ModelRules
import org.gradle.plugins.javascript.rhino.RhinoPlugin
import org.momentumjs.gradle.jsengine.JsEnginePlugin
import org.momentumjs.gradle.jsengine.JsEngineRegistry
import org.momentumjs.gradle.jsengine.internal.JsEngineRegistryInternal

import javax.inject.Inject

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */
@Incubating
class RhinoJsEnginePlugin implements Plugin<Project> {

    private final ModelRules modelRules

    @Inject
    RhinoJsEnginePlugin(ModelRules modelRules) {
        this.modelRules = modelRules
    }

    void apply(Project project) {
        project.plugins.apply(JsEnginePlugin)
        project.plugins.apply(RhinoPlugin)

        modelRules.rule(new ModelRule() {
            void addJsEngine(JsEngineRegistryInternal registry) {
                registry.registerDefaultJsEngine(new RhinoJsEngine());
            }
        })
    }



}
