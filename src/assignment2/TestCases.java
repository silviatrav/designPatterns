package assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 *  Drivers to test the classes.
 */

public class TestCases {
	
	@Test
	public void test0() {
        Agency agency1 = new Agency("Lugano");
        agency1.addOnlineIncomes(new int[] {50, 100, 200, 50, 100, 100});
        agency1.addShopIncomes(new int[] {50, 25, 75});

        double avg1 = agency1.getAverage(); // should use weighted sum with c1=0.5 by default
        assertEquals(75.0, avg1, 0.01);
        
        // switch to considering average on top 5 incomes:
        agency1.setUseOnlyTopFiveIncomes(true);
        double avg2 = agency1.getAverage(); 
        assertEquals(80.0, avg2, 0.01);

        // switch back to weighted sum with c1=0.5
        agency1.setUseOnlyTopFiveIncomes(false);
        double avg3 = agency1.getAverage(); 
        assertEquals(75.0, avg3, 0.01);
	}
    
	@Test
	public void test1() {
		Headquarters hq = Headquarters.getInstance();
		
        Agency agency1 = new Agency("Lugano");
        agency1.addOnlineIncomes(new int[] {50, 100, 200, 50, 100, 100});
        agency1.addShopIncomes(new int[] {50, 25, 75});
        hq.addAgency(agency1);

        Agency agency2 = new Agency("Milano");
        agency2.addOnlineIncomes(new int[] {50, 20, 80, 10, 90});
        agency2.addShopIncomes(new int[] {40, 35, 75});
        hq.addAgency(agency2);
        
        hq.doBackups();
        
        agency1.addShopIncomes(new int[] {120, 230});
        agency2.addShopIncomes(new int[] {200, 150});

        AvgProvider avgProvider1 = hq.getAvgProvider();
        int sum1 = 0;
        AvgProvider avgProvider;
		while (!avgProvider1.done()) {
        	double avg = avgProvider1.getNextAvg();
        	sum1 += avg;
        }
        assertEquals(175.0, sum1, 0.01); //Since agency1 has average of 100, and agency2 of 75

        hq.restoreBackup("Milano");
        AvgProvider avgProvider2 = hq.getAvgProvider();
        int sum2 = 0;
        while (!avgProvider2.done()) {
        	double avg = avgProvider2.getNextAvg(); //Since agency2 has an average of 50 after restoring the backup
        	sum2 += avg;
        }
        assertEquals(150.0, sum2, 0.01);
	}

}
