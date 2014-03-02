package org.momentumjs.gradle.jsengine.internal;

import org.momentumjs.gradle.jsengine.EngineCompatibility;
import org.momentumjs.gradle.jsengine.JsEngine;
import org.momentumjs.gradle.jsengine.JsEngineRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public interface JsEngineRegistryInternal extends JsEngineRegistry {

    void addDefaultJsEngines();
    void registerDefaultJsEngine(JsEngine engine);

    JsEngine findBestEngine(EngineCompatibility engineCompatibility);

}
