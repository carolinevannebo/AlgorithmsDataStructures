package queue;

public class QueueArray extends BaseQueue{

    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = this.rear = -1;
    }
    @Override
    public void enqueue(int value) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full.");
            return;
        }

        if (front == -1 && rear == -1) {
            front = rear = 0;
        } else {
            rear++;
        }
        queueArray[rear] = value;
    }

    @Override
    public Integer dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return null;
        }

        int dequeuedValue = queueArray[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }

        return dequeuedValue;
    }

    @Override
    public void printQueue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("\nArray Queue content: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }
}
