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

//Leetcode 108
lass Solution {
  //no need of inorder since the array is already sorted
  public TreeNode helper(int[]nums,int lo,int hi)
  {
    if(lo>hi) return null;
    //then find mid
    int mid=lo+(hi-lo)/2;
    int n=nums.length;
    if(n==0) return null;
    TreeNode root= new TreeNode(nums[mid]);
    root.left= helper(nums,lo,mid-1);
    root.right=helper(nums,mid+1,hi);
    return root;
  }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return helper(nums,0,n-1);
        
    }
}

//Leetcode 1382
class Solution {
    public void inorder(TreeNode root,List<Integer> ans)
    {
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public TreeNode newTree(int lo,int hi,int[]nums)
    {
        if(lo>hi) return null;
        int mid=lo+(hi-lo)/2;
          int n=nums.length;
        if(n==0)return null;
        TreeNode root=new TreeNode(nums[mid]);
      
        root.left=newTree(lo,mid-1,nums);
        root.right=newTree(mid+1,hi,nums);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        int[] nums= new int[ans.size()];
        for(int i=0;i<ans.size();i++)
        {
            nums[i]=ans.get(i);
        }
        
        return newTree(0,nums.length-1,nums);
        
    }
}

//Leetcode 1008
class Solution {
    public TreeNode helper(int[]preorder,int[]inorder,int prelo,int prehi,int inlo,int inhi)
    {
        if(prelo>prehi || inlo>inhi)
        {
            return null;
        }
        TreeNode root= new TreeNode(preorder[prelo]);
        int r= inlo;
        while(inorder[r]!=root.val)
        {
            r++;
        }
        int leftsize=r-inlo;
        root.left=helper(preorder,inorder,prelo+1,prelo+leftsize,inlo,r-1);
        root.right=helper(preorder,inorder,prelo+leftsize+1,prehi,r+1,inhi);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        int[]inorder=Arrays.copyOf(preorder,n);
        Arrays.sort(inorder);
        return helper(preorder,inorder,0,n-1,0,n-1);
    }
}

//Leetcode 450
 */
class Solution {
    public TreeNode iop(TreeNode root)
    {
        TreeNode temp = root.left;
        while(temp.right!=null) temp = temp.right;
        return temp;
    }
    public TreeNode parent(TreeNode root, TreeNode pred)
    {
        if(root.left==pred || root.right==pred) return root;
        TreeNode temp = root.left;
        while(temp.right!=pred) temp =temp.right;
        return temp;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key)
        {
            //case 1: leaf node:0 child
            if(root.left == null && root.right==null)
            {return null;}

            //case 2:1 child node
            else if(root.left==null || root.right==null)
            {
                if(root.left==null)return root.right;
                else return root.left;
            }
            //case 3:  2 child nodes
            else
            {
                TreeNode pred= iop(root);
                TreeNode predParent= parent(root,pred);
                // note that if the key has 2 children then we will follow the predecessor approach
                if(root==predParent)
                
                {
                    pred.right=root.right;
                    return pred;
                }
                predParent.right= pred.left;
                pred.left = root.left;
                pred.right = root.right;
                return pred;
            }
        }
        else if(root.val>key)
        {
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key)
        {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}

//Leetcode 114
class Solution {
    public void preorder(TreeNode root,ArrayList<TreeNode> pre)
    {
        if(root==null) return;
        pre.add(root);
        preorder(root.left,pre);
        preorder(root.right,pre);
    }
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> pre=new ArrayList<>();
        preorder(root,pre);
        int n=pre.size();
        for(int i=0;i<n;i++)
        {
            if(i!=n-1) pre.get(i).right=pre.get(i+1);
            pre.get(i).left=null;
        }
    }
}

//Leetcode 938
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}


//Leetcode 1305
class Solution {
    public void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inorder(root.left, inorder);
        inorder.add(root.val); 
        inorder(root.right, inorder);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        
       
        inorder(root1, lst1);
        inorder(root2, lst2);
        
      
        return mergeSortedLists(lst1, lst2);
    }

    private List<Integer> mergeSortedLists(List<Integer> lst1, List<Integer> lst2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < lst1.size() && j < lst2.size()) {
            if (lst1.get(i) < lst2.get(j)) {
                result.add(lst1.get(i++));
            } else {
                result.add(lst2.get(j++));
            }
        }

        while (i < lst1.size()) {
            result.add(lst1.get(i++));
        }

        while (j < lst2.size()) {
            result.add(lst2.get(j++));
        }

        return result;
    }
}
