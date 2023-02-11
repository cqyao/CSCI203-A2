import java.util.Random;

public class Main {
    static Queue receiveQueue = new Queue(60);

    public static void main(String[] args) {

        Random rand = new Random();
        // Queue emails at avg of 30 per min. Using rng of about 50% out of 60 loops
        for (int i = 0; i <= 60; i++) {                         // Loop running from 0 to 60 times
            int result = rand.nextInt(61 - 1);           // Random number from 1 to 60
            if (result % 2 == 0) {                              // If random number is even, enqueue.
                receiveQueue.enqueue(result);
            }
        }
        System.out.println("before: ");
        receiveQueue.printQueue();


        for (int i = 0; i <= receiveQueue.getSize(); i++) {     // Loop running from 0 until counter <= Q size.
            int result = rand.nextInt(5 - 1);            // Random number from 1 to 4
            if (result == 1 || result == 2 || result == 3) {    // If random number equals to 1, 2, or 3...
                receiveQueue.dequeue();                         // ... Then dequeue the front.
            }else{                                              // If not,
                int reQueue = receiveQueue.getFront();          // Temp assign front element to a variable
                receiveQueue.enqueue(reQueue);                  // Enqueue the front element
                receiveQueue.dequeue();                         // Then dequeue the front element
            }
        }
        System.out.println("after: ");
        receiveQueue.printQueue();
    }
}

