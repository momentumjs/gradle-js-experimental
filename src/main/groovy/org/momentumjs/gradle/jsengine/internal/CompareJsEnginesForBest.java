package org.momentumjs.gradle.jsengine.internal;

import org.momentumjs.gradle.jsengine.JsEngine;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: rob
 * Date: 02/03/14
 * Time: 01:00
 * To change this template use File | Settings | File Templates.
 */
public class CompareJsEnginesForBest implements Comparator<JsEngine> {

    @Override
    public int compare(JsEngine engine1, JsEngine engine2) {
        return -engine1.getDescriptor().compareTo(engine2.getDescriptor());
    }
}