package Forsikring.forsikring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BilForsikringTest {
    BilForsikring bilForsikring = new BilForsikring();

    @BeforeEach
    void setBilForsikring() {
        bilForsikring.setGrundpaemie(1000);
    }

    @Test
    void getGrundPraemie() {
        bilForsikring.setGrundpaemie(1000);
        assertEquals(1000, bilForsikring.getGrundPraemie());

    }

    @Test
    void setGrundpaemie() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bilForsikring.setGrundpaemie(-1);
        });
    }

    @Test
    void beregnPraemie() {


        Exception exception0 = assertThrows(RuntimeException.class, () -> {
            bilForsikring.setGrundpaemie(0);
            bilForsikring.beregnPraemie(18, true, 0);
        });
        Exception exception1 = assertThrows(RuntimeException.class, () -> {
            bilForsikring.setGrundpaemie(1000);
            bilForsikring.beregnPraemie(17, true, 0);
        });
        Exception exception2 = assertThrows(RuntimeException.class, () -> {
            bilForsikring.setGrundpaemie(1000);
            bilForsikring.beregnPraemie(18, true, 19);
        });
        Exception exception3 = assertThrows(RuntimeException.class, () -> {
            bilForsikring.setGrundpaemie(1000);
            bilForsikring.beregnPraemie(18, true, -1);
        });

    }

    @Test
    void TC1() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bilForsikring.beregnPraemie(16, false, 0);
        });
    }

    @Test
    void TC2() {
        assertEquals(1250, bilForsikring.beregnPraemie(18, false, 0));
    }

    @Test
    void TC3() {
        assertEquals(1250, bilForsikring.beregnPraemie(18, false, 0));
    }

    @Test
    void TC4() {
        assertEquals(850, bilForsikring.beregnPraemie(1100, false, 5));
    }

    @Test
    void TC7() {
        assertEquals(1187.5, bilForsikring.beregnPraemie(18, true, 0));
    }

    @Test
    void TC12() {
        assertThrows(RuntimeException.class, () -> {
            bilForsikring.beregnPraemie(20, false, -1);
        });
    }
    @Test
    public void testSetGrundPraemie() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        double expected = 1000;
        double actual = bilforsikring.getGrundPraemie();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testSetNegativeGrundPraemie() {
        BilForsikring bilforsikring = new BilForsikring();
        assertThrows(RuntimeException.class, () -> bilforsikring.setGrundpaemie(-1000));
    }

    @Test
    public void testBeregnPraemieWithNoGrundPraemie() {
        BilForsikring bilforsikring = new BilForsikring();
        assertThrows(RuntimeException.class, () -> bilforsikring.beregnPraemie(25, true, 3));
    }

    @Test
    public void testBeregnPraemieWithTooYoung() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        assertThrows(RuntimeException.class, () -> bilforsikring.beregnPraemie(16, true, 3));
    }

    @Test
    public void testBeregnPraemieWithSkadeFrieaerUnder18() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        assertThrows(RuntimeException.class, () -> bilforsikring.beregnPraemie(20, true, 17));
    }

    @Test
    public void testBeregnPraemieWithNegativeSkadeFrieaer() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        assertThrows(RuntimeException.class, () -> bilforsikring.beregnPraemie(30, true, -3));
    }

    @Test
    public void testBeregnPraemieWithAgeUnder25() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        double expected = 1250 * 0.95;
        double actual = bilforsikring.beregnPraemie(20, true, 3);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testBeregnPraemieWithFemale() {
        BilForsikring bilforsikring = new BilForsikring();
        bilforsikring.setGrundpaemie(1000);
        double expected = 1000 * 0.95;
        double actual = bilforsikring.beregnPraemie(30, true, 3);
        assertEquals(expected, actual, 0.01);
    }





}