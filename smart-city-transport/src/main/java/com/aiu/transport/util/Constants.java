package com.aiu.transport.util;

public class Constants {
    public enum TimePeriod { MORNING, AFTERNOON, EVENING, NIGHT }
    
    public static final String NEIGHBORHOODS_CSV = "src/main/resources/data/neighborhoods.csv";
    public static final String FACILITIES_CSV = "src/main/resources/data/facilities.csv";
    public static final String ROADS_CSV = "src/main/resources/data/roads.csv";
    
    // Road condition thresholds
    public static final int GOOD_CONDITION = 8;
    public static final int FAIR_CONDITION = 5;
    public static final int POOR_CONDITION = 3;
}
