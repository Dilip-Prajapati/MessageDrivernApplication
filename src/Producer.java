public class Producer implements Runnable {
    private final MessageQueue<String> messageQueue;
    private final int messageCount;

    public Producer(MessageQueue<String> messageQueue, int messageCount) {
        this.messageQueue = messageQueue;
        this.messageCount = messageCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < messageCount; i++) {
            String message = "Message " + (i + 1);
            messageQueue.send(message);
            System.out.println("Produced: " + message);
        }
    }
}
