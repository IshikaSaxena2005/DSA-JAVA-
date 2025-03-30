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











//Leetcode 225
