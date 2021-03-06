/**
 * Problem Statement
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ArrayList<Integer> rntList = new ArrayList<Integer>();
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return rntList;
       
	    //order: left-child, right-child, parent
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
       
        
        rntList.add(root.val);
        return rntList;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity: O(n)
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        //special case
        if(root==null) return rnt;
        
        //post order traverse
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
        rnt.add(root.val);
        
        return rnt;
    }

}
