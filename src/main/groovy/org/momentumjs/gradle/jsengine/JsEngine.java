package org.momentumjs.gradle.jsengine;

import org.gradle.api.Incubating;
import org.gradle.api.Named;
import org.gradle.internal.HasInternalProtocol;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
@Incubating
@HasInternalProtocol
public interface JsEngine extends Named {

    String getDisplayName();

    String getEngineName();

    String getEngineVersion();

    String getECMAScriptVersion();

}
