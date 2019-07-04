package com.min.springboot.springboot_xmlserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataArea {

    private Integer transportType;

    private Location fromLocation;

    private String StUnitId;

    private Location toLocation;

    private Integer errorCode;
}
