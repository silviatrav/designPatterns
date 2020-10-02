package assignment2;

import java.util.*;

/**
 * Represents the headquarters of the agencies.
 *
 */
public class Headquarters {
    
    private String name;             	 // Headquarters identifier, a name
    private List<Agency> theAgencies;  // List of controlled agencies
    
    /**
     * Constructs the headquarters from its name
     * @param name   Headquarters identifier, a name
     */
    public Headquarters(String name) {
        this.name = name;
        theAgencies = new ArrayList<Agency>();
    }
    
    /**
     * @return the headquarters name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Adds an Agency to the list.
     * @param agency the Agency to add
     */
    public void addAgency(Agency agency) {
    	theAgencies.add(agency);
    }
    
}
