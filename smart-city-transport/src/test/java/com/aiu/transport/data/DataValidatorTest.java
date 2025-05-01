package com.aiu.transport.data;

import com.aiu.transport.model.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {
    private DataValidator validator = new DataValidator();
    
    @Test
    void validateGraphData_ShouldPassWithValidData() {
        List<Node> neighborhoods = List.of(
            new Node("1", "Area1", 0, 0, "Residential", 1000),
            new Node("2", "Area2", 1, 1, "Mixed", 2000)
        );
        
        List<Facility> facilities = List.of(
            new Facility("F1", "Hospital", 2, 2, "Medical"),
            new Facility("F2", "Station", 3, 3, "Transit Hub")
        );
        
        Node node1 = neighborhoods.get(0);
        Node node2 = neighborhoods.get(1);
        List<Edge> roads = List.of(
            new Edge(node1, node2, 5.0, 1000, 8)
        );
        
        assertDoesNotThrow(() -> validator.validateGraphData(neighborhoods, facilities, roads));
    }
    
    @Test
    void validateGraphData_ShouldFailWithDuplicateIds() {
        List<Node> neighborhoods = List.of(
            new Node("1", "Area1", 0, 0, "Residential", 1000),
            new Node("1", "Area2", 1, 1, "Mixed", 2000)
        );
        
        assertThrows(IllegalArgumentException.class, 
            () -> validator.validateGraphData(neighborhoods, List.of(), List.of()));
    }
}
