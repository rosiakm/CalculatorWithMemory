import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseTest {

    protected static SimpleCalculatorWithMemory calculator;

    @BeforeEach
    public void setupAll(){
        calculator = new SimpleCalculatorWithMemory();
        log.info("<<<< The new calculator instance is created >>>>");
    }

    @AfterEach
    public void tearDown(){
        calculator = null;
        log.info("<<<< The calculator instance is teared down");
    }
}
