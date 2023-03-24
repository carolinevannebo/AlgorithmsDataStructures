package array;

public class Delete {

    public static void main(String[] args) {
        int[] S = {10, 7, 11, 5, 13, 8, 38, 37, 14, 92, 84, 74, 77, 20, 40, 47, 33, 65, 62, 69, 73};

        System.out.println("Array starting point: ");
        printArray(S);

        // array.Delete at the start
        S = deleteElement(S, 0);
        System.out.println("\nArray after deleting at start: ");
        printArray(S);

        // array.Delete at the end
        S = deleteElement(S, S.length -1);
        System.out.println("\nArray after deleting at end: ");
        printArray(S);

        // array.Delete at random index
        int randomIndex = 5;
        S = deleteElement(S, randomIndex);
        System.out.println("\nArray after deleting at index " + randomIndex + ": ");
        printArray(S);

    }

    public static int[] deleteElement(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("Index out of range");
        }

        int[] newArray = new int[array.length -1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
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
}
