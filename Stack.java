//Leetcode 20
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray())
        {
           
            if(ch=='('||ch=='{'||ch=='[')
            {
                st.push(ch);
            }
            else
            {
                if(st.size()==0) return false;
                else if(st.peek()=='('&& ch==')') st.pop();
                else if(st.peek()=='{'&& ch=='}') st.pop();
                else if(st.peek()=='['&& ch==']') st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}

public int[]remove(int arr[])
    {
        Stack<Integer>st= new Stack<>();
        for(int i=0;i<arr.length;i++)
            {
                if(st.isEmpty()) st.push(arr[i]);
                else if(st.peek()==arr[i]) st.push(arr[i]);
                else if(st.peek()==arr[i])
                {
                    if(arr[i]==n-1 || arr[i]!=arr[i+1])
                    {
                        st.pop();
                    }
                    else 
                        continue;
                }
            }
            for(int i=arr.length-1;i>0;i--)
                {
                    arr[i]=st.pop();
                }
    return arr;
    
    }

//Next greater element
public class nextGreater
    {
        psvmsa
        {
            int[]arr={1,2,4,6,9,8,10};
            int[]res=int[arr.length];
            for(int i=0;i<arr.length;i++)
                {
                    res[i]=-1;
                    for(int j=0;j<arr.length;j++)
                        {
                            if(arr[j]>arr[i])
                            {
                                res[i]=arr[j];
                                break; //breaks the inner loop
                            }
                        }
                }
            for(int i=0;i<arr.length;i++)
            {
                SOP(arr[i]+"");
            }
        }
    }

//M:2
res[n-1]=-1;
for(int i=n-2;i>=0;i++)
    {
        while(st.peek()<arr[i] && st.size()>0)
            {
                st.pop(); //jab tak chota ele meh stack meh nikaldo
            }
        if(st.size()==0) res[i]=-1;
        else res[i]=st.peek();
        st.push(arr[i]);  
    }

//stock span: prev greater element:
res[0]=-1;
for(int i=0;i<arr.length;i++)
    {
        while(st.peek()<arr[i]&& !st.isEmpty())
        {
            st.pop();
        }
        if(st.isEmpty())
        {
            res[i]=i+1;
        }
        else
        {
            res[i]=i=st.peek();
        }
        st.push(i);
        
    }

//Leetcode 496
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st= new Stack<>();
        int n=nums2.length;
        int n1=nums1.length;
        int[]res=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&nums2[i]>st.peek())
            {
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(nums2[i]);
        }
        int[]res2=new int[n1];
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<n;j++)
            {
                res2[i]=res[j];
                break;
            }
        }
        return res2;
    }
}

//Leetcode 503:
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        int n=nums.length;
        int[]res=new int[n];
        for(int i=2*n-1;i>=0;i--)
        {
            int cirIdx=i%n;
           while(!st.isEmpty()&& st.peek()<=nums[cirIdx])
           {
            st.pop();
           }
           res[cirIdx]=st.isEmpty()?-1:st.peek();
           st.push(nums[cirIdx]);
        }
        return res;

    }
}

//next smaller element:
public class Solution {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> st= new Stack<>();
        int n=A.length;
        int[]res=new int[n];

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&&st.peek()>=A[i])
            {
                st.pop();
            }
 
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(A[i]);
        }
        return res;
    }
}

//the celebrity problem:
import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        
        // Push all people onto the stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        
        // Determine the potential celebrity
        while (st.size() > 1) {
            int person1 = st.pop();
            int person2 = st.pop();
            
            // Check if person1 knows person2
            if (mat[person1][person2] == 1) {
                st.push(person2); // Person1 can't be a celebrity
            } else {
                st.push(person1); // Person2 can't be a celebrity
            }
        }
        
        // Check if a celebrity exists
        if (st.isEmpty()) {
            return -1;
        }
        int candidate = st.pop();
        
        // Validate if the candidate is a celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                    return -1; // Candidate is invalid
                }
            }
        }
        
        return candidate;
    }
}

