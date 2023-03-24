package array;

public class Insert {

    /*  In Java, arrays have a fixed size, so you cannot directly insert elements without creating a new array.
        To insert an element at the start, end, or any random index, you'll need to create a new array with a size
        one greater than the original array, copy the elements, and insert the new element at the desired position.*/

    public static void main(String[] args) {
        int[] S = {10, 7, 11, 5, 13, 8, 38, 37, 14, 92, 84, 74, 77, 20, 40, 47, 33, 65, 62, 69, 73};

        int newValue = 42;

        System.out.println("Array starting point: ");
        printArray(S);

        // array.Insert at the start
        S = insertElement(S, 0, newValue);
        System.out.println("\nInserted " + newValue + " at index " + 0);

        System.out.println("Array after inserting at start: ");
        printArray(S);

        // array.Insert at the end
        S = insertElement(S, S.length, newValue);
        System.out.println("\nInserted " + newValue + " at index " + S.length);

        System.out.println("Array after inserting at end: ");
        printArray(S);

        // array.Insert at a random index
        int randomIndex = 5;
        S = insertElement(S, randomIndex, newValue);
        System.out.println("\nInserted " + newValue + " at index " + randomIndex);

        System.out.println("Array after inserting at index " + randomIndex + ": ");
        printArray(S);
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length -1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int[] insertElement(int[] array, int index, int value) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0, j = 0; i < newArray.length; i++) {
            if (i == index) {
                newArray[i] = value;
            } else {
                newArray[i] = array[j++];
            }
        }
        return newArray;
    }
}
