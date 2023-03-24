package linkedList;

public class Insert {
    public static void main(String[] args) {
        // Singly linked list
        insertSinglyLinkedList();

        // Doubly linked list
        insertDoublyLinkedList();

        // Circular linked list
        insertCircularSinglyLinkedList();

        // Circular doubly linked list
        insertCircularDoublyLinkedList();
    }

    public static SinglyLinkedList insertSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.insert(0, 42);
        singlyLinkedList.insert(1, 10);
        singlyLinkedList.insert(2, 7);

        singlyLinkedList.printList();

        return singlyLinkedList;
    }

    public static DoublyLinkedList insertDoublyLinkedList() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insert(0, 42);
        doublyLinkedList.insert(1, 10);
        doublyLinkedList.insert(2, 7);

        doublyLinkedList.printList();

        return doublyLinkedList;
    }

    public static CircularSinglyLinkedList insertCircularSinglyLinkedList() {
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();

        circularSinglyLinkedList.insert(0, 42);
        circularSinglyLinkedList.insert(1, 10);
        circularSinglyLinkedList.insert(2, 7);

        circularSinglyLinkedList.printList();

        return circularSinglyLinkedList;
    }

    public static CircularDoublyLinkedList insertCircularDoublyLinkedList() {
        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();

        circularDoublyLinkedList.insert(0, 42);
        circularDoublyLinkedList.insert(1, 10);
        circularDoublyLinkedList.insert(2, 7);

        circularDoublyLinkedList.printList();

        return circularDoublyLinkedList;
    }

}
