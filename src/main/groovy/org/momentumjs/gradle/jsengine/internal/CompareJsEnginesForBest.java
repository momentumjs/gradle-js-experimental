package org.momentumjs.gradle.jsengine.internal;

import org.gradle.api.Incubating;
import org.momentumjs.gradle.jsengine.JsEngine;

import java.util.Comparator;

/**
 * Compares engines by descriptor to sort them in reverse order, i.e. highest
 * versions come first.
 */
@Incubating
public class CompareJsEnginesForBest implements Comparator<JsEngine> {

    @Override
    public int compare(JsEngine engine1, JsEngine engine2) {
        return -engine1.getDescriptor().compareTo(engine2.getDescriptor());
    }
}