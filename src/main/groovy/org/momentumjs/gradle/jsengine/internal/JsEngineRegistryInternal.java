package org.momentumjs.gradle.jsengine.internal;

import org.gradle.api.Incubating;
import org.momentumjs.gradle.jsengine.JsEngineFilter;
import org.momentumjs.gradle.jsengine.JsEngine;
import org.momentumjs.gradle.jsengine.JsEngineRegistry;

/**
 * Adds internal methods to the API of JsEngineRegistry
 */
@Incubating
public interface JsEngineRegistryInternal extends JsEngineRegistry {

    void addDefaultJsEngines();
    void registerDefaultJsEngine(JsEngine engine);

    JsEngine findBestEngine(JsEngineFilter jsEngineFilter);

}
