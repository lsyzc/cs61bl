/** Array Operations Class. Optional Exercise **/
public class ArrayOperations {
    /**
     * Delete the value at the given position in the argument array, shifting
     * all the subsequent elements down, and storing a 0 as the last element of
     * the array.
     */
    public static void delete(int[] values, int pos) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        // TODO: fill out this function
        int length = values.length;
        while (pos < length - 1) {
            values[pos] = values[pos + 1];
            pos++;
        }
        values[length - 1] = 0;
    }

    /**
     * Insert newInt at the given position in the argument array, shifting all
     * the subsequent elements up to make room for it. The last element in the
     * argument array is lost.
     */
    public static void insert(int[] values, int pos, int newInt) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
        int end = values.length - 2;
        while (end >= pos) {
            values[end + 1] = values[end];
            end --;
        }
        values[pos] = newInt;
        // TODO: fill out this function
    }

    /** 
     * Returns a new array consisting of the elements of A followed by the
     *  the elements of B. 
     */
    public static int[] catenate(int[] A, int[] B) {
        // TODO: fill out this function
        int a_length = A.length;
        int b_length = B.length;
        int[] result = new int[a_length + b_length];
        System.arraycopy(A, 0, result, 0, A.length);
        System.arraycopy(B, 0, result, a_length, B.length);
        return result;
    }

}