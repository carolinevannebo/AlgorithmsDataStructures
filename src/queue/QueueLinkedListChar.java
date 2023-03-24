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
        // Save the front element's character, then update the front reference to the next element.
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
        // Iterate through the queue elements, printing each element's character.
        while (current != null) {
            System.out.print(current.character + " ");
            // Move on to the next element in the queue.
            current = current.next;
        }
        // Print a newline to complete the output.
        System.out.println();
    }

    // Additional method to dequeue from the rear of the queue
    public Character dequeueRear() {
        // If the queue is empty, print an error message and return null.
        if (front == null) {
            System.out.println("Queue is empty.");
            return null;
        }

        // If there is only one element in the queue, dequeue it and set front and rear to null.
        if (front == rear) {
            Character dequeuedValue = front.character;
            front = rear = null;
            return dequeuedValue;
        }

        // Traverse the linked list to find the second-to-last node.
        Node secondToLast = front;
        while (secondToLast.next != rear) {
            secondToLast = secondToLast.next;
        }

        // Save the rear element's character, update the second-to-last node's next reference to null,
        // and update the rear reference to point to the second-to-last node.
        Character dequeuedValue = rear.character;
        secondToLast.next = null;
        rear = secondToLast;

        // Return the dequeued value.
        return dequeuedValue;
    }

}
