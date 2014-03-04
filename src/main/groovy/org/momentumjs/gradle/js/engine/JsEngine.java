package org.momentumjs.gradle.js.engine;

import org.gradle.api.Incubating;
import org.gradle.api.Named;
import org.gradle.internal.HasInternalProtocol;

/**
 * A javascript engine capable of running scripts
 */
@Incubating
@HasInternalProtocol
public interface JsEngine extends Named {

    JsEngineDescriptor getDescriptor();

}
