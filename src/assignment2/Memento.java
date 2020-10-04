package assignment2;

import java.util.ArrayList;

/**
 * Memento, acts as a snapshot of the originator’s state.
 */
public class Memento implements MementoInterface {
    private ArrayList<Integer> shopIncomes;
    private ArrayList<Integer> onlineIncomes;

    /**
     * The state is defined by shopIncomes and onlineIncomes
     * @param shopIncomes   the list of all shop incomes
     * @param onlineIncomes     the list of all online incomes
     */
    public Memento(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
        this.shopIncomes = shopIncomes;
        this.onlineIncomes = onlineIncomes;
    }

    /**
     * @return the list shopIncomes 
     */
    public ArrayList<Integer> getShopIncomes() {
        return shopIncomes;
    }

    /**
     * @return the list onlineIncomes 
     */
    public ArrayList<Integer> getOnlineIncomes() {
        return onlineIncomes;
    }


}
