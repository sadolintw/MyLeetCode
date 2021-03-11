package java_ver.N0700;

import util.vo.TreeNode;

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(val == root.val){
            return root;
        } else if(val > root.val){
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}

//////////////////////////////////////////////////////////////////

public class N0700_Search_in_a_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode();
        tree1 = TreeNode.insertLevelOrder(new Integer[]{4, 2, 7, 1, 3}, tree1, 0);
        Solution solution = new Solution();
        tree1 = solution.searchBST(tree1, 2);
        System.out.println(tree1);
    }
}
