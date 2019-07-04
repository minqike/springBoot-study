package com.min.springboot.springboot_xmlserver.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String mha;
    @JacksonXmlProperty
    private String bank;
    @JacksonXmlProperty
    private String bay;
    @JacksonXmlProperty
    private String level;

}
