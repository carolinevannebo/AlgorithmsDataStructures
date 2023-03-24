package queue;

public abstract class BaseQueue {

    public abstract void enqueue(int value);

    public abstract Integer dequeue();

    public abstract void printQueue();
}
