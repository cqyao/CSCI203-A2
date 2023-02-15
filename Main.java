import java.util.Random;
public class Main {

    static int totalProcessed;
    static int totalSent;
    static int totalLeft;
    static int totalReQ;
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

//            System.out.println("Arrival Q: ");
//            myQueue.printQ();

            // 2. Simulate the processing of eMails
            // Generate and mark 25% of eMails that fail to send.
            final int numOfDQ = (int) (myQueue.size() * 0.25);
            final int qSize = myQueue.size(); // This is the Q size before any deQ operations happen.
            for (int i = 0; i < qSize; i++) {
                int randIndex = rand.nextInt(5);
                if (randIndex > 3) {
                    int temp = myQueue.front();
                    myQueue.enqueue(temp + 100);
                    myQueue.dequeue();
                    totalReQ++;
                } else {
                    myQueue.dequeue();
                    totalSent++;
                    currentSent++;
                }
            }
            totalLeft += myQueue.size();
            attempts[k] = (qSize - currentSent);
        }
            System.out.printf("Total number of messages processed: %28d " +
                    "\nAverage number of messages sent per minute: %20d\n" +
                    "Average number of messages in queue per minute: %16d\n" +
                    "Average number of times messages had to be requeued: %11d\n" +
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
                    "Number of messages sent on 15th attempt: %15d\n", totalProcessed, (totalSent/15), (totalLeft/15), (totalReQ/15), attempts[1], attempts[2], attempts[3], attempts[4], attempts[5], attempts[6], attempts[7], attempts[8], attempts[9], attempts[10], attempts[11], attempts[12], attempts[13], attempts[14], attempts[15]);

    }
}