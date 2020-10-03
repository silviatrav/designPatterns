package assignment2;

import java.util.ArrayList;

/**
 * Memento, acts as a snapshot of the originator’s state.
 */
public class Memento {
    private ArrayList<Integer> shopIncomes;
    private ArrayList<Integer> onlineIncomes;

    /**
     * The state is defined by shopIncomes and onlineIncomes
     * @param shopIncomes
     * @param onlineIncomes
     */
    public Memento(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
        this.shopIncomes = shopIncomes;
        System.out.println(shopIncomes.size());
        this.onlineIncomes = onlineIncomes;
        System.out.println(onlineIncomes.size());
    }

    public ArrayList<Integer> getShopIncomes() {
        return shopIncomes;
    }

    public ArrayList<Integer> getOnlineIncomes() {
        return onlineIncomes;
    }


 
    

}
