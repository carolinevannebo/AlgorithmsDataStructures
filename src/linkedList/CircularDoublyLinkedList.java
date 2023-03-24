package linkedList;

import nodes.DoubleNode;

public class CircularDoublyLinkedList {
    private DoubleNode head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    public void insert(int index, int value) {
        DoubleNode newNode = new DoubleNode(value);

        if (head == null) {
            if (index != 0) {
                throw new IllegalArgumentException("Index out of range");
            }
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            if (index == 0) {
                DoubleNode lastNode = head.prev;

                newNode.next = head;
                newNode.prev = lastNode;
                head.prev = newNode;
                lastNode.next = newNode;

                head = newNode;
            } else {
                DoubleNode current = head;
                int currentIndex = 0;
                while(currentIndex < index -1) {
                    if (current.next == head) {
                        throw new IllegalArgumentException("Index out of range");
                    }
                    current = current.next;
                    currentIndex++;
                }

                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
        }
    }

    public void delete(int index) {
        if (head == null) {
            throw new IllegalArgumentException("List is empty");
        }

        if (index < 0) {
            throw new IllegalArgumentException("Index is out of range");
        }

        if (index == 0) {
            if (head.next == head) {
                head = null;
            } else {
                DoubleNode lastNode = head.prev;
                lastNode.next = head.next;
                head.next.prev = lastNode;
                head = head.next;
            }
        } else {
            DoubleNode current = head;
            int currentIndex = 0;

            while (currentIndex < index) {
                if (current.next == head) {
                    throw new IllegalArgumentException("Index out of range");
                }
                current = current.next;
                currentIndex++;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void printList() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        DoubleNode current = head;
        System.out.print("\nCircular Doubly Linked List: ");
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");
    }
}
