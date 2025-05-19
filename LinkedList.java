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
