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












//Questions Solved:
//Leetcode 20


