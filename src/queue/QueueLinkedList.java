package queue;

import nodes.Node;

public class QueueLinkedList extends BaseQueue {

    private Node front;
    private Node rear;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
    }

    // enqueue method to add an element to the rear of the queue.
    @Override
    public void enqueue(int value) {
        // Create a new node with the input value.
        Node newNode = new Node(value);
        // If the queue is empty, set both front and rear to the new node.
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        // Otherwise, add the new node to the rear of the queue and update the rear reference.
        rear.next = newNode;
        rear = newNode;
    }

    // dequeue method to remove the front element from the queue.
    @Override
    public Integer dequeue() {
        // If the queue is empty, print an error message and return null.
        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        // Save the front element's data, then update the front reference to the next element.
        int dequeuedValue = front.data;
        front = front.next;
        // If the front becomes null, set the rear to null as well (the queue is now empty).
        if (front == null) {
            rear = null;
        }
        // Return the dequeued value.
        return dequeuedValue;
    }

    // printQueue method to display the queue content from front to rear.
    @Override
    public void printQueue() {
        // Start with the front element.
        Node current = front;
        System.out.print("\nLinked list Queue content: ");
        // Iterate through the queue elements, printing each element's data.
        while (current != null) {
            System.out.print(current.data + " ");
            // Move on to the next element in the queue.
            current = current.next;
        }
        // Print a newline to complete the output.
        System.out.println();
    }

}
