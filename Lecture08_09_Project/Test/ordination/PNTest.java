package ordination;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNTest {

    @org.junit.jupiter.api.Test
    void givDosis() {
        // Opret Laegemiddel-objekt
        Laegemiddel lm = new Laegemiddel("Paracetamol", 0.1, 0.2, 0.3, "mg");

        // Opret PN-objekt med Laegemiddel-objekt og datoer
        PN pn = new PN(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28), lm, 10);

        // Test givDosis-metoden
        LocalDate givesDen = LocalDate.of(2023, 2, 2);
        assertTrue(pn.givDosis(givesDen));

        givesDen = LocalDate.of(2023, 3, 1);
        assertFalse(pn.givDosis(givesDen));
    }

    @org.junit.jupiter.api.Test
    void doegnDosisMed4() {
    // Opret Laegemiddel-objekt
    Laegemiddel lm = new Laegemiddel("Paracetamol", 0.1, 0.2, 0.3, "mg");

    // Opret PN-objekt med Laegemiddel-objekt og datoer
    PN pn = new PN(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28), lm, 10);

    // givDosis() for at tilføje elementer i datoerForGivetDosis-array
    pn.givDosis(LocalDate.of(2023,2,20));
    pn.givDosis(LocalDate.of(2023,2,21));
    pn.givDosis(LocalDate.of(2023,2,22));
    pn.givDosis(LocalDate.of(2023,2,23));

    assertEquals(10, pn.doegnDosis());
    }

    @org.junit.jupiter.api.Test
    void doegnDosisMed0Enheder() {
        // Opret Laegemiddel-objekt
        Laegemiddel lm = new Laegemiddel("Paracetamol", 0.1, 0.2, 0.3, "mg");

        // Opret PN-objekt med Laegemiddel-objekt og datoer
        PN pn = new PN(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28), lm, -5);

        // givDosis() for at tilføje elementer i datoerForGivetDosis-array
        pn.givDosis(LocalDate.of(2023,2,20));
        pn.givDosis(LocalDate.of(2023,2,21));
        pn.givDosis(LocalDate.of(2023,2,22));
        pn.givDosis(LocalDate.of(2023,2,23));

        assertEquals(0, pn.doegnDosis());
    }

    @org.junit.jupiter.api.Test
    void doegnDosisMed0GivetDosis() {
        // Opret Laegemiddel-objekt
        Laegemiddel lm = new Laegemiddel("Paracetamol", 0.1, 0.2, 0.3, "mg");

        // Opret PN-objekt med Laegemiddel-objekt og datoer
        PN pn = new PN(LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 28), lm, 10);

        // givDosis() for at tilføje elementer i datoerForGivetDosis-array

        assertEquals(0, pn.doegnDosis());
    }


    @org.junit.jupiter.api.Test
    void getAntalEnheder() {
    }

    @org.junit.jupiter.api.Test
    void getType() {
    }
}