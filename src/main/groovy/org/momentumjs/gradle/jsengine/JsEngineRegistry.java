package org.momentumjs.gradle.jsengine;

import org.gradle.api.ExtensiblePolymorphicDomainObjectContainer;
import org.gradle.api.Incubating;
import org.gradle.internal.HasInternalProtocol;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
@Incubating
@HasInternalProtocol
public interface JsEngineRegistry extends ExtensiblePolymorphicDomainObjectContainer<JsEngine> {
}
