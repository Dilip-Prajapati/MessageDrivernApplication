import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MessageQueue<String> messageQueue = new MessageQueue<>();
        Logger logger = new Logger();

        Producer producer = new Producer(messageQueue, 10);
        Consumer consumer = new Consumer(messageQueue, logger);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();
    }
}
