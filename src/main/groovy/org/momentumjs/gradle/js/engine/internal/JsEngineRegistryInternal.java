package org.momentumjs.gradle.js.engine.internal;

import org.gradle.api.Incubating;
import org.momentumjs.gradle.js.engine.JsEngine;
import org.momentumjs.gradle.js.engine.JsEngineFilter;
import org.momentumjs.gradle.js.engine.JsEngineRegistry;

/**
 * Adds internal methods to the API of JsEngineRegistry
 */
@Incubating
public interface JsEngineRegistryInternal extends JsEngineRegistry {

    void addDefaultJsEngines();
    void registerDefaultJsEngine(JsEngine engine);

    JsEngine findBestEngine(JsEngineFilter jsEngineFilter);

}
