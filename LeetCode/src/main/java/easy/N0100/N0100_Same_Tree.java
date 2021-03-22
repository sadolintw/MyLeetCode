package easy.N0100;

import util.vo.TreeNode;

class Solution {
    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null){
            return true;
        }
        if(tree1 == null || tree2 == null){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }
}

//////////////////////////////////////////////////////////////////

public class N0100_Same_Tree {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode tree1 = new TreeNode();
        TreeNode tree2 = new TreeNode();
        tree1 = TreeNode.insertLevelOrder(new Integer[]{1, 2, 3}, tree1, 0);
        tree2 = TreeNode.insertLevelOrder(new Integer[]{1, 2, 3}, tree2, 0);
        System.out.println(solution.isSameTree(tree1, tree2));
    }
}
