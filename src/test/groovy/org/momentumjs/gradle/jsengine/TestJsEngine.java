package org.momentumjs.gradle.jsengine;

import org.momentumjs.gradle.jsengine.plugins.AbstractJsEngine;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 02/03/14
 * Time: 01:03
 * To change this template use File | Settings | File Templates.
 */
public class TestJsEngine extends AbstractJsEngine {

    public TestJsEngine(String name, String version, String ecmaVersion) {
        super(new JsEngineDescriptor(name, version, ecmaVersion));
    }
}
