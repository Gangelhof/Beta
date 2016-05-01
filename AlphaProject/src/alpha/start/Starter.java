package alpha.start;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import alpha.control.GameInitializer;
import alpha.model.Country;
import alpha.model.Drug;
import alpha.view.MainWindow;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RunEvil
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameInitializer init = new GameInitializer();
        ArrayList<Drug> startDrugs = init.initializeDrugs();
        ArrayList<Country> countries = init.initializeCountries(startDrugs);
        String name = init.getUserName();
        init.initializeUser(name);
        MainWindow mainWindow = new MainWindow();
    }
}
