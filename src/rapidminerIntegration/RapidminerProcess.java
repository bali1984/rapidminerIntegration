package rapidminerIntegration;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.operator.IOContainer;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.tools.XMLException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;

/**
 * Created by alibe on 21/03/2016.
 * Fonction qui compare 2 process et retourne le résultat
 */
public class RapidminerProcess {
    private String cheminTest;
    private String cheminTrain;
    private File fichierProcess;

    public String getCheminTest() {
        return cheminTest;
    }

    public void setCheminTest(String cheminTest) {
        this.cheminTest = cheminTest;
    }

    public String getCheminTrain() {
        return cheminTrain;
    }

    public void setCheminTrain(String cheminTrain) {
        this.cheminTrain = cheminTrain;
    }

    public File getFichierProcess() {
        return fichierProcess;
    }

    public void setFichierProcess(File fichierProcess) {
        this.fichierProcess = fichierProcess;
    }

    public RapidminerProcess(String cheminTest, String cheminTrain, File fichierProcess) {
        this.cheminTest = cheminTest;
        this.cheminTrain = cheminTrain;
        this.fichierProcess = fichierProcess;
    }

    String runModel() {

        // Initialisation du process
        RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
        RapidMiner.init();
        Process process = null;
        String resultat = new String();

        try {
            process = new Process(getFichierProcess());


            // execute the process and get the resulting objects
            IOContainer ioResult = null;
            try {
                ioResult = process.run();
            } catch (OperatorException e) {
                e.printStackTrace();
            }

            resultat = ioResult.getElementAt(0).toString();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLException e) {
            e.printStackTrace();

        }
        return resultat;
    }

    void compareModel (RapidminerProcess process2) {

        String resultat1 = this.runModel();
        String resultat2 = process2.runModel();

        try {

            //résultat 1
            String[] splitArray1 = resultat1.split("[\r\n]");
            Float accuracy1 = Float.parseFloat(splitArray1[4].trim().substring(15,20));
            Float precision1 = Float.parseFloat(splitArray1[14].trim().substring(16,21));
            Float recall1 = Float.parseFloat(splitArray1[24].trim().substring(13,18));
            Float aucOptimistic1 = Float.parseFloat(splitArray1[34].trim().substring(24,29));
            Float auc1 = Float.parseFloat(splitArray1[36].trim().substring(11,16));
            Float aucPessimistic1 = Float.parseFloat(splitArray1[38].trim().substring(25,30));
            RapidminerResults res1 = new RapidminerResults(accuracy1,precision1,recall1,aucOptimistic1,auc1,aucPessimistic1);

            //résultat 2
            String[] splitArray2 = resultat2.split("[\r\n]");
            Float accuracy2 = Float.parseFloat(splitArray2[4].trim().substring(15,20));
            Float precision2 = Float.parseFloat(splitArray2[14].trim().substring(16,21));
            Float recall2 = Float.parseFloat(splitArray2[24].trim().substring(13,18));
            Float aucOptimistic2 = Float.parseFloat(splitArray2[34].trim().substring(24,29));
            Float auc2 = Float.parseFloat(splitArray2[36].trim().substring(11,16));
            Float aucPessimistic2 = Float.parseFloat(splitArray2[38].trim().substring(25,30));
            RapidminerResults res2 = new RapidminerResults(accuracy2,precision2,recall2,aucOptimistic2,auc2,aucPessimistic2);

            res1.compareField(res1,res2);

        } catch (PatternSyntaxException ex) {
            //
        }
    }
}
