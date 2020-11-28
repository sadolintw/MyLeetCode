package vo;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(Integer val) { this.val = val; }
    public TreeNode(Integer val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode insertLevelOrder(Integer[] arr, TreeNode root, Integer i) {
        // Base case for recursion
        if (i < arr.length) {
            if(arr[i] == null){
                return null;
            }

            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}