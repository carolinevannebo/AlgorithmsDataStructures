package queue;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        HandleLinkedList();
        HandleArray();
        HandlePalindrome();
    }

    public static void HandleLinkedList() {
        // Create a custom queue instance using linked list
        QueueLinkedList queueLinkedList = new QueueLinkedList();

        // Enqueue some elements.
        queueLinkedList.enqueue(1);
        queueLinkedList.enqueue(2);
        queueLinkedList.enqueue(3);

        queueLinkedList.printQueue(); // Output: Queue content: 1 2 3

        // Enqueue another element.
        queueLinkedList.enqueue(4);
        queueLinkedList.printQueue(); // Output: Queue content: 1 2 3 4

        // Dequeue the front element.
        int dequeuedLinkedListValue = queueLinkedList.dequeue();
        System.out.println("Dequeued value: " + dequeuedLinkedListValue); // Output: Dequeued value: 1

        queueLinkedList.printQueue(); // Output: Queue content: 2 3 4
    }

    public static void HandleArray() {
        // Create another custom queue instance, now using array
        QueueArray queueArray = new QueueArray(3);

        // Enqueue
        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);

        queueArray.printQueue();

        // Adding another element
        queueArray.enqueue(4); // not possible since array has fixed size
        queueArray.printQueue();

        // Dequeue the front element
        int dequeuedArrayValue = queueArray.dequeue();
        System.out.println("Dequeued value: " + dequeuedArrayValue);

        queueArray.printQueue();
    }

    public static void HandlePalindrome() {
        String input = "Madam";
        boolean isPalindrome = Palindrome.isPalindrome(input);
        System.out.println("\nIs '" + input + "' a palindrome? " + isPalindrome);
    }
}
