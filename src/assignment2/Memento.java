package assignment2;

import java.util.ArrayList;

public class Memento {
    private ArrayList<Integer> shopIncomes;
    private ArrayList<Integer> onlineIncomes;

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
