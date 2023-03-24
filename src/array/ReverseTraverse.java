package array;

public class ReverseTraverse {

    public static void main(String[] args) {
        int[] S = {10, 7, 11, 5, 13, 8, 38, 37, 14, 92, 84, 74, 77, 20, 40, 47, 33, 65, 62, 69, 73};

        for (int i = S.length - 1; i >= 0; i--) {
            System.out.println(S[i]);
        }

        // N is the last index and 0 is the first index.
    }
}
