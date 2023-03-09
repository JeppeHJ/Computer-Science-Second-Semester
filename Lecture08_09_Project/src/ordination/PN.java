package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PN extends Ordination {

    private double antalEnheder;
    private Patient patient;
    private List<LocalDate> datoerForGivetDosis = new ArrayList<>();

    public PN(LocalDate startDen, LocalDate slutDen, Laegemiddel laegemiddel, double antalEnheder) {
        super(startDen, slutDen, laegemiddel);
        this.antalEnheder = antalEnheder;

    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.compareTo(getStartDen()) >= 0 && givesDen.compareTo(getSlutDen()) <= 0) {
            datoerForGivetDosis.add(givesDen);
            return true;
        }
        else {
            return false;
        }
    }

    public double doegnDosis() {
        double resultat = 0;
       if (getAntalEnheder() > 0 && datoerForGivetDosis.size() > 0) {
           Collections.sort(datoerForGivetDosis, (a, b) -> a.compareTo(b));
           resultat =       (getAntalGangeGivet() * antalEnheder) /
                            ChronoUnit.DAYS.between(datoerForGivetDosis.get(0),
                            datoerForGivetDosis.get(datoerForGivetDosis.size() - 1).plusDays(1));
           return resultat;
       }
       return 0;
    }

    
    public double samletDosis() {
        return getAntalEnheder() * getAntalGangeGivet();
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return datoerForGivetDosis.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return "Type: PN";
    }

}
