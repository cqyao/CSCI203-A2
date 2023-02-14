import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Queue myQueue = new Queue(1000);

// 1. Simulate the arrival of eMails
        // Randomly generate a number between 0 and 60.
        int numOfAdd = rand.nextInt(61);

        // Push x number of email into the queue Q
        for (int i = 0; i <= numOfAdd; i++) {
            myQueue.enqueue(i);
        }

//        System.out.println("before: ");
//        myQueue.printQ();

// 2. Simulate the processing of eMails
        // Generate and mark 25% of eMails that fail to send.
        final int numOfDQ = myQueue.size();
        for (int i = 0; i <= numOfDQ; i++) {
            int numOfFail = (int) Math.ceil(rand.nextInt(5));
            if (numOfFail==1) {
                int temp = myQueue.front(); // Assign temp variable to front element
                      // Enqueue the temp element
                myQueue.dequeue();          // Dequeue front element
                myQueue.enqueue(temp);
            }
            else {
                myQueue.dequeue();          // Dequeue front element
            }
        }

        myQueue.enqueue(55);
        System.out.println("after: ");
        myQueue.printQ();
        System.out.println("____");
        System.out.println(Integer.toString(myQueue.size()));
    }
}