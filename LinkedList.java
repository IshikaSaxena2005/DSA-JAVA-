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
