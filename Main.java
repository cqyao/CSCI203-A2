import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(60);
        Random rand = new Random();
        for (int k=0; k<=15; k++) {                         // 15 min loop
            for (int i = 0; i <= 60; i++) {                   // Create a 60 step loop
                int result = rand.nextInt(61 - 1);   // Get random number from 1-60
                System.out.println(result);
                if (result % 2 == 0) {                      // If result is even number, enqueue as an e-mail
                    myQueue.enqueue(result);
                }
            }

            for (int j = 0; j <= 30; j++) {
                int result = rand.nextInt(5 - 1); // Get a 25% chance of not dequeueing.
                if (result == 1 | result == 2 | result == 3) { // If 75% chance hit, dequeue front.
                    myQueue.dequeue();
                } else {                                  // If 25% chance hit, enqueue front and then dequeue front.
                    myQueue.enqueue(myQueue.front());
                    myQueue.dequeue();
                }
            }
        }
        System.out.println("E-mails in queue: ");
        for(int i = 0; i<=myQueue.getSize();i++) {
            System.out.println(myQueue.queue[i]);
        }
    }
}

