package com.smdev.datastructures;

import java.util.ArrayList;
import java.util.*;
class Solution {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        //inorderRecursive(root, list);
        inorderLinear(root, list);
        return list;
    }

    private void inorderLinear(TreeNode root, List<Integer> list){
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode curr = root;
        while(curr != null){
            stack.add(curr);
            curr = curr.left;

            if(curr == null && !stack.isEmpty()){
                TreeNode n = stack.pop();
                list.add(n.val);
                curr = n.right;
            }
        }
    }

    private void inorderRecursive(TreeNode parent, List<Integer> list){
        if(parent == null){
            return;
        }

        inorderRecursive(parent.left, list);
        list.add(parent.val);
        inorderRecursive(parent.right, list);
    }
}
