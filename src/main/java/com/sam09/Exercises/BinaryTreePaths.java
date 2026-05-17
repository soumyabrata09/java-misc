/**
 * Binary Tree Paths
 * Junior
 *
 * Companies
 * Given the root of a binary tree, return all root-to-leaf paths in any order. A leaf is a node with no children. Each path should be returned as a string of node values separated by -> symbols.
 * Example 1:
 * Input:
 * ["1,2,3,null,5"]
 * Output:
 * ["1->2->5","1->3"]
 *
 * Example 2:
 * Input:
 * ["1"]
 * Output:
 * ["1"]
 * Constraints:
 * The number of nodes in the tree is in the range [1, 100]
 * Node.val is in the range [-100, 100]
 */

package com.sam09.Exercises;

import com.sam09.org.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        var paths = new ArrayList<String>();
        dfs(root, "", paths);
        return paths;
    }

    void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        var currentPath = path + node.getKey();

        if (node.getLeft() == null && node.getRight() == null) {
            paths.add(currentPath);
            return;
        }

        if (node.getLeft() != null) {
            dfs(node.getLeft(), currentPath + "->", paths);
        }

        if (node.getRight() != null) {
            dfs(node.getRight(), currentPath + "->", paths);
        }
    }

    public static void main(String[] args) {
        var obj = new BinaryTreePaths();
        var treeNode = new TreeNode("1");
        treeNode.setLeft(new TreeNode("3"));
        treeNode.setRight(new TreeNode("2"));
        treeNode.getRight().setRight(new TreeNode("5"));
        System.out.println(obj.binaryTreePaths(treeNode));
    }
}
