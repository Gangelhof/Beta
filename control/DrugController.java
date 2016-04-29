/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.control;

import alpha.interfaces.ICalculateDrugs;
import alpha.model.Drug;
import java.util.Random;

/**
 *
 * @author RunEvil
 */
public class DrugController implements ICalculateDrugs {

    private Random randomizer;

    public DrugController() {
        this.randomizer = new Random();
    }
    
    // 0 = Normal, 1 = Old Memory, 2 = CompleteRand, 3 = Clock, 4 = TwoChoice

    public Drug recalculateDrug(Drug drug) {
        int priceChance = randomizer.nextInt(100);
        if (priceChance < 65) {
            drug.setPrice(calculateNewPrice(drug.getPrice()));
        }
        
        int availabilityChance = randomizer.nextInt(100);
        if (availabilityChance < 65) {
            drug.setAvailability(calculateNewAvailability(drug.getAvailability()));
        }

        return drug;
    }

    private double calculateNewPrice(double currentPrice) {
        int upOrDown = randomizer.nextInt(2);
        int changePercentage = randomizer.nextInt(85) + 1;
        double newPrice;

        if (upOrDown == 0) {
            newPrice = currentPrice - (currentPrice * changePercentage / 100);
        } else {
            newPrice = currentPrice + (currentPrice * changePercentage / 100);
        }

        return newPrice;
    }
    
    private int calculateNewAvailability(int availability) {
        int upOrDown = randomizer.nextInt(2);
        int changePercentage = randomizer.nextInt(40) + 16;
        int newAvailability;

        if (upOrDown == 0) {
            newAvailability = (int) Math.floor(availability - (availability * changePercentage / 100));
        } else {
            newAvailability = (int) Math.floor(availability + (availability * changePercentage / 100));
        }

        return newAvailability;
    }
}
