package org.momentumjs.gradle.jsengine;

import org.gradle.api.ExtensiblePolymorphicDomainObjectContainer;
import org.gradle.api.Incubating;
import org.gradle.internal.HasInternalProtocol;

/**
 * Interface for the registry of java script engines available for running scripts
 */
@Incubating
@HasInternalProtocol
public interface JsEngineRegistry extends ExtensiblePolymorphicDomainObjectContainer<JsEngine> {
}
