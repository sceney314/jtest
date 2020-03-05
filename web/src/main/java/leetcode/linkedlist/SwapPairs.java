package leetcode.linkedlist;

/**
 * 两两交换链表中的节点
 * <p>
 * 2020-03-05 10:07
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println((new SwapPairs()).swapPairs(n1));
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = head.next;
        ListNode before = null;
        while(head != null){
            ListNode tmp = head.next;
            if(tmp == null){
                break;
            }

            if(before != null){
                before.next = tmp;
            }
            before = head;
            head.next = tmp.next;
            tmp.next = head;
            head = head.next;
        }

        return newHead;
    }
}
