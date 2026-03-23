import java.util.List;

public class Waiter implements Runnable {
    private List<Order> queue;

    public Waiter(List<Order> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                Order order;
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    order = queue.remove(0);
                }
                if (order != null) {
                    System.out.println("Served: " + order.quantity + " " + order.mealName);
                }
            }
        } catch (Exception e) {}
    }
}