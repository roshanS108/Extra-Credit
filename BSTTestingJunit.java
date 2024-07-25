import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BSTTestingJunit {
    BSTTestingJunit<Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
    }
    @Test
    public void testInsertAndSearch() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        assertNotNull(bst.search(20));
        assertEquals(Integer.valueOf(20), bst.search(20).data);
        assertNotNull(bst.search(10));
        assertEquals(Integer.valueOf(10), bst.search(10).data);
        assertNotNull(bst.search(30));
        assertEquals(Integer.valueOf(30), bst.search(30).data);
        assertNotNull(bst.search(5));
        assertEquals(Integer.valueOf(5), bst.search(5).data);
        assertNotNull(bst.search(15));
        assertEquals(Integer.valueOf(15), bst.search(15).data);
        assertNotNull(bst.search(25));
        assertEquals(Integer.valueOf(25), bst.search(25).data);
        assertNotNull(bst.search(35));
        assertEquals(Integer.valueOf(35), bst.search(35).data);
        assertNull(bst.search(40)); // Should not find this value
    }

    @Test
    public void testDeleteLeafNode() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        assertNotNull(bst.search(5));
        bst.delete(5);
        assertNull(bst.search(5));
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        assertNotNull(bst.search(25));
        bst.delete(25);
        assertNull(bst.search(25)); // Ensure 25 is deleted
        assertNotNull(bst.search(35)); // Ensure 35 is still there
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        bst.delete(20); // Node with two children
        assertNull(bst.search(20)); // Ensure node 20 is deleted
        assertNotNull(bst.search(10));
        assertNotNull(bst.search(30));
        assertNotNull(bst.search(5));
        assertNotNull(bst.search(15));
        assertNotNull(bst.search(25));
        assertNotNull(bst.search(35));
    }

    @Test
    public void testInorder() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        bst.inorder();
        System.out.println("--------------");
    }

    @Test
    public void testBfs() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(15);
        bst.insert(25);
        bst.insert(35);

        bst.bfs();
        System.out.println("--------------");
    }
}
