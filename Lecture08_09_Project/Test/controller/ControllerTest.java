package controller;

import controller.Controller;
import ordination.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static controller.Controller.opretPNOrdination;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Patient patient;
    private Laegemiddel laegemiddel;

    @BeforeEach
    public void setUp() {
        patient = new Patient("1234567", "Bo", 55);
        laegemiddel = new Laegemiddel("Navn", 1.0, 2.0, 3.0, "stk");
    }

    @Test
    void testOpretPNOrdinationTC1() {
        LocalDate startDen = LocalDate.of(2023, 03, 01);
        LocalDate slutDen = LocalDate.of(2023, 03, 07);
        double antal = 2.0;
        PN pn = opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        assertEquals(startDen, pn.getStartDen());
        assertEquals(slutDen, pn.getSlutDen());
        assertEquals(antal, pn.getAntalEnheder());
    }

    @Test
    public void testOpretPNOrdinationTC2() {
        LocalDate startDen = LocalDate.of(2023, 03, 01);
        LocalDate slutDen = LocalDate.of(2023, 03, 07);
        double antal = 0;
        PN pn = opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        assertEquals(startDen, pn.getStartDen());
        assertEquals(slutDen, pn.getSlutDen());
        assertEquals(antal, pn.getAntalEnheder());
    }

    @Test
    public void testOpretPNOrdinationTC3() {
        LocalDate startDen = LocalDate.of(2023, 03, 01);
        LocalDate slutDen = LocalDate.of(2023, 03, 07);
        double antal = -2.0;
        assertThrows(IllegalArgumentException.class, () -> {
            opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
    }

    @Test
    public void testOpretPNOrdinationTC4() {
        LocalDate startDen = LocalDate.of(2023, 03, 07);
        LocalDate slutDen = LocalDate.of(2023, 03, 01);
        double antal = 1.0;
        assertThrows(IllegalArgumentException.class, () -> {
            opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
    }

    @Test
    void opretDagligFastOrdination() {
        LocalDate startDen = LocalDate.of(2023, 03, 07);
        LocalDate slutDen = LocalDate.of(2023, 03, 01);
        double antal = 1.0;
        assertThrows(IllegalArgumentException.class, () -> {
            opretPNOrdination(startDen, slutDen, patient, laegemiddel, antal);
        });
    }

    @Test
    void opretDagligSkaevOrdination() {
    }
}