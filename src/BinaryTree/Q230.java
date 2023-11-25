package BinaryTree;
/*
二叉搜索树的中序遍历是升序排列的结果
 */
import java.util.*;

public class Q230 {
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

//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<Integer> nums = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            int len = queue.size();
//            while(len>0){
//                TreeNode node = queue.poll();
//                nums.add(node.val);
//                len--;
//                if(node.left!=null) queue.offer(node.left);
//                if(node.right!=null) queue.offer(node.right);
//            }
//        }
//        Collections.sort(nums);
//        return nums.get(k-1);
//    }
    //中序遍历
    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
//        stack
        int idx = 0;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode temp = stack.pop();
                idx++;
                if(idx == k){
                    return temp.val;
                }
                cur = temp.right;
            }
        }
        return cur.val;
}

}
