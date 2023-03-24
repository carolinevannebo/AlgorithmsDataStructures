package nodes;

public class Node {
    public int data;
    public Character character;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(Character character) {
        this.character = character;
        this.next = null;
    }
}
