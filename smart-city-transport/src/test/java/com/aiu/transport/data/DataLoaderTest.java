package com.aiu.transport.data;

import com.aiu.transport.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {
    private DataLoader dataLoader;
    
    @BeforeEach
    void setUp() {
        dataLoader = new DataLoader();
    }
    
    @Test
    void loadNeighborhoods_ShouldReturnCorrectCount() throws IOException {
        List<Node> neighborhoods = dataLoader.loadNeighborhoods(
            "src/main/resources/data/neighborhoods.csv");
        assertEquals(5, neighborhoods.size());
    }
    
    @Test
    void loadFacilities_ShouldReturnCorrectTypes() throws IOException {
        List<Facility> facilities = dataLoader.loadFacilities(
            "src/main/resources/data/facilities.csv");
        assertEquals(4, facilities.size());
        assertEquals("Medical", facilities.get(3).getFacilityType());
    }
    
    @Test
    void loadRoads_ShouldConnectExistingNodes() throws IOException {
        dataLoader.loadNeighborhoods("src/main/resources/data/neighborhoods.csv");
        dataLoader.loadFacilities("src/main/resources/data/facilities.csv");
        List<Edge> roads = dataLoader.loadRoads("src/main/resources/data/roads.csv");
        
        assertEquals(5, roads.size());
        assertEquals(8.5, roads.get(0).getDistance());
    }
}
