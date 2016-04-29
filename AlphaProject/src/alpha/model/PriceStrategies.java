/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.model;

import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

/**
 *
 * @author RunEvil
 */
public class PriceStrategies {
    
    Country country = new Country();
    private String name; // Få navnet på det drug der er valgt??
    private double price;
    private int availability;
    private int priceStrategy;
    Drug drug = new Drug(name, price, availability, priceStrategy);
    
    //Switch.... // 0 = Normal, 1 = Old Memory, 2 = CompleteRand, 3 = Clock, 4 = TwoChoice....
    
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
//        Calendar cal = Calendar.getInstance( TimeZone.getDefault() );
//        System.out.println( cal.get(Calendar.SECOND) ); //Prints the current seconds
    }
    
    public void completelyRandom()
    {
    Random priceRand = new Random();
    
    int priceNumber = 0;
    
    priceNumber = 10+priceRand.nextInt(12010);
    
    
    
    Random availabilityRand = new Random();
    
    int availabilityNumber = 0;
    
    priceNumber = 2+availabilityRand.nextInt(402);
    
    }
    
    public void oldMemory(){
        
    }
    
}