package stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(8);

        System.out.println("Pushed elements: 2, 5, 1, 8");

        stack.push(4);

        System.out.println("Pushed another element: 4");

        stack.printStack();

        int poppedValue = stack.pop();
        System.out.println("Popped value: " + poppedValue);

        stack.printStack();
    }
}
