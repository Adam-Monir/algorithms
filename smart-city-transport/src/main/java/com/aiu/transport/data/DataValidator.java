package com.aiu.transport.data;

import com.aiu.transport.model.*;
import java.util.*;

public class DataValidator {
    public void validateGraphData(List<Node> neighborhoods, List<Facility> facilities, List<Edge> roads) {
        validateNoDuplicateNodes(neighborhoods, facilities);
        validateRoadConnections(roads);
        validateCriticalFacilities(facilities);
    }
    
    private void validateNoDuplicateNodes(List<Node> neighborhoods, List<Facility> facilities) {
        Set<String> ids = new HashSet<>();
        
        for (Node node : neighborhoods) {
            if (ids.contains(node.getId())) {
                throw new IllegalArgumentException("Duplicate node ID: " + node.getId());
            }
            ids.add(node.getId());
        }
        
        for (Facility facility : facilities) {
            if (ids.contains(facility.getId())) {
                throw new IllegalArgumentException("Duplicate facility ID: " + facility.getId());
            }
            ids.add(facility.getId());
        }
    }
    
    private void validateRoadConnections(List<Edge> roads) {
        for (Edge road : roads) {
            if (road.getFrom() == null || road.getTo() == null) {
                throw new IllegalArgumentException("Road connects to non-existent node: " + road);
            }
        }
    }
    
    private void validateCriticalFacilities(List<Facility> facilities) {
        boolean hasHospital = false;
        boolean hasTransitHub = false;
        
        for (Facility facility : facilities) {
            if (facility.getFacilityType().equalsIgnoreCase("Medical")) {
                hasHospital = true;
            }
            if (facility.getFacilityType().equalsIgnoreCase("Transit Hub")) {
                hasTransitHub = true;
            }
        }
        
        if (!hasHospital) {
            throw new IllegalArgumentException("No medical facilities found in the data");
        }
        if (!hasTransitHub) {
            throw new IllegalArgumentException("No transit hubs found in the data");
        }
    }
}
