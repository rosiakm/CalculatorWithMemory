import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class SimpleCalculatorWithMemory {
    private int memory;

    public int add(int a){
        log.info("Memory state: {} | Adding: {}",memory, a);

        if((a > 0 && memory > Integer.MAX_VALUE - a) ||
           (a < 0 && memory < Integer.MIN_VALUE - a)){
            throw new ArithmeticException("Integer overflow or underflow");
        }
        memory = memory + a;
        log.info("Memory state after add: {}", memory);
        return memory;
    }

    public int subtract(int a){
        memory = add(-a);
        return memory;
    }

    public void reset(){
        log.info("Resetting the memory state");
        memory = 0;
    }


}
