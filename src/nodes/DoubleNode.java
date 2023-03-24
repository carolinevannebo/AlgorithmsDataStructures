package nodes;

/*  DoubleNode class represents a node in the doubly linked list */
public class DoubleNode {
    public int data;
    public DoubleNode prev;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
