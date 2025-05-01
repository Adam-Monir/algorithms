package com.aiu.transport.model;

public class Facility extends Node {
    private final String facilityType;
    
    public Facility(String id, String name, double x, double y, String facilityType) {
        super(id, name, x, y, "Facility", 0);
        this.facilityType = facilityType;
    }
    
    public String getFacilityType() {
        return facilityType;
    }
}
