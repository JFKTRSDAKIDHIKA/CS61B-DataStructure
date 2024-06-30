package deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();

    }

    @Test
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", ad1.isEmpty());

        ad1.addLast(20);
        ad1.addLast(10);

        // should not be empty

        assertFalse("lld1 should contain 1 item", ad1.isEmpty());
        System.out.println("Printing out deque: ");
        ad1.printDeque();

        ad1.removeFirst();
        System.out.println("Printing out deque: ");
        ad1.printDeque();

        ad1.removeLast();
        System.out.println("Printing out deque: ");
        ad1.printDeque();

        ad1.printDeque();
        // should be empty
        //assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    public void bigDequeTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 1000000; i++) {
         assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
         }

        /**for (double i = 1000000-1; i >= 0; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }*/
    }


}
