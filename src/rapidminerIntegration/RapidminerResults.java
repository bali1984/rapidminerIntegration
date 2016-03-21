package rapidminerIntegration;


/**
 * Created by alibe on 21/03/2016.
 */

public class RapidminerResults {
    private Float accuracy;
    private Float precision;
    private Float recall;
    private Float aucOptimistic;
    private Float auc;
    private Float aucPessimistic;

    public Float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }

    public Float getPrecision() {
        return precision;
    }

    public void setPrecision(Float precision) {
        this.precision = precision;
    }

    public Float getRecall() {
        return recall;
    }

    public void setRecall(Float recall) {
        this.recall = recall;
    }

    public Float getAucOptimistic() {
        return aucOptimistic;
    }

    public void setAucOptimistic(Float aucOptimistic) {
        this.aucOptimistic = aucOptimistic;
    }

    public Float getAuc() {
        return auc;
    }

    public void setAuc(Float auc) {
        this.auc = auc;
    }

    public Float getAucPessimistic() {
        return aucPessimistic;
    }

    public void setAucPessimistic(Float aucPessimistic) {
        this.aucPessimistic = aucPessimistic;
    }

    public RapidminerResults(Float aucPessimistic, Float accuracy, Float precision, Float recall, Float aucOptimistic, Float auc) {
        this.aucPessimistic = aucPessimistic;
        this.accuracy = accuracy;
        this.precision = precision;
        this.recall = recall;
        this.aucOptimistic = aucOptimistic;
        this.auc = auc;
    }

    void compareField(RapidminerResults res1, RapidminerResults res2){

        {
            int retvalAccuracy = Float.compare(res1.getAccuracy(), res2.getAccuracy());
            if (retvalAccuracy > 0) {
                System.out.println("ACCURACY : Model 1 > Model 2 by " + 100 * res1.getAccuracy() / res2.getAccuracy() +" %");
            } else if (retvalAccuracy == 0) {
                System.out.println("ACCURACY : Model 1 = Model 2 : " + res1.getAccuracy() +" %");
            } else if (retvalAccuracy < 0) {
                System.out.println("ACCURACY : Model 1 < Model 2 by " + 100 * res1.getAccuracy() / res2.getAccuracy() +" %");
            } else
                System.out.println("Error");
        }

        {
            int retvalPrecision = Float.compare(res1.getPrecision(), res2.getPrecision());
            if (retvalPrecision > 0) {
                System.out.println("PRECISION : Model 1 > Model 2 by " + 100 * res1.getPrecision() / res2.getPrecision() +" %");
            } else if (retvalPrecision == 0) {
                System.out.println("PRECISION : Model 1 = Model 2 : " + res1.getPrecision() +" %");
            } else if (retvalPrecision < 0) {
                System.out.println("PRECISION : Model 1 < Model 2 by " + 100 * res1.getPrecision() / res2.getPrecision() +" %");
            } else
                System.out.println("Error");
        }


        {
            int retvalRecall = Float.compare(res1.getRecall(), res2.getRecall());
            if (retvalRecall > 0) {
                System.out.println("RECALL : Model 1 > Model 2 by " + 100 * res1.getRecall() / res2.getRecall() +" %");
            } else if (retvalRecall == 0) {
                System.out.println("RECALL : Model 1 = Model 2 : " + res1.getRecall() +" %");
            } else if (retvalRecall < 0) {
                System.out.println("RECALL : Model 1 < Model 2 by " + 100 * res1.getRecall() / res2.getRecall() +" %");
            } else
                System.out.println("Error");
        }

        {
            int retvalAucOptimistic = Float.compare(res1.getAucOptimistic(), res2.getAucOptimistic());
            if (retvalAucOptimistic > 0) {
                System.out.println("AUC OPTIMISTIC : Model 1 > Model 2 by " + 100 * res1.getAucOptimistic() / res2.getAucOptimistic() +" %");
            } else if (retvalAucOptimistic == 0) {
                System.out.println("AUC OPTIMISTIC : Model 1 = Model 2 : " + res1.getAucOptimistic() +" %");
            } else if (retvalAucOptimistic < 0) {
                System.out.println("AUC OPTIMISTIC : Model 1 < Model 2 by " + 100 * res1.getAucOptimistic() / res2.getAucOptimistic() +" %");
            } else
                System.out.println("Error");
        }

        {
            int retvalAuc = Float.compare(res1.getAuc(), res2.getAuc());
            if (retvalAuc > 0) {
                System.out.println("AUC : Model 1 > Model 2 by " + 100 * res1.getAuc() / res2.getAuc() +" %");
            } else if (retvalAuc == 0) {
                System.out.println("AUC : Model 1 = Model 2 : " + res1.getAuc() +" %");
            } else if (retvalAuc < 0) {
                System.out.println("AUC : Model 1 < Model 2 by " + 100 * res1.getAuc() / res2.getAuc() +" %");
            } else
                System.out.println("Error");
        }

        {
            int retvalAucPessimistic = Float.compare(res1.getAucPessimistic(), res2.getAucPessimistic());
            if (retvalAucPessimistic > 0) {
                System.out.println("AUC PESSIMISTIC : Model 1 > Model 2 by " + 100 * res1.getAucPessimistic() / res2.getAucPessimistic() +" %");
            } else if (retvalAucPessimistic == 0) {
                System.out.println("AUC PESSIMISTIC  : Model 1 = Model 2 : " + res1.getAucPessimistic() +" %");
            } else if (retvalAucPessimistic < 0) {
                System.out.println("AUC PESSIMISTIC  : Model 1 < Model 2 by " + 100 * res1.getAucPessimistic() / res2.getAucPessimistic() +" %");
            } else
                System.out.println("Error");
        }
    }
}


