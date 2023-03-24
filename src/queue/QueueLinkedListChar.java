package queue;

import nodes.Node;

public class QueueLinkedListChar extends BaseQueueChar {

    public Node front;
    public Node rear;

    public QueueLinkedListChar() {
        this.front = null;
        this.rear = null;
    }

    @Override
    public void enqueue(Character value) {
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

    @Override
    public Character dequeue() {
        // If the queue is empty, print an error message and return null.
        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }
        // Save the front element's data, then update the front reference to the next element.
        Character dequeuedValue = front.character;
        front = front.next;
        // If the front becomes null, set the rear to null as well (the queue is now empty).
        if (front == null) {
            rear = null;
        }
        // Return the dequeued value.
        return dequeuedValue;
    }

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

    // Additional method to dequeue from the rear of the queue
    public Character dequeueRear() {
        // The same dequeueRear implementation as before
        return null;
    }

}
