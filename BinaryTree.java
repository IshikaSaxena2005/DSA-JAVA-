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


