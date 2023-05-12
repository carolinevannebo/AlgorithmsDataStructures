package array;


public class LinearSearch {
    /*  To cities.search for elements in an array, you can use a simple linear cities.search algorithm.
        This algorithm goes through the array one element at a time and compares the current element with the target element.
        If the current element matches the target, the algorithm returns the index of the current element.
        If the target element is not found, the algorithm returns -1. */

    public static void main(String[] args) {
        int[] S = {10, 7, 11, 5, 13, 8, 38, 37, 14, 92, 84, 74, 77, 20, 40, 47, 33, 65, 62, 69, 73};
        int x = 10;
        int y = 84;
        int z = 73;
        int w = 120;

        System.out.println("Index of " + x + ": " + linearSearch(S, x));
        System.out.println("Index of " + y + ": " + linearSearch(S, y));
        System.out.println("Index of " + z + ": " + linearSearch(S, z));
        System.out.println("Index of " + w + ": " + linearSearch(S, w));

        long startTime = System.nanoTime();

        int indexX = linearSearch(S, x);
        int indexY = linearSearch(S, y);
        int indexZ = linearSearch(S, z);
        int indexW = linearSearch(S, w);

        long endTime = System.nanoTime();

        long executionTime = endTime - startTime;

        System.out.println("\nExecution time: " + executionTime + " nanoseconds");
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /*  The linearSearch method iterates through the array using a for loop, comparing the current element with the target element.
        If a match is found, the index of the current element is returned.
        Otherwise, the loop continues until all elements have been checked. */

    /*  Here's an illustration of how the linear cities.search works for x = 10:
        Iteration 1: Compare S[0] (10) with target x (10) -> Match found, return index 0

       For y = 84:
        Iteration 1: Compare S[0] (10) with target y (84) -> No match, continue
        Iteration 2: Compare S[1] (7) with target y (84) -> No match, continue
        ...
        Iteration 11: Compare S[10] (84) with target y (84) -> Match found, return index 10

        For z = 73:
        Iteration 1: Compare S[0] (10) with target z (73) -> No match, continue
        ...
        Iteration 21: Compare S[20] (73) with target z (73) -> Match found, return index 20

        For x = 120:
        Iteration 1: Compare S[0] (10) with target w (120) -> No match, continue
        ...
        Iteration 21: Compare S[20] (73) with target w (120) -> No match, continue
        End of array, return -1 (element not found) */

    /** TIME COMPLEXITY
     *
     *  The time complexity of the linear cities.search algorithm is O(n), where n is the number of elements in the array.
     *  Since we're searching for four elements (x, y, z, and w) independently,
     *  the time complexity for searching all four elements would be O(4n), which is still considered O(n) in big O notation,
     *  as constant factors are usually omitted.
     *  In this specific case, with an array of length 21,
     *  the worst-case scenario would require 4 * 21 = 84 comparisons,
     *  but big O notation focuses on the general behavior as the input size grows,
     *  so the time complexity remains O(n).*/

     /*  Example 1: Array of length 5
     *  Array: [2, 4, 6, 8, 10]
     *  x = 4, y = 6, z = 10, w = 12 (w is not in the array)

     *  Search x:
     *  - Check index 0: 2 == 4? No.
     *  - Check index 1: 4 == 4? Yes, found x.

     *  Search y:
     *  - Check index 0: 2 == 6? No.
     *  - Check index 1: 4 == 6? No.
     *  - Check index 2: 6 == 6? Yes, found y.

     *  Search z:
     *  - Check index 0: 2 == 10? No.
     *  - Check index 1: 4 == 10? No.
     *  - Check index 2: 6 == 10? No.
     *  - Check index 3: 8 == 10? No.
     *  - Check index 4: 10 == 10? Yes, found z.

     *  Search w:
     *  - Check index 0: 2 == 12? No.
     *  - Check index 1: 4 == 12? No.
     *  - Check index 2: 6 == 12? No.
     *  - Check index 3: 8 == 12? No.
     *  - Check index 4: 10 == 12? No, w not found.

     *  Total comparisons: 2 + 3 + 5 + 5 = 15 (4 * 5 = 20,
     *  so worst-case scenario would be 20 comparisons)

     *  Example 2: Array of length 3
     *  Array: [3, 7, 9]
     *  x = 7, y = 9, z = 3, w = 5 (w is not in the array)

     *  Search x:
     *  - Check index 0: 3 == 7? No.
     *  - Check index 1: 7 == 7? Yes, found x.

     *  Search y:
     *  - Check index 0: 3 == 9? No.
     *  - Check index 1: 7 == 9? No.
     *  - Check index 2: 9 == 9? Yes, found y.

     *  Search z:
     *  - Check index 0: 3 == 3? Yes, found z.

     *  Search w:
     *  - Check index 0: 3 == 5? No.
     *  - Check index 1: 7 == 5? No.
     *  - Check index 2: 9 == 5? No, w not found.

     *  Total comparisons: 2 + 3 + 1 + 3 = 9 (4 * 3 = 12,
     *  so worst-case scenario would be 12 comparisons)

        In both examples, the time complexity remains O(n), where n is the number of elements in the array.
        The number of comparisons varies depending on the position of the elements being searched and if they are present in the array,
        but the overall behavior is linear with respect to the input size.
        This is why we represent the time complexity as O(n), as it represents the relationship between the input size and the number of operations performed by the algorithm.
     * */


}
