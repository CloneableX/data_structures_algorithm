package com.clo.dsa.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * com.clo.dsa.tree.BinarySearchTreeTest
 *
 * @author Cloneable
 * @date 2019/9/1 14:11:01
 * @description test for BinarySearchTree
 */
public class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree(new int[]{5, 8, 3, 7, 2});
    }

    @Test
    public void should_search_insert_delete_sorted_print_by_binary_search_tree() {

        assertThat(binarySearchTree.search(3).value, is(3));
        assertThat(binarySearchTree.sortedPrint(), is("2,3,5,7,8"));

        binarySearchTree.insert(4);
        assertThat(binarySearchTree.sortedPrint(), is("2,3,4,5,7,8"));

        binarySearchTree.delete(7);
        assertThat(binarySearchTree.sortedPrint(), is("2,3,4,5,8"));
    }


    @Test
    public void should_get_root_when_give_one_num() {
        BinarySearchTree rootBst = new BinarySearchTree(new int[]{3});
        assertThat(rootBst.root.value, is(3));
    }

    @Test
    public void should_get_left_when_give_num_letter_than_node_num() {
        BinarySearchTree leftBst = new BinarySearchTree(new int[]{4});
        leftBst.insert(3);

        assertThat(leftBst.root.left.value, is(3));
    }

    @Test
    public void should_get_right_when_give_one_num_greater_than_node_num() {
        BinarySearchTree rightBst = new BinarySearchTree(new int[]{4});
        rightBst.insert(5);

        assertThat(rightBst.root.right.value, is(5));
    }

    @Test
    public void should_sorted_print_when_create_binary_search_tree() {
        assertThat(binarySearchTree.sortedPrint(), is("2,3,5,7,8"));
    }

    @Test
    public void should_get_node_when_give_num() {
        assertThat(binarySearchTree.search(3).value, is(3));
        assertThat(binarySearchTree.search(7).value, is(7));
        assertNull(binarySearchTree.search(1));
    }

    @Test
    public void should_delete_node_when_give_num_equals_node_num() {
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);

        assertThat(binarySearchTree.sortedPrint(), is("2,3,5,7,8,9,10"));

        binarySearchTree.delete(2);
        assertTrue(binarySearchTree.search(3).isLeaf());

        binarySearchTree.delete(5);
        BinarySearchTree.Node node78 = binarySearchTree.search(7);
        assertThat(node78.left.value, is(3));
        assertThat(node78.right.value, is(8));

        binarySearchTree.delete(8);
        BinarySearchTree.Node node79 = binarySearchTree.search(7);
        assertThat(node79.right.value, is(9));

        binarySearchTree.delete(12);
        assertThat(binarySearchTree.sortedPrint(), is("3,7,9,10"));
    }
}