//Leetcode 239:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[]ans=new int[n-k+1];
        Stack<Integer> st=new Stack<>();
        int[]nge=new int[n];
        nge[n-1]=n; //to avoid index out of bound error
        int z=0;
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&& nums[i]>=nums[st.peek()])
            {
                st.pop();
                
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);//index ko push krna
        }
        int j=0;
        for(int i=0;i<=n-k;i++)
        {
            if(j<i) j=i; //if j goes out of window

            while(nge[j]<i+k)//window  ke andr hii rehna hai
            {
               j=nge[j];
            }
            ans[z++]=nums[j];
        }
        return ans;
    }
}

//Leetcode 907
class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n=arr.length;
        int[]PLE=new int[n];
        int MOD = 1_000_000_007;
        Stack<Integer> st= new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() &&arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
             PLE[i]=st.isEmpty()?-1: st.peek();
            st.push(i);
           
        }
        st.clear();

        int[]NLE=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&& arr[i]<arr[st.peek()])
            {
                st.pop();
            }
            NLE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
    
        }
        long sum=0;
        for(int i=0;i<n;i++)
        {
            long left=i-PLE[i];
            long right=NLE[i]-i;
            sum=(sum+ arr[i]*left*right)%MOD;
        }
        return (int)sum;
    }
}
//Leetcode 2104
class Solution {
    public long subArrayRanges(int[] arr) {
        //calculate NGE and PGE for maximum contribution
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        //PGE
        int[]PGE= new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&& arr[i]>arr[st.peek()])
            {
                st.pop();
            }
            PGE[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        //NGE
        int[]NGE=new int[n];
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&&arr[i]>=arr[st.peek()])
            {
                st.pop();
            }
            NGE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
    
        long maxContri=0;
        for(int i=0;i<n;i++)
        {
            long left=i-PGE[i];
            long right=NGE[i]-i;
            maxContri+=(long)arr[i]*left*right;
        }

        //for min contribution:
        int[]PLE=new int[n];
            st.clear();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&& arr[i]<arr[st.peek()])
            {
                st.pop();
            }
            PLE[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }


        //NLE:
        int[]NLE=new int[n];
                st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty()&& arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            NLE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        long minContri=0;
        for(int i=0;i<n;i++)
        {
            long left=i-PLE[i];
            long right=NLE[i]-i;
            minContri+=(long)arr[i]*left*right;
        }
        return maxContri-minContri;
        

    }
}
//Leetcode 84:
class Solution {
    public int largestRectangleArea(int[] arr) { //arr==heights
        //NLE and PLE to calculate
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        //PLE:
        int PLE[]= new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[i]<arr[st.peek()])
            {
                st.pop();
            }
            PLE[i]=st.isEmpty()?-1: st.peek();
            st.push(i);
        }
        int NLE[]=new int[n];
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            NLE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int maxArea=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            maxArea=arr[i]*(NLE[i]-PLE[i]-1);
            max=Math.max(max,maxArea);
        }
        return max;
    }
}

//Leetcode 85
class Solution {
    public int largestRect(int []arr)
    {
        int n=arr.length;
        Stack<Integer>st= new Stack<>();
        int[]PLE = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty()&& arr[i]<arr[st.peek()])
            {
                st.pop();

            }
            PLE[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        int[]NLE=new int[n];
        st.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            NLE[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
         int maxArea=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            maxArea=arr[i]*(NLE[i]-PLE[i]-1);
            max=Math.max(max,maxArea);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[]height=new int[col]; //histogram height
        int maxArea=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                height[j]=matrix[i][j]=='1'?height[j]+1:0;
            }
            maxArea=Math.max(maxArea,largestRect(height));
        }
        return maxArea;
    }
}


//Questions Solved:
//Leetcode 20
//next greater element
//stock span problem
//Leetcode 496
//Leetcode 503
//celebrity problem
//Leetcode 239
//Leetcode 907
//Leetcode 2104
//Leetcode 84
//Leetcde 85


