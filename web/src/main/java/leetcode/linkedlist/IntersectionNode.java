package leetcode.linkedlist;

/**
 * 2020-05-20 08:29
 */
public class IntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(4);
        headA.next.next = new ListNode(5);

        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);

        IntersectionNode man = new IntersectionNode();
        System.out.println(man.getIntersectionNode(headA, headB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(headA != null || headB != null){
            if(headA == headB && headA != null){
                return headA;
            }

            if(headA == null){
                headA = nodeA;
                nodeB = nodeB.next;
                headB = nodeB;
                continue;
            }else if(headB == null){
                headB = nodeB;
                nodeA = nodeA.next;
                headA = nodeA;
                continue;
            }

            headB = headB.next;
            headA = headA.next;
        }

        return null;
    }
}
