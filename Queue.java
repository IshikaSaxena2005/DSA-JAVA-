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
