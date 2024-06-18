import java.util.concurrent.atomic.AtomicInteger;

public class Logger {
    private final AtomicInteger successCount = new AtomicInteger();
    private final AtomicInteger errorCount = new AtomicInteger();

    public void logSuccess() {
        successCount.incrementAndGet();
    }

    public void logError() {
        errorCount.incrementAndGet();
    }

    public int getSuccessCount() {
        return successCount.get();
    }

    public int getErrorCount() {
        return errorCount.get();
    }
}
