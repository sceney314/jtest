package leetcode.calculate;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author zhengzp
 * 2019-12-12 19:11
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(8);

        ListNode list2 = new ListNode(0);

        System.out.println(addTwoNumbers(list1, list2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        while (l1 != null || l2 != null){
            int first = l1 == null ? 0 : l1.val;
            int second = l2 == null ? 0 : l2.val;
            int cur = first + second + carry;
            carry = cur >= 10 ? 1 : 0;
            tmp.next = new ListNode(cur % 10);
            if (l1 != null){
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (carry == 1){
            tmp.next = new ListNode(1);
        }

        return node.next;
    }
}
