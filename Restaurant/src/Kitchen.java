import java.util.List;

public class Kitchen implements Runnable {
    private List<Order> queue;

    public Kitchen(List<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            synchronized (queue) {
                queue.add(new Order("Pizza", 2));
                queue.add(new Order("Salad", 1));
                queue.add(new Order("Soup", 3));
                queue.notifyAll();
            }
        } catch (Exception e) {}
    }
}