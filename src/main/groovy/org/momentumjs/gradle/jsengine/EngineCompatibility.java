package org.momentumjs.gradle.jsengine;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 01/03/14
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
public interface EngineCompatibility {

    boolean compatibleWith(JsEngineDescriptor descriptor);

}
