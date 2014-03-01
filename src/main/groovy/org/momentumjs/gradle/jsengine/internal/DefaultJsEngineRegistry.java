package org.momentumjs.gradle.jsengine.internal;

import org.gradle.api.Action;
import org.gradle.api.internal.DefaultPolymorphicDomainObjectContainer;
import org.gradle.internal.reflect.Instantiator;
import org.momentumjs.gradle.jsengine.JsEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
public class DefaultJsEngineRegistry  extends DefaultPolymorphicDomainObjectContainer<JsEngine> implements JsEngineRegistryInternal {
    private final List<JsEngine> defaultEngines = new ArrayList<JsEngine>();
    private final List<JsEngine> searchOrder = new ArrayList<JsEngine>();

    public DefaultJsEngineRegistry(Instantiator instantiator) {
        super(JsEngine.class, instantiator);
        whenObjectAdded(new Action<JsEngine>() {
            public void execute(JsEngine toolChain) {
                searchOrder.add(toolChain);
            }
        });
        whenObjectRemoved(new Action<JsEngine>() {
            public void execute(JsEngine toolChain) {
                searchOrder.remove(toolChain);
            }
        });
    }

    public void addDefaultJsEngines() {
        this.addAll(defaultEngines);
    }

    public void registerDefaultJsEngine(JsEngine engine) {
       defaultEngines.add(engine);
    }
}
