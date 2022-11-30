import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreds {

    private AtomicInteger counter = new AtomicInteger(0);

    public Runnable createTask(){
        return () -> {
            try {
                int id = counter.incrementAndGet();
                long timeout = (long) ((Math.random() * 10000) + 100);
                System.out.println(String.format("Task %d executing for %s", id, timeout));
                Thread.sleep(timeout);
                System.out.println(String.format("Task %d done!", id));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public void executeTask(int qnt, ExecutorService executor) throws InterruptedException {
        try (ExecutorService e = executor) {
            for (int i=0;i<qnt;i++){
                e.execute(createTask());
            }
        }
    }
}
