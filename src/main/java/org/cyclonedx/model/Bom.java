/*
 * This file is part of CycloneDX Core (Java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.cyclonedx.model;

import org.cyclonedx.CycloneDxSchema;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "bom", namespace = CycloneDxSchema.NS_BOM)
public class Bom {

    private List<Component> components;
    private int version;

    public List<Component> getComponents() {
        return components;
    }

    @XmlElementWrapper(name = "components", namespace = CycloneDxSchema.NS_BOM)
    @XmlElement(name = "component", namespace = CycloneDxSchema.NS_BOM)
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public void addComponent(Component component) {
        if (components == null) {
            components = new ArrayList<>();
        }
        components.add(component);
    }

    public int getVersion() {
        return version;
    }

    @XmlAttribute(name = "version")
    public void setVersion(int version) {
        this.version = version;
    }
}