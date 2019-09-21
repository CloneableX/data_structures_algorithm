package com.clo.dsa.tree;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * com.clo.dsa.tree.AvlTreeTest
 *
 * @author Cloneable
 * @date 2019/9/14 11:20:14
 * @description unit test of AVL tree
 */
public class AvlTreeTest {

    private AvlTree avlTree;

    @Before
    public void setUp() {
        avlTree = new AvlTree();
    }

    @Test
    @Ignore
    public void should_generate_self_balance_and_binary_search_tree_when_give_nums() {
        int[] nums = new int[]{20, 13, 10};
        insertNumsToTree(nums);

        List<AvlTree.Node> sortNodes = avlTree.sortNode();
        assertThat(sortNodes.size() > 1, is(Boolean.TRUE));
        for (int i = 0; i < sortNodes.size(); i++) {
            if (i < sortNodes.size() - 1) {
                assertThat(sortNodes.get(i).data < sortNodes.get(i + 1).data, is(Boolean.TRUE));
            }

            assertThat(Math.abs(avlTree.getBalance(sortNodes.get(i))) > 1, is(Boolean.FALSE));
        }
    }

    @Test
    public void should_get_root_node_of_tree_when_insert_node_to_tree() {
        avlTree.insertNode(avlTree.getRoot(), 3);
        AvlTree.Node root = avlTree.getRoot();
        assertThat(root.data, is(3));
        assertThat(avlTree.getHeight(), is(1));
    }

    @Test
    public void should_insert_node_in_parent_left_when_insert_letter_than_parent() {
        int[] nums = {3, 1};
        insertNumsToTree(nums);
        checkNodsSorted(avlTree.sortNode());
        assertThat(avlTree.getHeight(), is(2));
    }

    @Test
    public void should_insert_node_in_parent_right_when_insert_greater_than_parent() {
        int[] nums = {3, 1, 9};
        insertNumsToTree(nums);
        checkNodsSorted(avlTree.sortNode());
        assertThat(avlTree.getHeight(), is(2));
    }

    @Test
    public void should_get_ordered_nodes_when_give_avl_tree() {
        int[] nums = new int[]{8, 12, 6, 19, 4, 3, 7};
        insertNumsToTree(nums);

        List<AvlTree.Node> sortNodes = avlTree.sortNode();
        assertThat(sortNodes.size() > 1, is(Boolean.TRUE));
        checkNodsSorted(sortNodes);
    }

    @Test
    public void should_not_balance_when_node_right_minus_left_height_abs_greater_than_one() {
        int[] nums = {10, 5, 1};
        insertNumsToTree(nums);
        assertThat(avlTree.getBalance(avlTree.getRoot()), is(0));
    }

    @Test
    public void should_rotate_right_when_node_is_left_left() {
        int[] nums = {10, 6, 12, 3, 7, 1};
        insertNumsToTree(nums);
        assertThat(avlTree.getRoot().data, is(6));
        assertThat(avlTree.getHeight(), is(3));
        checkNodsSorted(avlTree.sortNode());
    }

    @Test
    public void should_rotate_left_when_node_is_right_right() {
        int[] nums = {5, 7, 9, 6, 12, 3};
        insertNumsToTree(nums);
        assertThat(avlTree.getRoot().data, is(7));
        assertThat(avlTree.getHeight(), is(3));
        checkNodsSorted(avlTree.sortNode());
    }

    @Test
    public void should_rotate_left_then_right_when_node_is_left_right() {
        int[] nums = {10, 5, 7};
        insertNumsToTree(nums);
        assertThat(avlTree.getRoot().data, is(7));
        assertThat(avlTree.getHeight(), is(2));
    }

    private void checkNodsSorted(List<AvlTree.Node> sortNodes) {
        for (int i = 0; i < sortNodes.size(); i++) {
            if (i < sortNodes.size() - 1) {
                assertThat(sortNodes.get(i).data < sortNodes.get(i + 1).data, is(Boolean.TRUE));
            }
        }
    }

    private void insertNumsToTree(int[] nums) {
        Arrays.stream(nums).forEach(num -> avlTree.insertNode(avlTree.getRoot(), num));
    }
}
