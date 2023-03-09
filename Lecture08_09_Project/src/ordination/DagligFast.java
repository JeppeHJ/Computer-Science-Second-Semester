package ordination;

import java.time.LocalDate;
import java.time.LocalTime;



public class DagligFast extends Ordination {

    private Dosis[] doser;


    public DagligFast(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
        this.doser = new Dosis[4];

    }

    public Dosis[] getDoser() {
        return doser;
    }

    public Dosis createDosis(LocalTime tid, double antal) {
        for (int i = 0; i < doser.length; i++) {
            if (doser[i] == null) {
                Dosis dosis = new Dosis(tid, antal);
                doser[i] = dosis;
                return dosis;
            }
        }
        return null;
    }

    @Override
    public double samletDosis() {
        return antalDage() * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        double resultat = 0;
        for (Dosis dosis : doser) {
            resultat += dosis.getAntal();
        }
        return resultat;
    }

    @Override
    public String getType() {
        return "Type: Daglig fast";
    }

}
