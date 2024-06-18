
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MessageDrivenApplicationTest {
    private MessageQueue<String> messageQueue;
    private Logger logger;
    private ExecutorService executorService;

    @Before
    public void setUp() {
        messageQueue = new MessageQueue<>();
        logger = new Logger();
        executorService = Executors.newFixedThreadPool(2);
    }

    @Test
    public void testSuccessfulProcessing() throws InterruptedException {
        Producer producer = new Producer(messageQueue, 10);
        Consumer consumer = new Consumer(messageQueue, logger);

        executorService.submit(producer);
        executorService.submit(consumer);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(10, logger.getSuccessCount());
        assertEquals(0, logger.getErrorCount());
    }

    @Test
    public void testErrorProcessing() throws InterruptedException {
        Consumer faultyConsumer = new Consumer(messageQueue, logger) {
            @Override
            public void run() {
                while (true) {
                    try {
                        messageQueue.receive();
                        throw new RuntimeException("Simulated error");
                    } catch (Exception e) {
                        logger.logError();
                    }
                }
            }
        };

        Producer producer = new Producer(messageQueue, 10);
        executorService.submit(producer);
        executorService.submit(faultyConsumer);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        assertEquals(0, logger.getSuccessCount());
        assertEquals(10, logger.getErrorCount());
    }
}
