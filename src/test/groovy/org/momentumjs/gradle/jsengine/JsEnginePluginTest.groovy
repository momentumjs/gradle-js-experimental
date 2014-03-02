package org.momentumjs.gradle.jsengine

import static org.junit.Assert.*

import org.gradle.api.Project
import org.gradle.api.internal.project.DefaultProject
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
class JsEnginePluginTest {

    private JsEngineRegistry jsEngineRegistry(DefaultProject project) {
        return project.modelRegistry.get("jsEngines", JsEngineRegistry)
    }

    @Test
    public void jsEnginePluginAddsExtensionToProject() {
        DefaultProject project = (DefaultProject)ProjectBuilder.builder().build()
        project.apply plugin: 'js-engine'

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
