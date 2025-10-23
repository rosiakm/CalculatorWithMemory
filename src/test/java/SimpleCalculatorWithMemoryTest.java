import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
public class SimpleCalculatorWithMemoryTest extends BaseTest{

    @Test
    public void addTest(){
        log.info("Running addTest");
        assertEquals(5, calculator.add(5));
    }

    @Test
    public void subtractTest(){
        log.info("Running subtractTest");
        assertEquals(-5, calculator.subtract(5));
    }

    @Test
    public void addAndSubtractTest(){
        log.info("Running addAndSubtractTest");
        calculator.add(10);
        calculator.subtract(4);
        calculator.add(2);
        calculator.subtract(3);
        assertEquals(5, calculator.getMemory());
    }

    @Test
    public void resetAfterOperationsTest(){
        log.info("Running resetAfterOperationsTest");
        calculator.add(5);
        calculator.subtract(2);
        calculator.reset();
        assertEquals(0, calculator.getMemory());
    }

    @Test
    public void resetAfterEachOperationTest(){
        log.info("Running resetAfterEachOperationTest");
        calculator.subtract(6);
        calculator.reset();
        calculator.add(2);
        calculator.reset();
        calculator.subtract(3);
        assertEquals(-3, calculator.getMemory());
    }

    @Test
    public void addingZeroTest(){
        log.info("Running addingZeroTest");
        assertEquals(0, calculator.add(0));
    }

    @Test
    public void subtractZeroTest(){
        log.info("Running subtractZeroTest");
        assertEquals(0, calculator.subtract(0));
    }

    @Test
    public void overflowIntegerValueTest(){
        log.info("Running overflowIntegerValueTest");
        calculator.add(Integer.MAX_VALUE);
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.add(1));
        log.info(exception.getMessage());
        assertEquals("Integer overflow or underflow", exception.getMessage());
    }

    @Test
    public void underflowIntegerValueTest(){
        log.info("Running underflowIntegerValueTest");
        calculator.add(Integer.MIN_VALUE);
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.subtract(1));
        log.info(exception.getMessage());
        assertEquals("Integer overflow or underflow", exception.getMessage());
    }

    @Test
    public void addInLoopTest(){
        log.info("Running addInLoopTest");
        for (int i = 0; i < 100; i++){
            calculator.add(1);
        }
        assertEquals(100, calculator.getMemory());
    }

    @Test
    public void operationsOrderTest(){
        log.info("Running operationsOrderTest");
        SimpleCalculatorWithMemory calculator1 = new SimpleCalculatorWithMemory();

        calculator.add(5);
        calculator.subtract(3);

        calculator1.subtract(3);
        calculator1.subtract(5);

        assertNotEquals(calculator.getMemory(), calculator1.getMemory());
    }

    @Test
    public void distinctInstancesTest(){
        log.info("Running distinctInstancesTest");
        SimpleCalculatorWithMemory calculator1 = new SimpleCalculatorWithMemory();

        assertNotSame(calculator, calculator1);
    }
}
