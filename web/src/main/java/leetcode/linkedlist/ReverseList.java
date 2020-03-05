package leetcode.linkedlist;

import lombok.Data;

import java.util.HashSet;

/**
 * 翻转连表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * <p>
 * 2020-03-03 20:26
 */
public class ReverseList {
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

        System.out.println((new ReverseList()).reverseList(n1));
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        while(head != null){
            ListNode node = new ListNode(head.val);
            node.next = reverse;
            reverse = node;
            head = head.next;
        }

        return reverse;
    }
}
