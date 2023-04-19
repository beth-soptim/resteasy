package org.jboss.resteasy.links.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.links.RESTServiceDiscovery;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class IdBook {
    @XmlElement
    private RESTServiceDiscovery rest;

    public RESTServiceDiscovery getRest() {
        return rest;
    }

    public void setRest(RESTServiceDiscovery rest) {
        this.rest = rest;
    }
}
