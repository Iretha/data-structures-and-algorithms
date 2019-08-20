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
        return countPathsWithSum(this.root, targetSum);
    }

    private int countPathsWithSum(Node root, int targetSum) {
        if (root == null) return 0;

        // Count paths with sum starting from the root
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        // Try the nodes on the left and the right
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    // Number of paths with this sum starting from this node
    private int countPathsWithSumFromNode(Node node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.data;

        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from the root
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }
}
