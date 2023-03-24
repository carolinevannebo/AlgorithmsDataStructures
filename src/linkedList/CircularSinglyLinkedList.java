package linkedList;

import nodes.Node;

public class CircularSinglyLinkedList {
    private Node head;

    public CircularSinglyLinkedList() {
        head = null;
    }

    /*  In a circular singly linked list, the last node in the list has a reference to the first node (head),
    making the list circular. To insert an element in a circular singly linked list,
    you need to create a new node, update the next reference of the new node, and update the next reference
    of the previous node (or the last node in case of inserting at the head).*/

    public void insert(int index, int value) {
        Node newNode = new Node(value);

        if (index == 0) {
            if (head == null) {
                newNode.next = newNode;
            } else {
                Node lastNode = head;
                while(lastNode.next != head) {
                    lastNode = lastNode.next;
                }
                newNode.next = head;
                lastNode.next = newNode;
            }
            head = newNode;
        } else {
            Node current = head;

            for(int i = 1; i < index; i++) {
                if (current.next == head) {
                    throw new IllegalArgumentException("Index out of range");
                }
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /*  The insert method first creates a new node with the given value.
        If the index is 0 and the list is not empty, the method finds the last node in the list,
        updates the new node's next reference to point to the head, and updates the last node's
        next reference to point to the new node. Finally, it sets the head reference to the new node.

        If the index is not 0, the method iterates through the list to find the node just before the specified index.
        If the current node's next reference is pointing to the head before reaching the index, it means the index is
        out of range, and the method throws an IllegalArgumentException. Otherwise, it inserts the new node by
        updating its next reference to point to the current node's next reference and updating the current node's next
        reference to point to the new node.*/

    public void delete(int index) {
        // Check if the list is empty, and if so, throw an exception
        if (head == null) {
            throw new IllegalStateException("Cannot delete from an empty list");
        }

        // Check if the index to delete is the head (0)
        if (index == 0) {
            // Check if there is only one element in the list (head pointing to itself)
            if (head.next == head) {
                // Set the head to null, making the list empty
                head = null;
            } else {
                // Find the last node in the list
                Node lastNode = head;
                while (lastNode.next != head) {
                    lastNode = lastNode.next;
                }
                // Update the head reference to the next node
                head = head.next;
                // Update the last node's next reference to point to the new head
                lastNode.next = head;
            }
        } else {
            // Initialize a previous node pointer starting at the head
            Node prev = head;
            // Iterate through the list to find the node just before the specified index
            for (int i = 1; i < index; i++) {
                // Check if the previous node's next reference is pointing to the head,
                // meaning the index is out of range
                if (prev.next == head) {
                    throw new IllegalArgumentException("Index out of range");
                }
                // Move the previous node pointer to the next node
                prev = prev.next;
            }

            // Check if the previous node's next reference is pointing to the head,
            // meaning the index is out of range
            if (prev.next == head) {
                throw new IllegalArgumentException("Index out of range");
            }
            // Delete the node at the specified index by updating the previous node's
            // next reference to point to the next node after the one to be deleted
            prev.next = prev.next.next;
        }
    }

    /*  The delete method first checks if the head is null, in which case it throws an IllegalStateException.
        If the index is 0, it checks if the head's next reference is pointing to itself, in which case it sets the head to null.
        Otherwise, it iterates through the list to find the last node, updates the head reference to the next node,
        and updates the last node's next reference to point to the new head.

        If the index is not 0, the method iterates through the list to find the node just before the specified index.
        If the previous node's next reference is pointing to the head before reaching the index, or if it's pointing to the head
        after reaching the index, it means the index is out of range, and the method throws an IllegalArgumentException.
        Otherwise, it deletes the node at the specified index by updating the previous node's next reference to point to
        the next node after the one to be deleted. */

    public void printList () {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        Node current = head;
        System.out.print("\nCircular Singly Linked List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("HEAD");
    }
}
