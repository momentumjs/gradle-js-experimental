package org.momentumjs.gradle.js.engine.test

import org.momentumjs.gradle.js.engine.JsEngineRegistry

import static org.junit.Assert.*

import org.gradle.api.internal.project.DefaultProject
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder


class EmbeddedJsEngineTest
{
    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void embeddedEnginePlugin() {
        DefaultProject project = (DefaultProject) ProjectBuilder.builder()
                .withProjectDir(folder.getRoot())
                .build()
        project.apply plugin: 'embedded-js-engine'

        JsEngineRegistry registry = project.modelRegistry.get("jsEngines", JsEngineRegistry)

        assertTrue(registry.size() >= 1);
    }

    @Test
    public void embeddedEngineAndRhinoPlugin() {
        DefaultProject project = (DefaultProject) ProjectBuilder.builder()
                .withProjectDir(folder.getRoot())
                .build()
        project.apply plugin: 'rhino-js-engine'
        project.apply plugin: 'embedded-js-engine'

        JsEngineRegistry registry = project.modelRegistry.get("jsEngines", JsEngineRegistry)

        assertTrue(registry.size() >= 2);
    }
}
