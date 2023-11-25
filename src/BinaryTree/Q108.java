package BinaryTree;

public class Q108 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
//        TreeNode root = new TreeNode(nums[len/2]);
//        insert(0, len-1,nums);
        return insert(0, len-1,nums);
    }
    public TreeNode insert(int start, int end, int[] nums){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = insert(start,mid-1,nums);
        node.right = insert(mid+1,end,nums);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = new Q108().sortedArrayToBST(nums);
    }
}
