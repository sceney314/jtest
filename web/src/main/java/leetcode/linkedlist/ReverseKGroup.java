package leetcode.linkedlist;

/**
 * K 个一组翻转链表
 * <p>
 * 2020-03-04 17:29
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
//        System.out.println((new ReverseKGroup()).reverseKGroup(n1, 3));
        System.out.println((new ReverseKGroup()).reverseKGroup2(n1, 3));
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if(k == 0 || head == null)
            return null;
        ListNode pre = head;
        ListNode cur = head;
        // 找到节点
        for (int i = 0; i < k - 1 && cur!=null; i++) {
            cur = cur.next;
        }

        if(cur == null ) {
            return head;
        }

        ListNode next = cur.next;
        cur.next = null;
        reverList(pre);

        // 交换指针
        ListNode temp = head;
        head = cur;
        cur = temp;

        cur.next  = reverseKGroup2(next,k);
        return head;
    }

    public ListNode reverList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverList(next);
        next.next = head;
        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2){
            return head;
        }

        ListNode first = head, pre = null;
        int i = k;
        ListNode[] nodes = new ListNode[k];
        while (head != null){
            nodes[--i] = head;
            head = head.next;

            if (i > 0){
                continue;
            }

            i = k;
            if (pre != null){
                pre.next = nodes[0];
            }else{
                first = nodes[0];
            }
            pre = nodes[k - 1];
            pre.next = null;
            int j = 0;
            while (++j < nodes.length){
                nodes[j - 1].next = nodes[j];
            }

            nodes = new ListNode[k];
        }

        if (i > 0 && pre != null){
            pre.next = nodes[k - 1];
        }

        return first;
    }
}
