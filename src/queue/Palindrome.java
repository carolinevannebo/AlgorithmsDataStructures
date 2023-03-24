package queue;


public class Palindrome {
    public static boolean isPalindrome(String word) {
        word = word.toUpperCase(); // Convert the word to uppercase for case-insensitive comparison
        QueueLinkedListChar queue = new QueueLinkedListChar();

        // Enqueue characters of the word into the queue
        for (char c : word.toCharArray()) {
            queue.enqueue(c);
        }

        while (queue.front != queue.rear) {
            // Dequeue the first and last characters and compare them
            if (!queue.dequeue().equals(queue.dequeueRear())) {
                return false; // If the characters don't match, the word is not a palindrome
            }
        }

        return true; // If all dequeued characters match, the word is a palindrome
    }
}
