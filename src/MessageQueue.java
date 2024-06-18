import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue<T> {
    private final BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    public void send(T message) {
        queue.offer(message);
    }

    public T receive() throws InterruptedException {
        return queue.take();
    }
}
