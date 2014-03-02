package org.momentumjs.gradle.jsengine.internal;

import org.gradle.api.Action;
import org.gradle.api.Incubating;
import org.gradle.api.internal.DefaultPolymorphicDomainObjectContainer;
import org.gradle.internal.reflect.Instantiator;
import org.momentumjs.gradle.jsengine.JsEngineFilter;
import org.momentumjs.gradle.jsengine.JsEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * The default JsEngineRegistry implementation. Allows for default JsEngine registry also,
 * which are sorted such that the best engine matching a set of requirements (encapsulated by
 * JsEngineFilter) can be found.
 */
@Incubating
public class DefaultJsEngineRegistry  extends DefaultPolymorphicDomainObjectContainer<JsEngine> implements JsEngineRegistryInternal {
    private final List<JsEngine> defaultEngines = new ArrayList<JsEngine>();
    private final LinkedList<JsEngine> searchOrder = new LinkedList<JsEngine>();

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
        orderJsEngines();
    }

    public void orderJsEngines() {
        Collections.sort(searchOrder, new CompareJsEnginesForBest());
    }

    public void registerDefaultJsEngine(JsEngine engine) {
       defaultEngines.add(engine);
    }

    public JsEngine getBestEngine() {
        return searchOrder.getFirst();
    }

    public JsEngine findBestEngine(JsEngineFilter jsEngineFilter) {
        for (JsEngine engine : searchOrder) {
            if (jsEngineFilter.compatibleWith(engine.getDescriptor())) {
                return engine;
            }
        }
        return null;
    }
}
