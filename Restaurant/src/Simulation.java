import java.util.ArrayList;
import java.util.List;

public class Simulation {
    public static void main(String[] args) {
        List<Order> queue = new ArrayList<>();

        new Thread(new Kitchen(queue)).start();
        new Thread(new Waiter(queue)).start();
        new Thread(new Waiter(queue)).start();
    }
}