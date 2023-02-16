import java.util.Random;
public class QueueSim {

    static double totalProcessed;
    static double totalSent;
    static double totalLeft;
    static double totalReQ;
    static int[] attempts = new int[16];
    public static void main(String[] args) {
        Random rand = new Random();
        Queue myQueue = new Queue(1000);

// 1. Simulate the arrival of eMails
        // Randomly generate a number between 0 and 60.
        for (int k = 1; k <= 15; k++) {
            int currentSent = 0;
            int numOfAdd = rand.nextInt(61);
            // System.out.println("Generating " + numOfAdd + " emails.");
            totalProcessed += numOfAdd;
            // Push x number of email into the queue Q
            for (int i = 0; i < numOfAdd; i++) {
                myQueue.enqueue(i);
            }

// 2. Simulate the processing of eMails
        final int qSize = myQueue.size(); // This is the Q size before any deQ operations happen.
        // Simulate 25% of Emails that fail to send and requeue them.
        for (int i = 0; i < qSize; i++) {
            int randIndex = rand.nextInt(5);
            if (randIndex > 3) {
                int temp = myQueue.front();
                myQueue.enqueue(temp);
                myQueue.dequeue();
                totalReQ++;
            } else { // Simulate the 75% that can send.
                myQueue.dequeue();
                currentSent++;
            }
        }
        totalLeft += myQueue.size();    // Add up the total left in queue after all attempts.
        attempts[k] = currentSent; // Add the Emails sent in each attempt into an array.
        totalSent+=currentSent; // Add up total sent after all attempts.
    }
        // Print out the data collected
        System.out.printf("Total number of messages processed: %28.0f\n" +
                "Average arrival rate: %42.2f\n" +
                "Average number of messages sent per minute: %20.2f\n" +
                "Average number of messages in the queue per minute: %12.2f\n" +
                "Average number of times messages had to be requeued: %11.2f\n" +
                "Number of messages sent on 1st attempt: %16d\n" +
                "Number of messages sent on 2nd attempt: %16d\n" +
                "Number of messages sent on 3rd attempt: %16d\n" +
                "Number of messages sent on 4th attempt: %16d\n" +
                "Number of messages sent on 5th attempt: %16d\n" +
                "Number of messages sent on 6th attempt: %16d\n" +
                "Number of messages sent on 7th attempt: %16d\n" +
                "Number of messages sent on 8th attempt: %16d\n" +
                "Number of messages sent on 9th attempt: %16d\n" +
                "Number of messages sent on 10th attempt: %15d\n" +
                "Number of messages sent on 11th attempt: %15d\n" +
                "Number of messages sent on 12th attempt: %15d\n" +
                "Number of messages sent on 13th attempt: %15d\n" +
                "Number of messages sent on 14th attempt: %15d\n" +
                "Number of messages sent on 15th attempt: %15d\n", totalProcessed, (totalProcessed/15), (totalSent/15), (totalLeft/15) , (totalReQ/totalProcessed), attempts[1], attempts[2], attempts[3], attempts[4], attempts[5], attempts[6], attempts[7], attempts[8], attempts[9], attempts[10], attempts[11], attempts[12], attempts[13], attempts[14], attempts[15]);

    }
}

// Queue implementation
class Queue {
    private int maxSize; // Holds the max size of the queue.
    int[] qArray; // The array to store emails in the queue
    private int front; // Front pointer of the queue (first element)
    private int rear; // Rear pointer of the queue (last element)
    private int nItems;

    // Constructor
    public Queue(int qSize) {
        maxSize = qSize;
        qArray = new int[maxSize];
        front = 0;
        rear = 0;
        nItems = 0;
    }

    // Queue functions
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full ");
        }
        qArray[rear] = item;
        // rear = (rear+1) % qArray.length;
        rear++;
        nItems++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty ");
        }
        front++;
        nItems--;
    }

    public int front() {
        return qArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }
    public void printQ() {
        for (int i = 0; i<nItems;i++) {
            System.out.println(qArray[i+front]);
        }
    }
}
