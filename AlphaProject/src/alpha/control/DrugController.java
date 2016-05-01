/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.control;

import alpha.interfaces.ICalculateDrugs;
import alpha.model.Country;
import alpha.model.Drug;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author RunEvil
 */
public class DrugController implements ICalculateDrugs 
{
    private Random randomizer;
    GameInitializer init;
    Country country;
    private String name; // Få navnet på det drug der er valgt??
    private double price;
    private int price2;
    private int counter;
    private int availability;
    private int priceStrategy;
    Drug drug;

    public DrugController() 
    {
        this.randomizer = new Random();
        init = new GameInitializer();
        country = new Country();
        drug = new Drug(name, price, availability, priceStrategy);
        
    }
    
    // 0 = Normal (recalculateDrug), 1 = Old Memory, 2 = CompletelyRandom, 3 = Seconds of the Clock, 4 = simpleTwoChoice
    public void calculateDrug(){
        
        switch (priceStrategy){
            case 0:
                recalculateDrug(drug);
                break;
            case 1:
                oldMemory();
                break;
            case 2:
                completelyRandom();
                break;
            case 3:
                secondsOfTheClock();
                break;
            case 4:
                simpleTwoChoice();
                break;
        }
    }

    // Normal
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
    
    // Simple Two Choice
    public void simpleTwoChoice()
    {
        // Start with the White Price & Amount and then simply switch to the other price every turn.
        
        int visit;
        visit = country.getVisits();
        
        // Black price: 300 - black amount: 180
        if (visit%2==0){
            drug.setPrice(300);
            drug.setAvailability(180);
        } else { // White price: 90 - white amount: 50
            drug.setPrice(90);
            drug.setAvailability(50);
        }
//        Example: The first time the White Price and White amount is used. The second time the
//        Black Price and Black Amount must be used. The third time the White Price and White
//        amount is used and so on.
    }
    
    // Seconds Of The Clock
    public void secondsOfTheClock()
    {
        Calendar cal = Calendar.getInstance( TimeZone.getDefault() );
        int sec;
        sec = cal.get(Calendar.SECOND);
        
        // Price: Add 1 to the clock if it’s exactly 00 to avoid 0$ price.
        if(sec==00){
            sec++;
            // Price: the double of the current clocks seconds.
            drug.setPrice(sec*2);
            // Amount: the current clocks seconds.
            drug.setAvailability(sec);
        } else{
            // Price: the double of the current clocks seconds.
            drug.setPrice(sec*2);
            // Amount: the current clocks seconds.
            drug.setAvailability(sec);
        }

    }
    // Completely Random
    public void completelyRandom()
    {
    Random priceRand = new Random();
    
    int priceNumber = 0;
    
    priceNumber = 10+priceRand.nextInt(12010);
    
    Random availabilityRand = new Random();
    
    int availabilityNumber = 0;
    
    priceNumber = 2+availabilityRand.nextInt(402);
    
    }
    

    // Old Memory
    public void oldMemory()
    {
        boolean upDown;
        boolean upDown2;
        
        switch(counter){
            
        case 0:
           price2 = 1000;
           availability = 100;
           break;
        case 1:
            upDown = randomizer.nextBoolean();
            int priceModifier = randomizer.nextInt(66-10)+1;
            int modifiedPrice = price2 * priceModifier;
            int newPrice = (upDown ? (price2 = price2 + modifiedPrice) : (price2 = price2 - modifiedPrice));
            price2 = newPrice + 75;
            availability += 7;
            break;
        default:
            upDown2 = randomizer.nextBoolean();
            int priceModifier2 = randomizer.nextInt(36-10)+1;
            int modifiedPrice2 = price2 * priceModifier2;
            int newPrice2 = (upDown2 ? (price2 = price2 + modifiedPrice2) : (price2 = price2 - modifiedPrice2));
            price2 = newPrice2 + 75;
            availability += 13;
            break;

        }
        counter++;
    }
}