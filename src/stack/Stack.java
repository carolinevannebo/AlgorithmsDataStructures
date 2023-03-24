package stack;

import nodes.Node;

//  Inserts and deletes from top (FILO)
public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public Integer pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }

        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public void printStack() {
        Node current = top;
        System.out.print("Stack content: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
