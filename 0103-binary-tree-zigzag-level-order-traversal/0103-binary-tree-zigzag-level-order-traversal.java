/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean reversed = false;
        while(!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for(int i=0; i<levelSize; i++){
                if(!reversed){
                    TreeNode currentNode = deque.pollFirst();
                    currentLevel.add(currentNode.val);
                    if(currentNode.left != null){
                        deque.offerLast(currentNode.left);
                    }
                    if(currentNode.right != null){
                        deque.offerLast(currentNode.right);
                    }
                }else{
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);
                    if(currentNode.right != null){
                        deque.offerFirst(currentNode.right);
                    }
                    if(currentNode.left != null){
                        deque.offerFirst(currentNode.left);
                    }
                }
                
            }
            reversed = !reversed;
            res.add(currentLevel);
        }
        return res;
    }
}