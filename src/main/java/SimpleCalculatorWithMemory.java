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
        memory = memory + a;
        log.info("Memory state after add: {}", memory);
        return memory;
    }

    public int subtract(int a){
        log.info("Memory state: {} | Subtracting: {}",memory, a);
        memory = memory - a;
        log.info("Memory state after subtract: {}", memory);
        return memory;
    }

    public void reset(){
        log.info("Resetting the memory state");
        memory = 0;
    }


}
