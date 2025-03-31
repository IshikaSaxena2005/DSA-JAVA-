//reverse Queue
//using Stack
Queue<Integer> q = new LinkedList<>();
q.push(1);
q.push(2);
q.push(3);
q.push(4);
SOP(q);  //1 2 3 4
Stack<Integer> st = new Stack<>();
while(q.size()>0)
  {
    st.push(q.remove());
    
  }
while(st.size()>0)
  {
    SOP(st.peek());   //4 3 2 1 
    
    st.pop();
  }

//reverse k elements of stack
  static void reverseFirstK(Queue<Integer> q, int k) {
        if (q.isEmpty() || k > q.size())
            return;
        if (k <= 0)
            return;

        Stack<Integer> s = new Stack<>();

        /* Push the first K elements
           into a Stack*/
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }

        /* Enqueue the contents of stack
           at the back of the queue*/
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        /* Remove the remaining elements and
           enqueue them at the end of the Queue*/
        for (int i = 0; i < q.size() - k; i++) {
            q.add(q.poll());
        }
    }

    /* Utility Function to print the Queue */
    static void print(Queue<Integer> q) {
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }

//Leetcode 225
class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        
        q.add(x);

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }
    
    public int pop() {
     
        return q.remove();
    }
    
    public int top() {
  
        return q.peek();
    }
    
    public boolean empty() {
        
        return q.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

//Leetcode 232
class MyQueue {
    Stack<Integer> input=new Stack<>();
    Stack<Integer> output= new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.empty())
        
            while(input.empty()==false)
            {
                output.push(input.peek());
                input.pop();
            }
            int x=output.peek();
            output.pop();
                 return x;
        
   
    }
    
    public int peek() {
        if(output.empty())
        while(input.empty()==false)
        {
            output.push(input.peek());
            input.pop();
        }
        return output.peek();
    }
    
    public boolean empty() {
       return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

//First negative in each window size k:
public long[]printFirstK(long A[],int N,int k)
  {
    long[res= new long[N-k+1];
    Queue<Integer> q = new LinkedList<>();
  for(int i=0;i<N-k+1;i++)
    {
      if(q.size()>0 && q.peek()<i) q.remove();
      if(q.size()>0 && q.peek()<=i+k-1)
      {
        res[i]=A[q.peek()];
  
      }
      else if(q.size()==0)
      {
        res[i]=0;
      }
      else  res[i]=0;
    }
  return resl
}

//Reorder Queue
Stack<Integer> st= new Stack<>();
for(int i=1;i<q.size()/2;i++)
  {
    st.push(q.remove());  //5 6 7 8
  }
while(St.size()>0)
  {
    q.add(st.pop());  //5 6 7 8 4 3 2 1
  }
for(int i=1;i<=q.size()/2;i++)
  {
    q.add(st.pop());
    q.add(q.remove());

  }
while(q.size()>0)
  {
    st.push(q.remove());
  }
while(st.size()>0)
  {
    q.add(st.pop());
  }
SOP(q);

//Leetcode 735
class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n=arr.length;
     
        Stack<Integer>st= new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                st.push(arr[i]);
            }
            //else handle collision
            else
            {
                //jab tak chota ele aa rha nikal do
                while(!st.isEmpty()&& st.peek()>0 && Math.abs(arr[i])>Math.abs(st.peek()))
                {
                    st.pop();
                }
                if(st.isEmpty()||st.peek()<0)
                {
                    st.push(arr[i]);
                }
                else if(Math.abs(st.peek())==Math.abs(arr[i]))
                {
                    st.pop();
                }
        

            }
          
        }
       int[]res=new int[st.size()];
       for(int i=res.length-1;i>=0;i--)
       {
        res[i]=st.pop();
       }
    return res;
    }
}

//Leetcode 225
//Leetcode 232
//First negative in each window size k
//Reorder Queue
//Leetcode 735
