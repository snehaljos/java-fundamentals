package datastructures.tree;

import junit.framework.TestCase;

/**
 * @author thepn
 */
public class BinaryTreeTest extends TestCase {

    public void testIsEmpty(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        assertTrue( tree.isEmpty() );

        tree.insert( 10 );
        assertFalse( tree.isEmpty() );
    }

    public void testSize(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        assertEquals( 0, tree.size() );

        tree.insert( 10 );
        assertEquals( 1, tree.size() );

        tree.insert( 10 );
        assertEquals( 1, tree.size() );

        tree.insert( 5 );
        tree.insert( 15 );
        assertEquals( 3, tree.size() );

        tree.insert( 20 );
        assertEquals( 4, tree.size() );

        tree.remove( 15 );
        assertEquals( 3, tree.size() );
    }

    public void testRemoveRight(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 15 );
        tree.insert( 20 );
        tree.insert( 7 );
        tree.insert( 6 );
        tree.insert( 3 );

        tree.remove( 15 );
        assertEquals( 6, tree.size() );
    }

    public void testRemoveLeft(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 15 );
        tree.insert( 20 );
        tree.insert( 7 );
        tree.insert( 6 );
        tree.insert( 3 );

        tree.remove( 7 );
        assertEquals( 6, tree.size() );
    }

    public void testRemoveBoth(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 15 );
        tree.insert( 20 );
        tree.insert( 7 );
        tree.insert( 6 );
        tree.insert( 3 );

        tree.remove( 10 );
        assertEquals( 6, tree.size() );
    }

    public void testMinimum(){
        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.insert( 10 );
        tree.insert( 5 );
        tree.insert( 15 );
        tree.insert( 20 );
        tree.insert( 7 );
        tree.insert( 6 );
        tree.insert( 3 );

        assertEquals( (Integer) 3, tree.minimum() );
    }
}
