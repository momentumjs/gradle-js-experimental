package org.momentumjs.gradle.jsengine.plugins

import org.gradle.api.Incubating
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.model.ModelRule
import org.gradle.model.ModelRules
import org.momentumjs.gradle.jsengine.JsEnginePlugin
import org.momentumjs.gradle.jsengine.internal.JsEngineRegistryInternal

import javax.inject.Inject
import javax.script.ScriptEngineFactory
import javax.script.ScriptEngineManager

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 02/03/14
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
@Incubating
class EmbeddedJsEnginePlugin implements Plugin<Project> {

    private final ModelRules modelRules

    @Inject
    EmbeddedJsEnginePlugin(ModelRules modelRules) {
        this.modelRules = modelRules
    }

    void apply(Project project) {
        project.plugins.apply(JsEnginePlugin)

        modelRules.rule(new ModelRule() {
            void addEmbeddedJsEngines(JsEngineRegistryInternal registry) {

                ScriptEngineManager manager = new ScriptEngineManager()
                for (ScriptEngineFactory factory : manager.getEngineFactories()) {

                    if (factory.getExtensions().contains("js")) {

                        System.out.println(factory.getEngineName())
                        System.out.println(factory.getEngineVersion())
                        System.out.println(factory.getLanguageName())
                        System.out.println(factory.getLanguageVersion())
                        System.out.println("");

                        String engineName = factory.getEngineName();
                        if (engineName.equals("Mozilla Rhino")) {
                            engineName = "rhino";
                        }

                        // Rhino reports ECMAScript language but the version is the Mozilla
                        // 'JavaScript' version so we cannot rely on that.
                        // TODO: provide some way to translate versions
                        String ecmaScriptVersion = null;
                        //if ("ECMAScript".compareToIgnoreCase(factory.getLanguageName()) == 0) {
                        //}

                        registry.registerDefaultJsEngine(new EmbeddedJsEngine(
                                engineName,
                                factory.getEngineVersion(),
                                ecmaScriptVersion));
                    }
                }
            }
        })
    }



}
