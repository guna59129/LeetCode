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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root==null)
        {
            return root;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        ArrayList<Integer> arr=new ArrayList<>();
        while(!q.isEmpty())
        {
            int sum=0;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                int v=node.val;
                sum=sum+v;
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            arr.add(sum);
        }
        q.add(root);
        int j=1;
        root.val=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                int csum=0;
                if(node.left!=null)
                {
                    csum=csum+node.left.val;
                }
                if(node.right!=null)
                {
                    csum=csum+node.right.val;
                }
                if(node.left!=null)
                {
                    node.left.val=arr.get(j)-csum;
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    node.right.val=arr.get(j)-csum;
                    q.add(node.right);
                }
            }
            ++j;
        }
        return root;
    }
}