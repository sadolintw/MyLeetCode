package java_ver.N0098;

import util.vo.TreeNode;

class Solution {

    public boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper){
        if(node == null){
            return true;
        }
        if(lower != null && node.val <= lower){
            return false;
        }
        if(upper != null && node.val >= upper){
            return false;
        }
        if(!isValidBSTHelper(node.left, lower, node.val)){
            return false;
        }
        if(!isValidBSTHelper(node.right, node.val, upper)){
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}

//////////////////////////////////////////////////////////////////

public class N0098_Validate_Binary_Search_Tree {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode tree1 = new TreeNode();
        tree1 = TreeNode.insertLevelOrder(new Integer[]{2, 1, 3}, tree1, 0);
        System.out.println(solution.isValidBST(tree1));
        TreeNode tree2 = new TreeNode();
        tree2 = TreeNode.insertLevelOrder(new Integer[]{5, 1, 4, null, null, 3, 6}, tree2, 0);
        System.out.println(solution.isValidBST(tree2));
    }
}
