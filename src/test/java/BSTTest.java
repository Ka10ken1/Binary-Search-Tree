import com.algorithms.BST;
import com.algorithms.IndexedBST;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BSTTest {

    @Test
    public void testInsert() {
        BST<Integer> bst = new BST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        List<Integer> actual = bst.toList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInvert(){
        BST<Integer> bst = new BST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        Collections.reverse(expected);
        List<?> actual = bst.invert().toList();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testRemove() {
        BST<Integer> bst = new BST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.remove(7);
        bst.remove(2);

        List<Integer> expected = Arrays.asList(3, 4, 5, 6, 8);
        List<Integer> actual = bst.toList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        BST<Integer> bst = new BST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        int expected = 7;
        int actual = bst.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHeight() {
        BST<Integer> bst = new BST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        int expected = 3;
        int actual = bst.height();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToList(){
        BST<Integer> bst = new BST<>(0);
        for(int i=1;i<20;i++){
            bst.insert(i);
        }
        for(int i = -19;i<=-1;i++){
            bst.insert(i);
        }
        List<Integer> arr =  List.of(-19,-18,-17,-16,-15,-14,-13,
                -12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19);
        List<Integer> list = bst.toList();
        Assert.assertEquals(arr,list);
    }
}
