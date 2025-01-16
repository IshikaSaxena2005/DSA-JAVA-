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

//Leetcode 94
class Solution
{
    static List<Integer> ans;
    public void inOrder(TreeNode root)
    {
        if(root==null) return;
        inOrder(root.left);
        ans.add(root.val);
        inOrder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root)
    {
        ans= new ArrayList<>();
        inOrder(root);
        return ans;
    }
}

//method 2
class Solution {
    static List<Integer> ans;
    public static void inOrder(TreeNode root)
    {
        TreeNode curr=root
        ;
        while(curr!=null)
        {
            //no left child
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            //there is a left child
            else
            {
                //rightmost child to the left subtree
                TreeNode prev= curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev=prev.right;
                }
                //case 2: when rightmost child is null
                if(prev.right==null)
                {
                    prev.right=curr;
                    curr=curr.left;
                }
                //not null
                else
                {
                    prev.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inOrder(root);
        return ans;
    }
}

//Leetcode 230
class Solution {
    static List<Integer> ans;
    public void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        ans = new ArrayList<>();
        inorder(root);
        return ans.get(k-1);
    }
}
