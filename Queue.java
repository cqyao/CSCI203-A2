public class Queue {
    int[] queue;
    int rear;
    int front;
    int size; // total number of elements in queue

    public Queue(int sizeOfArray) {
        queue = new int[sizeOfArray];
        rear = -1;
        front = -1;
        size = 0;
    }

    public boolean isEmpty() { // Checks if the queue is empty and returns true or false.
        boolean response = false;
        if(size == 0) {
            response = true;
        }
        return response;
    }

    public boolean enqueue(int element) { //Method for enqueueing elements into Queue
        boolean response = false;
        if(rear != queue.length - 1) {
            rear++;
            queue[rear] = element;
            size++;
            response = true;
        }
        return response;
    }

    public int dequeue() { // Method for dequeueing front element
        int response = 0;
        if(size != 0) {
            front++;
            response = queue[front];
            size--;
        }
        return response;
    }

    public int front() { // Returns element at front
        int response = 0;
        if(!isEmpty()) {
            response = queue[front + 1];
        }
        return response;
    }

    public int getSize() {  // Returns size of queue
        return size;
    }
}
