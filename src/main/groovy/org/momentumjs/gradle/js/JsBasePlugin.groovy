/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.momentumjs.gradle.js

import org.gradle.api.Incubating
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.gradle.model.ModelFinalizer
import org.gradle.model.ModelRules
import org.momentumjs.gradle.js.engine.internal.DefaultJsEngineRegistry
import org.momentumjs.gradle.js.engine.internal.JsEngineRegistryInternal

import javax.inject.Inject

@Incubating
class JsBasePlugin implements Plugin<Project> {

    private final Instantiator instantiator
    private final ModelRules modelRules

    @Inject
    JsBasePlugin(Instantiator instantiator, ModelRules modelRules) {
        this.instantiator = instantiator
        this.modelRules = modelRules
    }

    void apply(Project project) {
        modelRules.register("jsEngines", JsEngineRegistryInternal, new DefaultJsEngineRegistryFactory<>())
        modelRules.rule(new AddDefaultJsEnginesIfRequired())
    }

    private class DefaultJsEngineRegistryFactory implements org.gradle.internal.Factory<JsEngineRegistryInternal> {

        public JsEngineRegistryInternal create() {
            return instantiator.newInstance(DefaultJsEngineRegistry, instantiator)
        }
    }

    @SuppressWarnings("UnusedDeclaration")
    private static class AddDefaultJsEnginesIfRequired extends ModelFinalizer {
        void defaultJsEngines(JsEngineRegistryInternal registry) {
            if (registry.isEmpty()) {
                registry.addDefaultJsEngines();
            }
        }
    }
}