package com.Exercises;

import com.org.DataStructure.BinaryTree;
import com.org.DataStructure.BinaryTreeImpl;
import com.org.DataStructure.TreeNode;

import java.util.TreeMap;

public class TestBinaryTree {
    public static void main(String args[]) {
        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        binaryTree.setRoot(new TreeNode(35));

        binaryTree.getRoot().setLeft(new TreeNode(8));
        binaryTree.getRoot().setRight(new TreeNode(10));

        binaryTree.getRoot().getLeft().setLeft(new TreeNode(43));
        binaryTree.getRoot().getLeft().setRight(new TreeNode(152));

        binaryTree.getRoot().getRight().setLeft(new TreeNode(31));

        System.out.println("::Preorder Traversal::");
        binaryTree.preorder(binaryTree.getRoot());
        System.out.println("\n--------------------");
        System.out.println("::Inorder traversal::");
        binaryTree.inorder(binaryTree.getRoot());
        System.out.println("\n--------------------");
        System.out.println("::Postorder traversal::");
        binaryTree.postorder(binaryTree.getRoot());
        /*TreeMap treeMap = new TreeMap();
        treeMap.put(2,21);*/
    }
}
