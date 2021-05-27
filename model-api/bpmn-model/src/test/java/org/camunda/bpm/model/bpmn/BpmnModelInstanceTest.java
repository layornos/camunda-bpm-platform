/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.model.bpmn;

import org.camunda.bpm.model.bpmn.instance.paradigm.core.Definitions;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Filip Hrisafov
 */
public class BpmnModelInstanceTest {

  @Test
  public void testClone() throws Exception {

    BpmnModelInstance modelInstance = Bpmn.createEmptyModel();

    Definitions definitions = modelInstance.newInstance(Definitions.class);
    definitions.setId("TestId");
    modelInstance.setDefinitions(definitions);

    BpmnModelInstance cloneInstance = modelInstance.clone();
    cloneInstance.getDefinitions().setId("TestId2");

    assertThat(modelInstance.getDefinitions().getId(), is(equalTo("TestId")));
    assertThat(cloneInstance.getDefinitions().getId(), is(equalTo("TestId2")));
  }

}
