public class Queue {
    int[] queue;
    int rear;
    int front;
    int size; // total number of elements in queue

    public Queue(int sizeOfArray) {
        queue = new int[sizeOfArray];
        rear = 0;
        front = 0;
        size = 0;
    }

    public boolean isEmpty() { // Checks if the queue is empty and returns true or false.
        return size==0;
    }

    public boolean isFull() {
        return size==60;
    }

    public void enqueue(int element) { //Method for queueing elements into Queue
        if(!isFull()) {
            queue[rear] = element;
            rear = (rear + 1) % 60;
            size++;
        }
        else {
            System.out.println("Queue is full");
        }
    }

    public void dequeue() { // Method for dequeueing front element
        if(!isEmpty()) {
            int data = queue[front];
            front = (front + 1) % 60;
            size--;
        }
        else {
            System.out.println("Queue is empty");
        }
    }

    public void printQueue() {
        for(int i=0; i<size; i++)
        {
            System.out.println(queue[(front+i)%getSize()]);
        }
    }

    public int getFront() { // Returns element at front
        return queue[front];
    }

    public int getSize() {  // Returns size of queue
        return size;
    }
}
