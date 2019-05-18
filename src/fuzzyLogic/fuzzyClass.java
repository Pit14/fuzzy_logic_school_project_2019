package fuzzyLogic;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class fuzzyClass {

        public fuzzyClass() {

        }

        public int getMeta ( int prelev, int extract) {
            String fileName = "src\\fuzzyLogic\\fuzzyfile.fcl";
            FIS fis = FIS.load(fileName,true);
            fis.setVariable("extract",extract); // Set inputs
            fis.setVariable("prelev", prelev);
            fis.evaluate(); // Evaluate

            // use fis.getVariable("nom del a donnée").getValue() pour obenir la valeur selon les INPUT
            return (int)fis.getVariable("metamorph").getValue();
        }
}
/*
public class fuzzyClass {
    public static void main(String[] args) throws Exception {
        // Load from 'FCL' file
        String fileName = "src\\fuzzyLogic\\fuzzyfile2.fcl";
        FIS fis = FIS.load(fileName,true);

        // Error while loading?
        if( fis == null ) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);

        // Set inputs
        fis.setVariable("extract", 30);
        fis.setVariable("prelev", 10);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = functionBlock.getVariable("metamorph");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
    }
}*/