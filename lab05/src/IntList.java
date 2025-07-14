import edu.princeton.cs.algs4.In;

/** A data structure to represent a Linked List of Integers.
 * Each IntList represents one node in the overall Linked List.
 */

public class IntList {

    /** The integer stored by this node. */
    public int item;
    /** The next node in this IntList. */
    public IntList next;

    /** Constructs an IntList storing ITEM and next node NEXT. */
    public IntList(int item, IntList next) {
        this.item = item;
        this.next = next;
    }

    /** Constructs an IntList storing ITEM and no next node. */
    public IntList(int item) {
        this(item, null);
    }

    /** Returns an IntList consisting of the elements in ITEMS.
     * IntList L = IntList.list(1, 2, 3);
     * System.out.println(L.toString()) // Prints 1 2 3 */
    public static IntList of(int... items) {
        /** Check for cases when we have no element given. */
        if (items.length == 0) {
            return null;
        }
        /** Create the first element. */
        IntList head = new IntList(items[0]);
        IntList last = head;
        /** Create rest of the list. */
        for (int i = 1; i < items.length; i++) {
            last.next = new IntList(items[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * Returns [position]th item in this list. Throws IllegalArgumentException
     * if index out of bounds.
     *
     * @param position, the position of element.
     * @return The element at [position]
     */
    public int get(int position) {
        // TODO: YOUR CODE HERE
        int i = 0;
        IntList current = this;

        if (position < 0) {
            throw new IllegalArgumentException();
        }
        while (i < position) {
            if (current.next == null) {
                throw new IllegalArgumentException();
            }
            current = current.next;
            i++;
        }


        return current.item;
    }

    /**
     * Returns the string representation of the list. For the list (1, 2, 3),
     * returns "1 2 3".
     *
     * @return The String representation of the list.
     */
    public String toString() {
//        String result = "";
//        // TODO: YOUR CODE HERE
//        int i = 0;
//        IntList current = this;
//        while(current.next !=null) {
//            result = result + current.item + " ";
//            current = current.next;
//        }
//        result = result + current.item;
//        return result;
        String result = "";
        IntList current = this;
        while (current != null) {
            if (current.next != null)
                result += current.item + " ";
            else
                result += current.item;
            current = current.next;
        }
        return result;
    }

    /**
     * Returns whether this and the given list or object are equal.
     *
     * NOTE: A full implementation of equals requires checking if the
     * object passed in is of the correct type, as the parameter is of
     * type Object. This also requires we convert the Object to an
     * IntList, if that is legal. The operation we use to do this is called
     * casting, and it is done by specifying the desired type in
     * parentheses. An example of this is `IntList otherLst = (IntList) obj;`
     * We recommend reviewing the `instanceOf` keyword mentioned in the spec.
     *
     * @param obj, another list (object)
     * @return Whether the two lists are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof IntList otherList) {
            // TODO: your code here
            IntList current = this;
            while (current.next != null && otherList.next != null) {
                if (current.item != otherList.item) {
                    return false;
                }
                current = current.next;
                otherList = otherList.next;
            }
            if (current.next != null || otherList.next != null) {
                return false; //虽然公有的部分都相等，但长度不等的情况
            }
            return current.item == otherList.item;
        }
        return false;
    }

    /**
     * Adds the given value at the end of the list.
     *
     * @param value, the int to be added.
     */
    public void add(int value) {
        // TODO: YOUR CODE HERE
//        IntList current = this;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = new IntList(value);
        IntList current = this;
        while (true) {
            if (current.next == null) {
                current.next = new IntList(value);
                break;
            }
            current = current.next;
        }
    }

    /**
     * Returns the smallest element in the list.
     *
     * @return smallest element in the list
     */
    public int smallest() {
        // TODO: YOUR CODE HERE
//        IntList current = this;
//        int smallest = Integer.MAX_VALUE;
//        while (current.next != null) {
//            if (current.item < smallest) {
//                smallest = current.item;
//            }
//            current = current.next;
//        }
//        if (current.item < smallest) {
//            smallest = current.item; //单元素情况下，while循环不会执行，忽略第一个元素与smallest比较的情况了。
//        }
//        return smallest;
        int smallest = Integer.MAX_VALUE;
        IntList current = this;
        while (current != null) {
            if (current.item < smallest) {
                smallest = current.item;
            }
            current = current.next;
        }
        return smallest;
    }

    /**
     * Returns the sum of squares of all elements in the list.
     *
     * @return The sum of squares of all elements.
     */
    public int squaredSum() {
        // TODO: YOUR CODE HERE
        int result = 0;
        IntList current = this;
        while (current != null) {
            result += (int) Math.pow(current.item,2);
            current = current.next;
        }
        return result;
    }

    /**
     * Destructively squares each item of the list.
     *
     * @param L list to destructively square.
     */
    public static void dSquareList(IntList L) {
        while (L != null) {
            L.item = L.item * L.item;
            L = L.next;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.item * L.item, null);
        IntList ptr = res;
        L = L.next;
        while (L != null) {
            ptr.next = new IntList(L.item * L.item, null);
            L = L.next;
            ptr = ptr.next;
        }
        return res;
    }

    /** Returns a list equal to L with all elements squared. Non-destructive.
     *
     * @param L list to non-destructively square.
     * @return the squared list.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.item * L.item, squareListRecursive(L.next));
    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * non-destructively (no modifications to A).
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList catenate(IntList A, IntList B) {
        // TODO: YOUR CODE HERE
        //非破坏性可以复制 一次 A 然后再链接到 B

        // 递归实现
//        if (A == null) {
//            return B;
//        }
//        else {
//            return new IntList(A.item,catenate(A.next,B));
//        }

        //迭代实现
        if (A == null) return B;
        IntList head = new IntList(A.item,null);
        IntList current = head;
        A = A.next;
        while (A != null) {
            current.next = new IntList(A.item,null);
            current = current.next;
            A = A.next;
        }
        current.next = B;
        return head;

    }

    /**
     * Returns a new IntList consisting of A followed by B,
     * destructively (make modifications to A).
     *
     * @param A list to be on the front of the new list.
     * @param B list to be on the back of the new list.
     * @return new list with A followed by B.
     */
    public static IntList dcatenate(IntList A, IntList B) {
        // TODO: YOUR CODE HERE
        if (A == null) {return B;}
        if (B == null) {return A;}
        IntList current = A;
        while (current != null) { // 这样current != null always true
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = B;
        return A;
    }
}
