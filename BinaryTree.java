//Leetcode 100
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p.val!=q.val) return false;
        
        if(isSameTree(p.left,q.left)==false) return false;
        if(isSameTree(p.right,q.right)==false) return false;
        return true;
    }
}
// Leetcode 257
class Solution
  {
    public void path(TreeNode root,String s,List<String> ans)
    {
      if(root==null) return;
      if(root.left== null && root.right==null)
      {
        s+=root.val;
        ans.add(s);
        return;
      }
      path(root.left,s+root.val+"->",ans);
      path(root.right, s+root.val+"->",ans);
    }
    public List<String> binaryTreePaths(TreeNode root)
    {
      List<String> ans= new ArrayList<>();
      path(root,"",ans);
      return ans;
    }
  }

// Leetcode 236
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}

//Leetcode 102
class Solution {
    private int levels(TreeNode root)
    {
        if(root==null) return 0;
        return 1+Math.max(levels(root.right),levels(root.left));
    }
    private void nThLevel(TreeNode root,int level,int lvl,List<Integer> arr)
    {
        if(root==null) return;
        if(level==lvl) arr.add(root.val);
        nThLevel(root.left,level+1,lvl,arr);
        nThLevel(root.right,level+1,lvl,arr);
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> ans = new ArrayList<>();
         int lvl=levels(root);
         for(int i=0;i<lvl;i++)
         {
            List<Integer> arr= new ArrayList<>();
            nThLevel(root,0,i,arr);
            ans.add(arr);
         }
         return ans;
    }
}

//Leetcode 199
//right side means all the nodes which are at the rightmost in each level
//har level meh left to right jaana: a level variable
//prorder is root left right, we need the rightmost so set the rightmost ele in the ans arraylist
//do this for each level
class Solution {
    public int levels(TreeNode root)
    {
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    public void preorder(TreeNode root,int levels,List<Integer>ans)
    {
        if(root==null) return;
        ans.set(levels,root.val);
        preorder(root.left,levels+1,ans);
        preorder(root.right,levels+1,ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        int n=levels(root);
       
        //initial add 0
        for(int i=0;i<n;i++)
        {
            ans.add(0);
        }
        preorder(root,0,ans);
        return ans;

    }
}

//Leetcode 110
//balacnce BT= levels(LST)-levels(RST) math.abs<=1
class Solution {
    public int levels(TreeNode root)
    {
        if(root==null) return 0 ;
        return 1+ Math.max(levels(root.right),levels(root.left)); // method to find the no of levels in a binary tree
        // this is the accessive

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int diff=Math.abs(levels(root.left)- levels(root.right));
        if(diff>1) return false;
        boolean lst = isBalanced(root.left);
        if(lst==false) return false;
        boolean rst = isBalanced(root.right);
        if(rst==false) return false;
        return true;
    }
}

// Diameter of Binary Tree(O(n) approach)
class Solution
{
    static int dia;
    public int levels(TreeNode root)
    {
        if(root==null) return 0;
        int leftlevels=levels(root.left);
        int rightlevels=levels(root.right);
        int dia=leftlevels+ rightlevels;
        maxDia=Math.max(dia,maxDia);
        return 1+Math.max(leftlevels,rightlevels);
    }
    public int diameterOFBinaryTree(TreeNode root)
    {
        maxDia=0;
        levels(root);
        return maxDia;
    }
}
    
//PATH SUM Leetcode 113
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void helper(TreeNode root, int target, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) return;

        List<Integer> path = new ArrayList<>(currentPath);
        path.add(root.val);

       
        if (root.left == null && root.right == null && root.val == target) {
            result.add(path);
            return;
        }

        
        helper(root.left, target - root.val, path, result);
        helper(root.right, target - root.val, path, result);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), result);
        return result;
    }
}

//Leetcode 437
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
    public int helper(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int count = 0;
        if (root.val == targetSum) count++;
        count += helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);
        return count;
    }
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return helper(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}

//Leetcode 105
//there is only one tree which will have same inorder and preorder
//2 arr is given then there is only one possibility of a tree when the arrays represent one preoder and oneinorder
//the first element of the preoder array is the root element
//maintain prelo prehi inlo inhi
//maintain helper function
public TreeNode helper(int[ preorder,int[]inorder,int prelo,int prehi,int ilo,int inhi)
    {
        if(prelo>prehi || inlo>inhi)
        {
            return null;
        }
    //the first element is root of the preorder
    TreeNode root= new TreeNode(preorder[prelo]);
    int r = inlo;
    while(r!=root.val) //it remains the left side ele
        {
            r++;
        }
    int leftsize=r-inlo;
     root.left = helper(preorder, inorder, prelo + 1, prelo + leftsize, inlo, r - 1);
        root.right = helper(preorder, inorder, prelo + leftsize + 1, prehi, r + 1, inhi);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    

