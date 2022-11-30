import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VirtualThreds virtualThreds = new VirtualThreds();
//        ExecutorService executor = Executors.newFixedThreadPool(800);
        ExecutorService executorVirtual = Executors.newVirtualThreadPerTaskExecutor();
        Instant start = Instant.now();
        virtualThreds.executeTask(1000, executorVirtual);
        Instant end = Instant.now();
        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println(String.format("Done in %d seconds", seconds));

    }

}
