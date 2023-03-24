package linkedList;

/*  In a doubly linked list, each node has a reference to the next node and the previous node.
    To insert an element, you need to create a new node with the given value and update the next and previous references accordingly.*/

import nodes.DoubleNode;

public class DoublyLinkedList {
    DoubleNode head;
    // A doubly linked list has a head reference to the first node in the list

    public DoublyLinkedList() {
        head = null;
    }

    public void insert(int index, int value) {
        // Create a new DoubleNode with the given value
        DoubleNode newNode = new DoubleNode(value);

        // If the index is 0, insert the new node at the beginning of the list
        if (index == 0) {
            // If the list is not empty, update the previous pointer of the current head node
            if (head != null) {
                head.prev = newNode;
            }
            // Set the next pointer of the new node to the current head node
            newNode.next = head;
            // Set the new node as the head of list
            head = newNode;
        } else {
            // Initialize a pointer (current) to traverse the list
            DoubleNode current = head;

            // Move the current pointer to the node just before the specified index
            for (int i = 1; i < index; i++) {
                // If the current node is null, the index is out of range
                if (current == null) {
                    throw new IllegalArgumentException("Index out of range");
                }
                // Move to the next node in the list
                current = current.next;
            }

            // If the current node is null after the loop, the index is out of range
            if (current == null) {
                throw new IllegalArgumentException("Index out of range");
            }

            // Set the previous pointer of the new node to the current node
            newNode.prev = current;
            // Set the next pointer of the new node to the node after the current node
            newNode.next = current.next;

            // If the current node has a next node, update its previous pointer
            if (current.next != null) {
                current.next.prev = newNode;
            }
            // Set the next pointer of the current node to the new node
            current.next = newNode;
        }
    }

    /*  To delete an element from a doubly linked list, you need to locate the node containing the element
        you want to delete, update the previous and next references of the adjacent nodes, and then allow the
        garbage collector to reclaim the memory used by the deleted node.*/

    public void delete(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            DoubleNode current = head;

            // Move the current pointer to the node at the specified index
            for (int i = 0; i < index; i++) {
                if (current == null) {
                    throw new IllegalArgumentException("Index is out of range");
                }
                current = current.next;
            }

            // If the current node is null, the index is out of range
            if (current == null) {
                throw new IllegalArgumentException("Index is out of range");
            }

            // Update the previous and next references of the adjacent nodes
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }

    /*  The delete method first checks if the list is empty, and if it is, it throws an IllegalStateException.
        If the index is 0, the method deletes the head node by updating the head reference to point to the second node
        in the list and setting the prev reference of the new head node to null. Otherwise, the method iterates through
        the list to find the node at the specified index, and then updates the previous and next references of the adjacent
        nodes to bypass the node to be deleted. If the specified index is out of range, the method throws an IllegalArgumentException.*/

    public void printList() {
        DoubleNode current = head;
        System.out.print("\nDoubly Linked List: ");
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
