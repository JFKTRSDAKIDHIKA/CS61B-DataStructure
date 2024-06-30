package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {

    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<String> ld1 = new AListNoResizing<>();
        BuggyAList<String> ld2 = new BuggyAList<>();
        ld1.addLast("first");
        ld2.addLast("first");
        ld1.addLast("second");
        ld2.addLast("second");
        ld1.addLast("third");
        ld2.addLast("third");
        assert (ld1.removeLast()).equals(ld2.removeLast()) : "Strings are not equal";
        assert (ld1.removeLast()).equals(ld2.removeLast()) : "Strings are not equal";
        assert (ld1.removeLast()).equals(ld2.removeLast()) : "Strings are not equal";
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BB = new BuggyAList<>();

        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BB.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizel = L.size();
                int sizeBB = BB.size();
                assert sizel == sizeBB : "Sizes are not equal";
                //System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                if(L.size() != 0 && BB.size()!=0 ){
                    int Lastl = L.getLast();
                    int LastBB = BB.getLast();
                    //System.out.println("getLast(" + Last + ")");
                    assert Lastl == LastBB : "The Last items are not equal";
                }
            } else if (operationNumber == 3) {
                if(L.size() != 0 && BB.size()!=0){
                    int RemoveLastl = L.removeLast();
                    int RemoveLastBB = BB.removeLast();
                    //System.out.println("removeLast(" + RemoveLast + ")");
                    assert RemoveLastl == RemoveLastBB : "The removed items are not equal";

                }

            }
        }
    }



}
