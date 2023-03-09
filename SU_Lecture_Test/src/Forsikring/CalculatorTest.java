package Forsikring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

//class CalculatorTest {
//
//    private Calculator calculator = new Calculator();
//
//    @BeforeEach
//    void setUp() {
//        calculator.clear();
//    }
//
//    @Test
//    void add() {
//        calculator.add(2);
//        calculator.add(6);
//        assertEquals(8, calculator.getResult());
//    }
//
//    @Test
//    void subtract() {
//        calculator.add(12);
//        calculator.subtract(4);
//        assertEquals(8, calculator.getResult());
//    }
//
//    @Test
//    void multiply() {
//        calculator.add(12);
//        calculator.multiply(3);
//        assertEquals(36, calculator.getResult());
//    }
//
//    @Test
//    void divide() {
//        calculator.add(12);
//        calculator.divide(4);
//        assertTrue(calculator.getResult() == 3);
//    }
//
//    @Test
//    void divideZero() {
//        calculator.add(12);
//        Exception exception = assertThrows(RuntimeException.class,() ->{
//            calculator.divide(0);
//        });
//    }
//
//    @Test
//    void square() {
//    }
//
//   @Disabled
//   @Test
//    void squareRoot() {
//        assertTimeoutPreemptively(Duration.ofMillis(1000), ()->calculator.squareRoot());
//    }
//
//    @Test
//    void clear() {
//    }
//}