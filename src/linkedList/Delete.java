package linkedList;

public class Delete {
    public static void main(String[] args) {
        // Singly linked list
        deleteSinglyLinkedList();

        // Doubly linked list
        deleteDoublyLinkedList();

        // Circular singly linked list
        deleteCircularSinglyLinkedList();

        // Circular doubly linked list
        deleteCircularDoublyLinkedList();
    }

    public static void deleteSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList = Insert.insertSinglyLinkedList();

        // Delete element at index 1
        singlyLinkedList.delete(1);

        System.out.println("\nAfter deleting: ");
        singlyLinkedList.printList();
    }

    public static void deleteDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = Insert.insertDoublyLinkedList();

        // Delete element at index 1
        doublyLinkedList.delete(1);

        System.out.println("\nAfter deleting: ");
        doublyLinkedList.printList();
    }

    public static void deleteCircularSinglyLinkedList() {
        CircularSinglyLinkedList circularSinglyLinkedList = Insert.insertCircularSinglyLinkedList();

        // Delete element at index 1
        circularSinglyLinkedList.delete(1);

        System.out.println("\nAfter deleting: ");
        circularSinglyLinkedList.printList();
    }

    public static void deleteCircularDoublyLinkedList() {
        CircularDoublyLinkedList circularDoublyLinkedList = Insert.insertCircularDoublyLinkedList();

        //Delete element at index 1
        circularDoublyLinkedList.delete(1);

        System.out.println("\nAfter deleting: ");
        circularDoublyLinkedList.printList();
    }
}
