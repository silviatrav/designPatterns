package assignment2;

import java.util.ArrayList;

/**
 * Computes the average first computing the average of the last five values 
 * (or less values if there are less the five values) of each type of incomes, 
 * and then averaging the two results. 
 */
public class LastFiveValuesAvg implements Average {

    @Override
    public double incomesAverage(ArrayList<Integer> shopIncomes, ArrayList<Integer> onlineIncomes) {
        int shopIncomeSize = shopIncomes.size();
        double avgShopIncome = 0;
        int onlineIncomeSize = onlineIncomes.size(), shopIncomeSum = 0;
        double avgOnlineIncome = 0, onlineIncomeSum = 0;

        if (shopIncomeSize > 5) {
            for (int i = shopIncomeSize - 1; i >= shopIncomeSize - 5; i--){
                shopIncomeSum += shopIncomes.get(i);
            }
            avgShopIncome = shopIncomeSum / 5;
        }else{
            for (int i = 0; i < shopIncomeSize; i++){
                shopIncomeSum += shopIncomes.get(i);
            }
            avgShopIncome = shopIncomeSum / shopIncomeSize;
        }

        if (onlineIncomeSize > 5){ 
            for (int i = onlineIncomeSize - 1; i >= onlineIncomeSize - 5; i--){
                onlineIncomeSum += onlineIncomes.get(i);
            }
            avgOnlineIncome = onlineIncomeSum / 5;
        }else{
            for (int i = 0; i < onlineIncomeSize; i++){
                onlineIncomeSum += onlineIncomes.get(i);
            }
            avgOnlineIncome = onlineIncomeSum / onlineIncomeSize;

        }

        return (avgShopIncome + avgOnlineIncome) / 2;
    }
        
    }