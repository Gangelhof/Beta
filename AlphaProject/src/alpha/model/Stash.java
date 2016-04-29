package alpha.model;

import java.util.ArrayList;

/**
 *
 * @author RunEvil
 */
public class Stash {
    public double money;
    public ArrayList<Drug> drugs;

    public Stash() {
        this.money = 5000.00;
        this.drugs = new ArrayList<>();
    }
    
    public Stash(double money, ArrayList<Drug> drugs) {
        this.money = money;
        this.drugs = drugs;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(ArrayList<Drug> drugs) {
        this.drugs = drugs;
    }
}