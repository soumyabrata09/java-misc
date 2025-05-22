package com.sam09.org.datastructure;

public class BinaryTreeImpl implements BinaryTree {

    TreeNode root;

    public BinaryTreeImpl() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public void preorder(TreeNode node) {
        if (null == node) {
            return;
        }
        System.out.print(" (" + node.getKey() + ") ");
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    @Override
    public void inorder(TreeNode node) {
        if (null == node) {
            return;
        }
        inorder(node.getLeft());
        System.out.print(" (" + node.getKey() + ") ");
        inorder(node.getRight());
    }

    @Override
    public void postorder(TreeNode node) {
        if (null == node) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(" (" + node.getKey() + ") ");
    }
}
