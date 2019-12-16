package leetcode.calculate;

import java.util.LinkedList;

/**
 * 两数相加 II
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author zhengzp
 * 2019-12-12 20:17
 */
public class AddTwoNumber2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));
    }

    /**
     * 解题思路
     *
     * 1、翻转连表
     * 2、不翻转连表，遍历一遍再计算
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> k1 = new LinkedList<>();
        while (l1 != null){
            k1.addFirst(l1.val);
            l1 = l1.next;
        }

        LinkedList<Integer> k2 = new LinkedList<>();
        while (l2 != null){
            k2.addFirst(l2.val);
            l2 = l2.next;
        }

        ListNode result = new ListNode(0);
        int carry = 0;
        while (!k1.isEmpty() || !k2.isEmpty()){
            int first = k1.isEmpty() ? 0 : k1.removeFirst();
            int second = k2.isEmpty() ? 0 : k2.removeFirst();
            int cur = first + second + carry;
            carry = cur / 10;
            result.val = cur % 10;
            ListNode tmp = new ListNode(0);
            tmp.next = result;
            result = tmp;
        }

        if (carry == 1){
            result.val = 1;
            ListNode tmp = new ListNode(1);
            tmp.next = result;
            result = tmp;
        }

        return result.next;
    }
}
