public class Consumer implements Runnable {
    private final MessageQueue<String> messageQueue;
    private final Logger logger;

    public Consumer(MessageQueue<String> messageQueue, Logger logger) {
        this.messageQueue = messageQueue;
        this.logger = logger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messageQueue.receive();
                System.out.println("Consumed: " + message);
                logger.logSuccess();
            } catch (Exception e) {
                logger.logError();
            }
        }
    }
}
