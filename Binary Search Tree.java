//Leetcode 700
class Solution {
public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}

//Leetcode 701
//if val<=root.val
//if left side is null then root.left=new TreeNode(val)
//else insert(root.left,val)
//else 
//see if the right side is null then insert directly otherwise make a TreeNode and add
class Solution {
    public TreeNode insert(TreeNode root, int val)
    {
        if(val<root.val)
        {
            //Left side
            if(root.left==null)
            {
                root.left= new TreeNode(val);
            }
           else  insert(root.left,val);
        }
        else
        {
            if(root.right==null)
            {
                root.right= new TreeNode(val);
            }
          else  insert(root.right,val);
        }
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insert(root,val);
        return root;
    }
}
