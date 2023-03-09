package Opgave2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bib {
    /*
     * Returnerer størrelsen af bøden beregnet i henhold til skemaet
     * ovenfor
     * krav: beregnetDato og faktiskDato indeholder lovlige datoer og
     * beregnetDato < faktiskDato
     * (beregnetDato er forventet afleveringsdato og
     * faktiskDato er den dag bogen blev afleveret; voksen er
     * sand, hvis det er en voksen og falsk ellers)
     */
    public int beregnBøde(LocalDate beregnetDato, LocalDate faktiskDato, boolean voksen) {
        int result = 0;
        int forsinketDage = (int)ChronoUnit.DAYS.between(beregnetDato, faktiskDato);
        if (voksen){
            if (forsinketDage<=7){

            }


        }



        return result;
    }

}
