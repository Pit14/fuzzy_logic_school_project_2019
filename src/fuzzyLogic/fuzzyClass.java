package fuzzyLogic;

import net.sourceforge.jFuzzyLogic.FIS;

public class fuzzyClass {

        public fuzzyClass() {
            FIS fis = FIS.load("fcl/fuzzyfile2.fcl", true); // Load from 'FCL' file
            fis.setVariable("extract", 3); // Set inputs
            fis.setVariable("prelev", 7);
            fis.evaluate(); // Evaluate

            // use fis.getVariable("nom del a donnée").getValue() pour obenir la valeur selon les INPUT
            System.out.println("Output value:" + fis.getVariable("metamorph").getValue());
        }

}
