package org.momentumjs.gradle.js.engine.test

import org.momentumjs.gradle.js.engine.JsEngine
import org.momentumjs.gradle.js.engine.JsEngineRegistry

import static org.junit.Assert.*

import org.gradle.api.internal.project.DefaultProject
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class JsBasePluginEngineTest {

    private static JsEngineRegistry jsEngineRegistry(DefaultProject project) {
        return project.modelRegistry.get("jsEngines", JsEngineRegistry)
    }

    @Test
    public void jsEnginePluginAddsExtensionToProject() {
        DefaultProject project = (DefaultProject)ProjectBuilder.builder().build()
        project.apply plugin: 'js-base'

        // no javascript engines are registered by the base plugin
        JsEngineRegistry registry = jsEngineRegistry(project)
        assertTrue(registry.isEmpty())

    }

    @Test
    public void rhinoEnginePlugin() {
        DefaultProject project = (DefaultProject)ProjectBuilder.builder().build()
        project.apply plugin: 'rhino-js-engine'

        // rhino is the only available engine with this plugin
        JsEngineRegistry registry = jsEngineRegistry(project)
        JsEngine jsEngine = registry.getByName("rhino-1.7R3")
        assertEquals("rhino", jsEngine.getDescriptor().getEngineName())
        assertEquals("5", jsEngine.getDescriptor().getEcmaScriptVersion())
        assertEquals(1, registry.size())
    }
}
