package assignment2;

import java.util.ArrayList;

/**
 * Represents an agency and their incomes.
 * Stores the name, shop incomes and online incomes.
 */
public class Agency {

    private String name;                      // Agency identifier, a name
    private ArrayList<Integer> shopIncomes;   // incomes from the shop 
    private ArrayList<Integer> onlineIncomes; // incomes from the online e-commerce app
	private boolean useTopFive = false;		// choose average method
	private double averageIncomes;		// average of the incomes
	private Memento state;		// for Memento DP, it is private so Headquarters cannot access to it
	

	/**
	 * Constructs the agency from their name
	 * @param name  a name that identifies the agency.
	 */
	public Agency(String name) {
		this.name = name;
		shopIncomes = new ArrayList<Integer>();
		onlineIncomes = new ArrayList<Integer>();
	}

	/**
	 * @return the agency's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds incomes to the collection of incomes from the shop.
	 * @param incomes   the incomes to add
	 */
	public void addShopIncomes(int[] incomes) {
		for (int i = 0; i < incomes.length; ++i) {
			shopIncomes.add(incomes[i]);
		}
	}
	
	/**
	 * Adds incomes to the collection of online incomes.
	 * @param incomes   the income to add
	 */
	public void addOnlineIncomes(int[] incomes) {
		for (int i = 0; i < incomes.length; ++i) {
			onlineIncomes.add(incomes[i]);
		}
	}

	/**
	 * Calculate the average of the incomes
	 * @return value of the average of the incomes
	 */
	public double getAverage(){
		if (useTopFive){
			LastFiveValuesAvg avg = new LastFiveValuesAvg();
			averageIncomes = avg.incomesAverage(shopIncomes, onlineIncomes);
		}else{
			WeightedAvg avg = new WeightedAvg();
			averageIncomes = avg.incomesAverage(shopIncomes, onlineIncomes);
		}
		return averageIncomes;
	}

	/**
	 * Select the averaging method
	 * @param value 	a boolean that is true if the TopFiveIncomes method has to be used
	 */
	public void setUseOnlyTopFiveIncomes(boolean value) {
		useTopFive = value;
	}

	/**
	 * Save the current state 
	 */
	public void save(){
		ArrayList<Integer> shopI = new ArrayList<Integer>(shopIncomes);
		ArrayList<Integer> onlineI = new ArrayList<Integer>(onlineIncomes);
		this.state = new Memento(shopI, onlineI);
	}

	/**
	 * Restore a previous state
	 */
	public void restore(){
		this.shopIncomes = state.getShopIncomes();
		this.onlineIncomes = state.getOnlineIncomes();
	}
	
	
}
