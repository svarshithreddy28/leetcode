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
    int[] max;
    public int rec(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=rec(root.left);
        int r=rec(root.right);
        int val1=root.val;
        if(val1>=l && val1>=r)
        {
            max[0]++;
        }
        return Math.max(root.val,Math.max(l,r));
    }
    public int countDominantNodes(TreeNode root) {
        max=new int[1];
        int ans=rec(root);
        return max[0];
    }
}