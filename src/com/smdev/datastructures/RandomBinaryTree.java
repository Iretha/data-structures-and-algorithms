package com.smdev.datastructures;

public class RandomBinaryTree {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Node add(Node parent, int value, boolean left) {
        Node node = new Node(value);
        if (parent == null) {
            this.root = node;
        } else {
            if (left) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return node;
    }


    public boolean hasPathSum(int sum) {
        return hasPathSum(this.root, sum);
    }

    private boolean hasPathSum(Node parent, int sum) {
        if (parent == null) {
            return sum == 0;
        }

        sum -= parent.data;
        return hasPathSum(parent.left, sum) || hasPathSum(parent.right, sum);
    }

    public boolean hasSubPathSum(int sum) {
        return hasSubPathSum(this.root, sum, 0);
    }

    private boolean hasSubPathSum(Node parent, int targetSum, int sum) {
        if (parent == null) {
            return false;
        }

        boolean hasSubPath = false;
        int currSum = sum + parent.data;
        if (currSum == targetSum) {
            hasSubPath = true;
        } else if (currSum > targetSum) {
            hasSubPath = hasSubPathSum(parent.left, targetSum, parent.data) || hasSubPathSum(parent.right, targetSum, parent.data);
        } else if (currSum < targetSum) {
            if (parent.left != null) {
                if (currSum + parent.left.data > targetSum) {
                    hasSubPath = hasSubPathSum(parent.left, targetSum, parent.data);
                } else {
                    hasSubPath = hasSubPathSum(parent.left, targetSum, currSum);
                }
            }
            if (!hasSubPath && parent.right != null) {
                if (currSum + parent.right.data > targetSum) {
                    hasSubPath = hasSubPathSum(parent.right, targetSum, parent.data);
                } else {
                    hasSubPath = hasSubPathSum(parent.right, targetSum, currSum);
                }
            }
        }

        return hasSubPath;
    }

    public int countPathsWithSum(int targetSum) {
        return countPathsWithSum(this.root, targetSum, 0, 0);
    }

    private int countPathsWithSum(Node parent, int targetSum, int currSum, int count) {
        return count;
    }
}
