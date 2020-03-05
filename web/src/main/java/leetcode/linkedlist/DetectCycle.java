package leetcode.linkedlist;

import java.util.HashSet;

/**
 * 环形链表 II
 * <p>
 * 2020-03-04 09:50
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(-4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        n3.next = n2;
        n2.next = n0;
        n0.next = n4;
        n4.next = n2;
        System.out.println((new DetectCycle()).detectCycle(n3));
        System.out.println((new DetectCycle()).detectCycle2(n3));
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodeSet = new HashSet<>();
        while (head != null){
            if (head.next == null){
                break;
            }

            if (nodeSet.contains(head.next)){
                return head.next;
            }
            nodeSet.add(head);
            head = head.next;
        }

        return null;
    }
}
