package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import ordination.*;
import storage.Storage;

public class Controller {
    private Storage storage;
    private static Controller controller;

    private Controller() {
        storage = new Storage();
    }

    public static Controller getController() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public static Controller getTestController() {
        return new Controller();
    }

    /**
     * Hvis startDato er efter slutDato kastes en IllegalArgumentException og
     * ordinationen oprettes ikke
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     * Pre: antal >= 0
     *
     * @return opretter og returnerer en PN ordination.
     */
    public static PN opretPNOrdination(LocalDate startDen, LocalDate slutDen,
                                       Patient patient, Laegemiddel laegemiddel, double antal) {
        if (startDen.isAfter(slutDen)) {
            throw new IllegalArgumentException("Fejl! Kan ikke oprettes fordi startdatoen er efter slut datoen");
        }
        else {
            PN PNOrdination = new PN(startDen, slutDen, laegemiddel, antal);
            patient.addOrdination(PNOrdination);
            return PNOrdination;
        }
    }

    /**
     * Opretter og returnerer en DagligFast ordination. Hvis startDato er efter
     * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     * Pre: margenAntal, middagAntal, aftanAntal, natAntal >= 0
     */
    public DagligFast opretDagligFastOrdination(LocalDate startDen,
                                                LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
                                                double morgenAntal, double middagAntal, double aftenAntal,
                                                double natAntal) {
        if (startDen.isAfter(slutDen)) {
            throw new IllegalArgumentException("Fejl! Kan ikke oprettes fordi startdatoen er efter slut datoen");
        }
        DagligFast DFOrdination = new DagligFast(startDen, slutDen, laegemiddel);
        patient.addOrdination(DFOrdination);

        try {
            DFOrdination.createDosis(LocalTime.of(8, 0), morgenAntal);
            DFOrdination.createDosis(LocalTime.of(12, 0), middagAntal);
            DFOrdination.createDosis(LocalTime.of(18, 0), aftenAntal);
            DFOrdination.createDosis(LocalTime.of(22, 0), natAntal);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return DFOrdination;
    }

    /**
     * Opretter og returnerer en DagligSk??v ordination. Hvis startDato er efter
     * slutDato kastes en IllegalArgumentException og ordinationen oprettes ikke.
     * Hvis antallet af elementer i klokkeSlet og antalEnheder er forskellige kastes ogs?? en IllegalArgumentException.
     * <p>
     * Pre: startDen, slutDen, patient og laegemiddel er ikke null
     * Pre: alle tal i antalEnheder > 0
     */
    public DagligSkaev opretDagligSkaevOrdination(LocalDate startDen,
                                                  LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
                                                  LocalTime[] klokkeSlet, double[] antalEnheder) {
        if (startDen == null || slutDen == null || patient == null || laegemiddel == null) {
            throw new IllegalArgumentException("Accepterer ikke NULL argumenter.");
        }

        if (controller.checkStartFoerSlut(startDen, slutDen)) {
            throw new IllegalArgumentException("Start dato er efter slut dato");
        }


        if (klokkeSlet.length != antalEnheder.length) {
            throw new IllegalArgumentException("Klokkeslet og AntalEnheder skal have samme l??ngde.");
        }

        DagligSkaev dagligSkaev = new DagligSkaev(startDen, slutDen, laegemiddel);

        for (int i = 0; i < klokkeSlet.length; i++) {
            dagligSkaev.opretDosis(klokkeSlet[i], antalEnheder[i]);
        }
        patient.addOrdination(dagligSkaev);
        return dagligSkaev;
    }

    /**
     * En dato for hvorn??r ordinationen anvendes tilf??jes ordinationen. Hvis
     * datoen ikke er indenfor ordinationens gyldighedsperiode kastes en
     * IllegalArgumentException
     * Pre: ordination og dato er ikke null
     */
    public void ordinationPNAnvendt(PN ordination, LocalDate dato) {
        if(dato.isBefore(ordination.getStartDen()) ||
        dato.isAfter(ordination.getSlutDen())) {
            throw new IllegalArgumentException
                    ("Dato udenfor ordinations gyldighedsperiode");
        }
        ordination.givDosis(dato);
    }

    /**
     * Den anbefalede dosis for den p??g??ldende patient (der skal tages hensyn
     * til patientens v??gt). Det er en forskellig enheds faktor der skal
     * anvendes, og den er afh??ngig af patientens v??gt.
     * Pre: patient og l??gemiddel er ikke null
     */
    public double anbefaletDosisPrDoegn(Patient patient, Laegemiddel laegemiddel) {
        double vaegt = patient.getVaegt();

        double enhedCount = 0;

        if (vaegt < 25) {
            enhedCount = laegemiddel.getEnhedPrKgPrDoegnLet();
        } else if (vaegt > 120) {
            enhedCount = laegemiddel.getEnhedPrKgPrDoegnTung();
        } else {
            enhedCount = laegemiddel.getEnhedPrKgPrDoegnNormal();
        }

        return enhedCount;
    }

    /**
     * For et givent v??gtinterval og et givent l??gemiddel, hentes antallet af
     * ordinationer.
     * Pre: laegemiddel er ikke null
     */
    public int antalOrdinationerPrV??gtPrL??gemiddel(double v??gtStart,
                                                   double v??gtSlut, Laegemiddel laegemiddel) {
        if (v??gtSlut - v??gtStart < 0) {
            throw new IllegalArgumentException("V??gt start skal v??re f??r v??gt slut");
        }

        int ordinationer = 0;
        if (laegemiddel != null) {
            for (Patient p : storage.getAllPatienter()) {
                if (p.getVaegt() >= v??gtStart && p.getVaegt() <= v??gtSlut) {
                    for (Ordination o : p.getOrdinationer()) {
                        if (o.getLaegemiddel().equals(laegemiddel)) {
                            ordinationer++;
                        }
                    }
                }
            }
        }
        return ordinationer;
    }

    public List<Patient> getAllPatienter() {
        return storage.getAllPatienter();
    }

    public List<Laegemiddel> getAllLaegemidler() {
        return storage.getAllLaegemidler();
    }

    /**
     * Metode der kan bruges til at checke at en startDato ligger f??r en
     * slutDato.
     *
     * @return true hvis startDato er f??r slutDato, false ellers.
     */
    private boolean checkStartFoerSlut(LocalDate startDato, LocalDate slutDato) {
        boolean result = true;
        if (slutDato.compareTo(startDato) > 0) {
            result = false;
        }
        return result;
    }

    public Patient opretPatient(String cpr, String navn, double vaegt) {
        Patient p = new Patient(cpr, navn, vaegt);
        storage.addPatient(p);
        return p;
    }

    public Laegemiddel opretLaegemiddel(String navn,
                                        double enhedPrKgPrDoegnLet, double enhedPrKgPrDoegnNormal,
                                        double enhedPrKgPrDoegnTung, String enhed) {
        Laegemiddel lm = new Laegemiddel(navn, enhedPrKgPrDoegnLet,
                enhedPrKgPrDoegnNormal, enhedPrKgPrDoegnTung, enhed);
        storage.addLaegemiddel(lm);
        return lm;
    }

    public void createSomeObjects() {
        this.opretPatient("121256-0512", "Jane Jensen", 63.4);
        this.opretPatient("070985-1153", "Finn Madsen", 83.2);
        this.opretPatient("050972-1233", "Hans J??rgensen", 89.4);
        this.opretPatient("011064-1522", "Ulla Nielsen", 59.9);
        this.opretPatient("090149-2529", "Ib Hansen", 87.7);

        this.opretLaegemiddel("Acetylsalicylsyre", 0.1, 0.15, 0.16, "Styk");
        this.opretLaegemiddel("Paracetamol", 1, 1.5, 2, "Ml");
        this.opretLaegemiddel("Fucidin", 0.025, 0.025, 0.025, "Styk");
        this.opretLaegemiddel("Methotrexat", 0.01, 0.015, 0.02, "Styk");

        this.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
                storage.getAllPatienter().get(0), storage.getAllLaegemidler()
                        .get(1),
                123);

        this.opretPNOrdination(LocalDate.of(2021, 2, 12), LocalDate.of(2021, 2, 14),
                storage.getAllPatienter().get(0), storage.getAllLaegemidler()
                        .get(0),
                3);

        this.opretPNOrdination(LocalDate.of(2021, 1, 20), LocalDate.of(2021, 1, 25),
                storage.getAllPatienter().get(3), storage.getAllLaegemidler()
                        .get(2),
                5);

        this.opretPNOrdination(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 12),
                storage.getAllPatienter().get(0), storage.getAllLaegemidler()
                        .get(1),
                123);

        this.opretDagligFastOrdination(LocalDate.of(2021, 1, 10),
                LocalDate.of(2021, 1, 12), storage.getAllPatienter().get(1),
                storage.getAllLaegemidler().get(1), 2, 0, 1, 0);

        LocalTime[] kl = {LocalTime.of(12, 0), LocalTime.of(12, 40),
                LocalTime.of(16, 0), LocalTime.of(18, 45)};
        double[] an = {0.5, 1, 2.5, 3};

        this.opretDagligSkaevOrdination(LocalDate.of(2021, 1, 23),
                LocalDate.of(2021, 1, 24), storage.getAllPatienter().get(1),
                storage.getAllLaegemidler().get(2), kl, an);
    }

}
