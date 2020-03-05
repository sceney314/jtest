package leetcode.linkedlist;

import java.util.HashSet;

/**
 * 环形链表
 * <p>
 * 2020-03-05 10:04
 */
public class HasCycle {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(-4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        n3.next = n2;
        n2.next = n0;
        n0.next = n4;
        n4.next = n2;
        System.out.println((new HasCycle()).hasCycle2(n3));
        System.out.println((new HasCycle()).hasCycle(n3));
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return true;
            }

            set.add(head);
            head = head.next;
        }

        return false;

    }


    public boolean hasCycle2(ListNode head){
        ListNode fast = head, slow = head;
        while(head != null){
            slow = slow.next;
            if(slow == null){
                break;
            }
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
            if(fast == null){
                break;
            }

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
}
