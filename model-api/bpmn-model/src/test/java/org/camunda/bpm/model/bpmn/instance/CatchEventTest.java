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
package org.camunda.bpm.model.bpmn.instance;

import org.camunda.bpm.model.bpmn.impl.instance.EventDefinitionRef;
import org.camunda.bpm.model.bpmn.instance.paradigm.data.DataOutput;
import org.camunda.bpm.model.bpmn.instance.paradigm.data.DataOutputAssociation;
import org.camunda.bpm.model.bpmn.instance.paradigm.data.OutputSet;
import org.camunda.bpm.model.bpmn.instance.paradigm.events.Event;
import org.camunda.bpm.model.bpmn.instance.paradigm.events.EventDefinition;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Sebastian Menski
 */
public class CatchEventTest extends BpmnModelElementInstanceTest {

  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(Event.class, true);
  }

  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return Arrays.asList(
      new ChildElementAssumption(DataOutput.class),
      new ChildElementAssumption(DataOutputAssociation.class),
      new ChildElementAssumption(OutputSet.class, 0, 1),
      new ChildElementAssumption(EventDefinition.class),
      new ChildElementAssumption(EventDefinitionRef.class)
    );
  }

  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
      new AttributeAssumption("parallelMultiple", false, false, false)
    );
  }
}
