package assignment2;

import java.util.*;

/**
 * Represents the headquarters of the agencies.
 *
 */

public class Headquarters implements AvgCollection{
    
    private String name;             	 // Headquarters identifier, a name
    private List<Agency> theAgencies;  // List of controlled agencies
    private static Headquarters instance; // Istance of headquarters

    /**
     * Constructs the headquarters from its name
     * @param name   Headquarters identifier, a name
     */
    private Headquarters(String name) { 
        if (instance != null) {
			System.out.println("SingletonException");
		}else {
			this.name = name;
			theAgencies = new ArrayList<Agency>();
		}
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
    
    /**
     * Get an instance of headquarters
     * @return an instance of headquarters
     */
    public static Headquarters getInstance(){
        if (instance == null) {
            try {
                instance = new Headquarters("Test");
            } catch (Exception x) {
                // never
            }
        }
		return instance;
    }
    
    /**
     * Override of getAvgProvider for Iterator DP
     * @return a new iterator
     */
    @Override
    public AvgProvider getAvgProvider() {
        return new AvgIterator(theAgencies);
    }

    /**
     * Implementation of the AvgIterator
     */
    public class AvgIterator implements AvgProvider{
        private List<Agency> theAgencies;
        private int index = 0;

        public AvgIterator(List<Agency> theAgencies){
            this.theAgencies = theAgencies;
        }

        @Override
        public double getNextAvg() {
            return theAgencies.get(index++).getAverage();
        }

        @Override
        public boolean done() {
            if (index >= theAgencies.size())
                return true;
            else
                return false;
        } 
    }

    /**
     * Do a backup of the current state
     */
    public void doBackups() {
        for (int i = 0; i < theAgencies.size(); i++){
            theAgencies.get(i).save();
        }
    }
    
    /**
     * Restore the backup of a specific agency
     * @param name  name of the agency whose state has to be restored
     */
    public void restoreBackup(String name) {
        for (int i = 0; i < theAgencies.size(); i++){
            if (theAgencies.get(i).getName().equalsIgnoreCase(name)) {
                theAgencies.get(i).restore();
            }
        }
    }
	
    
}
