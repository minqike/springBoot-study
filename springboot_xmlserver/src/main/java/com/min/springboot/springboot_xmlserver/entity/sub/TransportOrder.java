package com.min.springboot.springboot_xmlserver.entity.sub;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement
public class TransportOrder {
    @JacksonXmlProperty(localName = "controlArea")
    private  ControlArea controlArea;
    @JacksonXmlProperty(localName = "dataArea")
    private  DataArea dataArea;
}
