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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int parent1 = 0;
        int parent2 = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null && (x == node.left.val || y== node.left.val)){
                    if(count<2){
                        parent1 = node.val;
                        count++;
                    }
                    else{
                        parent2 = node.val;
                        count++;
                    }
                }
                else if(node.right != null && (x == node.right.val || y== node.right.val)){
                    if(count<2){
                        parent1 = node.val;
                        count++;
                    }
                    else{
                        parent2 = node.val;
                        count++;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                    
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if(count==2 && parent1 != parent2) return true;
            if(count <= 2 && count > 0) return false;
        }
        return false;
    }
}