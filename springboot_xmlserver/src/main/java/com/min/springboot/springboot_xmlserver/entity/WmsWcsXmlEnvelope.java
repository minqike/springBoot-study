package com.min.springboot.springboot_xmlserver.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName ="WmsWcsXML_Envelope")
public class WmsWcsXmlEnvelope {

    @JacksonXmlProperty(localName = "TransportOrder")
    private TransportOrder transportOrder;
}
