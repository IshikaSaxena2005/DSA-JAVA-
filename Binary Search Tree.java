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

//Leetcode 93
class Solution {
    public void inorder(TreeNode root,List<Integer> ans)
    {
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);

    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return true;
        inorder(root,ans);
        for(int i=1;i<ans.size();i++)
        {
            if(ans.get(i)<=ans.get(i-1)) return false;
        }
        return true;
    }
}

//method -2:
class Solution
        {
                static boolean flag;
                private long max(TreeNode root)
                {
                        if(root==null return long.MIN_VALUE;
                        long leftMax= max(root.left;
                        if(leftMax>=root.val) flag=false;
                        long rightMax=max(root.right);
                        return Math.max(root.val,Math.max(leftMax,rightMax));
                }
                private long min(TreeNode root)
                {
                        if(root==null) return long.MAX_VALUE;
                        long leftMin=min(root.left);
                        long rightMin= min(root.right);
                        if(rightMin<=root.val) flag=false;
                        return MAth.min(root.val,Math.min(leftMin,rightMin));
                }
                public boolean isVAlidBST(TreeNode root)
                {
                        flag=true;
                        max(root);
                        min(root);
                        return flag;
                }
        }
                        

//Leetcode 236
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
            TreeNode left= lowestCommonAncestor(root.left,p,q);
            TreeNode right= lowestCommonAncestor(root.right,p,q);
            if(left!=null && right !=null)
            {
                    return root;
            }
            return (left!=null)?left:right;
    }}
//method 2:

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right,p,q);
            else if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left,p,q);
            else return root;
    }}

//Leetcode 538
class Solution {
    public void inorder(TreeNode root,List<Integer> ans)
    {
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public void updateTree(TreeNode root,List<Integer> ans,int[] index)
    {
        if(root==null) return;
        updateTree(root.left,ans,index);
        root.val=ans.get(index[0]);
        index[0]++;
        updateTree(root.right,ans,index);
    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        for(int i=ans.size()-2;i>=0;i--)
        {
            ans.set(i,ans.get(i)+ans.get(i+1));
        }
        int[]index={0};
        updateTree(root,ans,index);
        return root;
    }
}
            
//Leetcode 1038
class Solution {
    public void inorder(TreeNode root,List<TreeNode> arr)
    {
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }

    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder(root,arr);
        int n =arr.size();
        for(int i =n-2;i>=0;i--)
        {
            arr.get(i).val+=arr.get(i+1).val;
        }
        return root;
    }
}

//method 2
class Solution {
    static int sum;
    public void reverseinorder(TreeNode root)
    {
        if(root==null) return;
        reverseinorder(root.right);
         root.val+=sum;
            sum=root.val;
        reverseinorder(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum=0;
        reverseinorder(root);
        return root;     
    }
}
