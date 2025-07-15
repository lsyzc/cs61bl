import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SLListTest {

    @Test
    public void testSLListAdd() {
        SLList test1 = SLList.of(1, 3, 5); /* test1: {1, 3, 5} */
        SLList test2 = new SLList(); /* test2: {} */

        test1.add(1, 2); /* test1: {1, 2, 3, 5}*/
        test1.add(3, 4); /* test1: {1, 2, 3, 4, 5}*/
        assertWithMessage("test1 does not have a size of 5").that(test1.size()).isEqualTo(5);
        assertWithMessage("test1 does not have 3 at index 2 or 4 at index 3").that(test1.equals(SLList.of(1, 2, 3, 4, 5))).isTrue();

        test2.add(1, 1); /* test2: {1} */
        assertWithMessage("test2 does not contain 1").that(test2.equals(SLList.of(1))).isTrue();
        assertWithMessage("test2 does not have a size of 1").that(test2.size()).isEqualTo(1);

        test2.add(10, 10); /* test2: {1, 10} */
        assertWithMessage("test2 is incorrect after adding at an out-of-bounds index").that(test2.equals(SLList.of(1, 10))).isTrue();
        test1.add(0, 0); /* test1: {0, 1, 2, 3, 4, 5}*/
        assertWithMessage("test1 is incorrect after addition at the front").that(test1.equals(SLList.of(0, 1, 2, 3, 4, 5))).isTrue();
    }

    @Test
    public void testSLListReverse() {
        // TODO: Add tests
        SLList test1 = SLList.of(1, 2, 3);
        SLList test2 = new SLList();
        SLList test3 = SLList.of(4);
        test1.reverse();
        test2.reverse();
        test3.reverse();
        assertWithMessage("test1 does not have a size of 3").that(test1.size()).isEqualTo(3);
        assertWithMessage("test1 does not reversed").that(test1.equals(SLList.of(3,2,1))).isTrue();
        assertWithMessage("test2 have a size of zero").that(test2.size()).isEqualTo(0);
        assertWithMessage("test3 does not have a size 1").that(test3.size()).isEqualTo(1);
        assertWithMessage("test3 reverse failed").that(test3.equals(SLList.of(4))).isTrue();



    }
}
