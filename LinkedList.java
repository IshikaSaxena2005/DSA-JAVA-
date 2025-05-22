//delete node in LL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

//middle  of LL

class Solution {
    // //2 pass solution TC:O(n) SC:O(1)
    // public ListNode middleNode(ListNode head) {
    //     ListNode temp=head;
    //     int len=0;
    //     while(temp!=null)
    //     {
    //         temp=temp.next;
    //         len++;
    //     }
    //     int mid=len/2+1;
    //     temp=head;
    //     for(int i=1;i<=mid-1;i++)
    //     {
    //         temp=temp.next;
    //     }
    //     return temp;
    // }

    //slow fast appraoch
     public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
         
        while(fast!=null)
        {
            if(fast.next==null) return slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
     }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next.next!=null && fast.next.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        if(headA==null||headB==null)
        {
            return null;
        }
        ListNode tempA=headA;
        while(tempA!=null)
        {
             lenA++;
            tempA=tempA.next;
           
        }
        ListNode tempB=headB;
        while(tempB!=null)
        {
             lenB++;
            tempB=tempB.next;
           
        }
        tempA=headA;
        tempB=headB;
        if(lenA>lenB)
        {
        while(lenA>lenB)
        {
            tempA=tempA.next;
            lenA--;
        }
        }
        if(lenB>lenA)
        {
        while(lenB>lenA)
        {
            tempB=tempB.next;
            lenB--;
        }
        }
        if(lenA==lenB)
        {
            while(tempA!=tempB)
            {
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
        return tempA;

    }
}

//ROTATATE LINKED LIST


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //base case
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }
        k%=len;
        if(k==0) return head;
        ListNode slow=head;
        ListNode fast=head;
        for(int i=1;i<=k;i++)
        {
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newHead=slow.next;
        slow.next=null; //slow is now the new tail
        fast.next=head;
        return newHead;
    }
}

//MERGE 2 sorted LL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(100);
        ListNode temp=dummy;
        ListNode temp1=list1;
        ListNode temp2=list2;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val<=temp2.val)
            {
                temp.next=temp1;
                temp1=temp1.next;
            }
            else
            {
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1==null) temp.next=temp2;
        else temp.next=temp1;
        return dummy.next;
    }
}


//Sort List
class Solution {
    public ListNode merge(ListNode temp1,ListNode temp2)
    {
        ListNode dummy= new ListNode(100);
        ListNode temp=dummy;
        while(temp1!=null & temp2!=null)
        {

        if(temp1.val<=temp2.val)
        {
            temp.next=temp1;
            temp1=temp1.next;
        }
        else
        {
            temp.next=temp2;
            temp2=temp2.next;
        }
        temp=temp.next;
          
        }
        if(temp1==null) temp.next=temp2;
        else temp.next=temp1;
        return dummy.next;

    }
    public ListNode sortList(ListNode head) {
        if(head==null ||head.next==null) return head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode firstHalf=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=slow.next;
        slow.next=null;
        firstHalf=sortList(firstHalf);
        secondHalf=sortList(secondHalf);
        ListNode ans= merge(firstHalf,secondHalf);
        return ans;
    }
}

//merge k soted Linked List
class Solution {
    public ListNode mergeTwo(ListNode temp1,ListNode temp2)
    {
        ListNode dummy= new ListNode(100);
        ListNode temp= dummy;
        while(temp1!=null && temp2!=null)
        {
            if(temp1.val<=temp2.val)
            {
                temp.next=temp1;
                temp1=temp1.next;
            }
            else
            {
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1==null) temp.next=temp2;
        else temp.next=temp1;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists==null ||lists.length==0) return null;
       List<ListNode> list= new ArrayList<>(Arrays.asList(lists));
       while(list.size()>1)
       {
        int size=list.size();
        ListNode l1= list.remove(size-1);
        ListNode l2= list.remove(size-2);
        ListNode merge= mergeTwo(l1,l2);
        list.add(merge);
       }

       return list.get(0);
    }
}

//Partition Linked List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummya=new ListNode(100);
        ListNode dummyb= new ListNode(100);
        ListNode tempa= dummya;
        ListNode tempb= dummyb;
        ListNode temp=head;
        while(temp!=null)
        {
            if(temp.val<x)
            {
                tempa.next=temp;
                temp=temp.next;
                tempa=tempa.next;
            }
            else
            {
                tempb.next=temp;
                temp=temp.next;
                tempb=tempb.next;
            }
           

        }
         tempb.next=null;
        dummya=dummya.next;
        dummyb=dummyb.next;
        if(dummya==null) return dummyb;
         tempa.next=dummyb;
        
        return dummya;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummya= new ListNode(100);
        ListNode dummyb= new ListNode(100);
        ListNode tempa=dummya;
        ListNode tempb=dummyb;
        ListNode temp=head;
        int index=1;
        while(temp!=null)
        {
            if((index%2)!=0)
            {
                tempa.next=temp;
                temp=temp.next;
                tempa=tempa.next;
                index++;
            }
            else
            {
                tempb.next=temp;
                tempb=tempb.next;
                temp=temp.next;
                index++;
            }
        }
        tempb.next=null;
        dummya=dummya.next;
        dummyb=dummyb.next;
        if(dummya==null) return dummyb;
        tempa.next=dummyb;
        return dummya;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to make head swapping easier
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointer to traverse the list
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            // Nodes to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;
    }
}

//reverse LL
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}

//palindrome
class Solution {
    public boolean isPalindrome(ListNode head) {
        //use of extra space
        List<Integer> list= new ArrayList<>();
        ListNode temp= head;
        while(temp!=null)
        {
            list.add(temp.val);
            temp=temp.next;

        }
        int i=0;
        int j=list.size()-1;
        while(i<j)
        {
            if(!list.get(i).equals(list.get(j)))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}   

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
      public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode j=reverse(slow);
        ListNode i=head;
        while(j!=null)
        {
            if(i.val!=j.val) return false;
            i=i.next;
            j=j.next;
        }
        return true;
      }

    //Reverse lined list 2
    class Solution {
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right) return head;
        ListNode temp=head;
        ListNode a=null;
        ListNode b=null;
        ListNode c= null;
        ListNode d= null;
        int pos=1;
        while(temp!=null)
        {
            if(pos==left-1) a=temp;
            if(pos==left) b=temp;
            if(pos==right) c= temp;
            if(pos==right+1) d= temp;
            pos++;
            temp=temp.next;

        }
        if(a!=null)a.next=null; //if a is already on the first nod
        if(c!=null)c.next=null;
        reverse(b);
        if(a!=null)a.next=c;
        if(b!=null)b.next=d;
        if(a==null )  return c;
        return head;
    

    }
}

//add 2 numbers
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy= new ListNode(100);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int val1=0;
            int val2=0;
            if(l1!=null) val1=l1.val;
            if(l2!=null) val2=l2.val;
            int num=val1+val2+carry;
            ListNode node= new ListNode(num%10);
            temp.next=node;
            temp=temp.next;
            if(num>9) carry=1;
            else carry=0;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(carry==1) 
        {
            ListNode node= new ListNode(1);
            temp.next=node;
            temp=temp.next;


        }
        return dummy.next;
    }
}

    
//Leetcode 21    
//Leetocode 148
//Leetcode 23
//Leetcode 86
//Leetcode 328
//Leetcode 206
//Leetcode 24
//Leetcode 234
//Leetcode 92
//Leetcode 2
