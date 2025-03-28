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





//Questions Solved:
//Leetcode 20
//next greater element
//stock span problem


