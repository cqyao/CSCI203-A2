public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(10);
        myQueue.enqueue(10);
        myQueue.enqueue(1000);
        System.out.println(myQueue.getSize());
        myQueue.dequeue();
        System.out.println(myQueue.getSize());
        System.out.println(myQueue.front());
        myQueue.dequeue();
        System.out.println(myQueue.isEmpty());
    }
}

