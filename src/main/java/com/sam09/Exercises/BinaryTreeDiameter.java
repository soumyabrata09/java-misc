/**
 * Diameter of Binary Tree
 * Junior
 *
 * Companies
 * Given the root of a binary tree, return the length of the diameter of the tree. The diameter is the length of the longest path between any two nodes in the tree, which may or may not pass through the root. The length of a path is represented by the number of edges between nodes.
 * Example 1:
 * Input:
 * {"root":[1,2,3,4,5]}
 * Output:
 * 3
 * Example 2:
 * Input:
 * {"root":[1,2]}
 * Output:
 * 1
 * Constraints:
 * The number of nodes in the tree is in the range [1, 10^4]
 * Node values are in the range [-100, 100]
 */

package com.sam09.Exercises;

import com.sam09.org.datastructure.TreeNode;

public class BinaryTreeDiameter {

    private int diameter = 0;

    public int getDiameter(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get the left and right depth of the subtree
        var leftDepth = dfs(node.getLeft());
        var  rightDepth = dfs(node.getRight());

        // Update the diameter if the current depth is longer
        // Diameter at the current node is the sum of left and right depth
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // Returning the max depth
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        var obj = new BinaryTreeDiameter();
        var root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));

        System.out.println(obj.getDiameter(root));
    }
}
