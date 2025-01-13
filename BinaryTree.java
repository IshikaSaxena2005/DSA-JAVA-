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

