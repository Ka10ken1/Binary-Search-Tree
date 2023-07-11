import com.algorithms.IndexedBST;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IndexedBSTTest {

    @Test
    public void testInsert() {
        IndexedBST<Integer> bst = new IndexedBST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        List<Pair<Integer, Integer>> expected = Arrays.asList(
                new Pair<>(7, 2),
                new Pair<>(8, 3),
                new Pair<>(9, 4),
                new Pair<>(10, 5),
                new Pair<>(11, 6),
                new Pair<>(12, 7),
                new Pair<>(13, 8)
        );
        List<?> actual = bst.toList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        IndexedBST<Integer> bst = new IndexedBST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.remove(7);
        bst.remove(2);

        List<Pair<Integer, Integer>> expected = Arrays.asList(
                new Pair<>(5, 3),
                new Pair<>(6, 4),
                new Pair<>(7, 5),
                new Pair<>(8, 6),
                new Pair<>(9, 7)
        );
        List<?> actual = bst.toList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetElementAtIndex() {
        IndexedBST<Integer> bst = new IndexedBST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        int expectedElementAtIndex5 = 7;
        int actualElementAtIndex5 = bst.getElementAtIndex(5);

        Assert.assertEquals(expectedElementAtIndex5, actualElementAtIndex5);
    }

    @Test
    public void testGetIndex() {
        IndexedBST<Integer> bst = new IndexedBST<>(5);

        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        int expectedIndexForElement7 = 5;
        int actualIndexForElement7 = bst.getIndex(7);

        Assert.assertEquals(expectedIndexForElement7, actualIndexForElement7);
    }
}
