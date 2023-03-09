package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel) {
        super(startDen, slutDen, laegemiddel);
    }


    public ArrayList<Dosis> getDoser() {
        return new ArrayList<>(doser);
    }

    public Dosis opretDosis(LocalTime tid, double antal) {
        if (antal < 0) {
            throw new IllegalArgumentException("Antal skal være større end 0");
        }
        else {
            Dosis dosis = new Dosis(tid, antal);
            doser.add(dosis);
            return dosis;
        }
    }

    @Override
    public double samletDosis() {
        return antalDage() * doegnDosis();
    }

    @Override
    public double doegnDosis() {
        double resultat = 0;
        for (int i = 0; i < doser.size(); i++) {
            resultat += doser.get(i).getAntal();
        }
        return resultat;
    }

    @Override
    public String getType() {
        return "Type: Daglig Skaev";
    }
}
