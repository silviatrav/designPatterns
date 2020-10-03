package assignment2;

import java.util.ArrayList;

/**
 * Compute the average as (c1*average-shop-income + (1 – c1)*average-online-income)
 */
public class WeightedAvg implements Average {

    @Override
    public double incomesAverage(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
        double c1 = 0.5; // default value
        int shopIncomeSize = shopIncomes.size();
        double avgShopIncome = 0, shopIncomeSum = 0;
        int onlineIncomeSize = onlineIncomes.size();
        double avgOnlineIncome = 0, onlineIncomeSum = 0;

        for (int i = 0; i < shopIncomeSize; i++){
            shopIncomeSum += shopIncomes.get(i);
        };
        avgShopIncome = shopIncomeSum / shopIncomeSize;

        for (int i = 0; i < onlineIncomeSize; i++){
            onlineIncomeSum += onlineIncomes.get(i);
        };
        avgOnlineIncome = onlineIncomeSum / onlineIncomeSize;

        return c1*avgShopIncome + (1-c1)*avgOnlineIncome;
    }

    
    
}
