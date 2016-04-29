/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha.interfaces;

import alpha.model.Country;
import alpha.model.Drug;
import alpha.model.User;
import java.util.ArrayList;

/**
 *
 * @author RunEvil
 */
public interface IGameInitializer {
    ArrayList<Drug> initializeDrugs();
    ArrayList<Country> initializeCountries(ArrayList<Drug> startDrugs);
    User initializeUser(String input);
}
