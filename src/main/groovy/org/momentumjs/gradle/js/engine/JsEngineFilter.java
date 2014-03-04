package org.momentumjs.gradle.js.engine;

import org.gradle.api.Incubating;

/**
 * Predicate interface to filter JsEngine's by engine descriptor
 */
@Incubating
public interface JsEngineFilter {

    boolean compatibleWith(JsEngineDescriptor descriptor);

}
