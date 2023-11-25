package BinaryTree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q437 {
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
    public TreeNode constructTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }
        int index = 0;
        int length = array.length;
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode currNode;
        while (index < length) {
            index++;
            if (index >= length) {
                return root;
            }
            currNode = nodeQueue.poll();
            Integer leftChild = array[index];
            if (leftChild != null) {
                currNode.left = new TreeNode(leftChild);
                nodeQueue.offer(currNode.left);
            }
            index++;
            if (index >= length) {
                return root;
            }
            Integer rightChild = array[index];
            if (rightChild != null) {
                currNode.right = new TreeNode(rightChild);
                nodeQueue.offer(currNode.right);
            }
        }
        return root;
    }

//    public int pathSum(TreeNode root, long targetSum) {
//        if(root == null) return 0;
//        int res = getNum(root,targetSum);
//        res += pathSum(root.left,targetSum);
//        res +=pathSum(root.right,targetSum);
//        return res;
//    }
//    public int getNum(TreeNode node, long targetSum){
//        int ret = 0;
//        if(node == null) return 0;
//        if(targetSum-node.val==0){
//            ret+=1;
//        }
//
//        long resNum = targetSum-node.val;
//        ret += getNum(node.left,resNum);
//        ret+= getNum(node.right,resNum);
//        return ret;
//    }
//前缀和：从根节点到当前节点路径之和
    public int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>(); //分别记录前缀和，以及路径数
        //当targetSum 等于某个节点值时，curPrefix - targetSum = 0,当前节点自己就算做一条符合条件的路径，所以也要计数
        prefix.put(0L, 1);
        dfs(root, prefix, 0L, targetSum);
        return ans;
    }

    //先序遍历
    private void dfs (TreeNode root, Map<Long, Integer> prefix, long curPrefix, int targetSum) {
        //递归终止的条件
        if (root == null) {
            return;
        }
        //当前节点的前缀和
        curPrefix += root.val;
        //查看是否有curPrefix - targetSum的前缀和已经存在
        int cnt = prefix.getOrDefault(curPrefix-targetSum, 0);
        ans += cnt;
        //记录前缀和,到当前节点，共有prefix.getOrDefault(curPrefix, 0) + 1条路径的前缀和为curPrefix
        prefix.put(curPrefix, prefix.getOrDefault(curPrefix, 0) + 1);
        //遍历左子树
        dfs(root.left, prefix, curPrefix, targetSum);
        //遍历右子树
        dfs(root.right, prefix, curPrefix, targetSum);
        //因为先序遍历是遍历根、左、右，即当前节点及其所有子节点，所以当遍历完当前节点和其所以子节点之后，当前节点的前缀和就没有用了，就需要把map里的记录删除，否则会影响其他子树的计算。跟当前节点没有路径关系的节点，不需要当前节点的前缀和
        prefix.put(curPrefix, prefix.getOrDefault(curPrefix, 0) - 1);
    }

    public static void main(String[] args) {
        Integer[] array = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = new Q437().constructTree(array);
        int res = new Q437().pathSum(root,8);
        System.out.println(res);
    }

}
