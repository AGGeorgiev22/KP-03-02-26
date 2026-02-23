import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Simulation {
    public static void main(String[] args) {
        BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

        new Thread(new Kitchen(queue)).start();
        new Thread(new Waiter(queue)).start();
        new Thread(new Waiter(queue)).start();
    }
}