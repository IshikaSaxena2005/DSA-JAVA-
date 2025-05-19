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
