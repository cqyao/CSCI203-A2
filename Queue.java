public class Queue {
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
