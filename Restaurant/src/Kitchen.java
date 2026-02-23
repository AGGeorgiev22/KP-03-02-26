import java.util.concurrent.BlockingQueue;

public class Kitchen implements Runnable {
    private BlockingQueue<Order> queue;

    public Kitchen(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put(new Order("Pizza", 2));
            queue.put(new Order("Salad", 1));
            queue.put(new Order("Soup", 3));
        } catch (Exception e) {}
    }
}