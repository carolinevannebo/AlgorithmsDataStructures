package linkedList;

/*  In a singly linked list, each node has a reference to the next node.
    To insert an element, you need to create a new node with the given value
    and update the next reference accordingly. */

import nodes.Node;

public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void insert(int index, int value) {
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            for (int i = 1; i < index; i++) {
                if (current == null) {
                    throw new IllegalArgumentException("Index out of range");
                }

                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /*  The insert method creates a new node with the given value and adjusts the next references accordingly.
        If the index is 0, the new node becomes the head of the list.
        Otherwise, the method iterates through the list to find the node just before the specified index,
        then inserts the new node after that node.*/

    /*  To delete an element from a singly linked list, you need to find the node just before
        the node containing the element you want to delete, update the next reference to bypass
        the node to be deleted, and then allow the garbage collector to reclaim the memory used by the deleted node.*/

    public void delete(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        // If the index is 0, delete the head node
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;

            // Move the current pointer to the node just before the specified index
            for (int i = 1; i < index; i++) {
                if (current == null) {
                    throw new IllegalArgumentException("Index is out of range");
                }
                current = current.next;
            }

            // If the current node or its next node is null, the index is out of range
            if (current == null || current.next == null) {
                throw new IllegalArgumentException("Index is out of range");
            }

            // Update the next reference to bypass the node to be deleted
            current.next = current.next.next;
        }
    }

    /*  The delete method first checks if the list is empty, and if it is, it throws an IllegalStateException.
        If the index is 0, the method deletes the head node by updating the head reference to point to the second node in the list.
        Otherwise, the method iterates through the list to find the node just before the specified index, and then updates the next reference to bypass the node to be deleted.
        If the specified index is out of range, the method throws an IllegalArgumentException.*/

    public void printList() {
        Node current = head;
        System.out.print("\nSingly Linked List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

