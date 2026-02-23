import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
    private BlockingQueue<Order> queue;

    public Waiter(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Order order = queue.take();
                System.out.println("Served: " + order.quantity + " " + order.mealName);
            }
        } catch (Exception e) {}
    }
}