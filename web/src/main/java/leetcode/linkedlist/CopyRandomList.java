package leetcode.linkedlist;

import java.util.HashMap;

/**
 * 2020-05-19 22:18
 */
public class CopyRandomList {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        CopyRandomList crl = new CopyRandomList();
        Node head = new Node(-1);
        head.random = head;
        System.out.println(crl.copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node first = null;
        Node pre = null;
        while(head != null){
            if(first == null){
                first = new Node(head.val);
                pre = first;
                map.put(head, first);
                if(head.random == head){
                    first.random = first;
                }else if(head.random != null){
                    first.random = new Node(head.random.val);
                    map.put(head.random, first.random);
                }
            }else{
                if(map.containsKey(head)){
                    pre.next = map.get(head);
                }else{
                    pre.next = new Node(head.val);
                    map.put(head, pre.next);
                }

                if(head.random == head){
                    pre.next.random = pre.next;
                }else if(map.containsKey(head.random)){
                    pre.next.random = map.get(head.random);
                }else if(head.random != null){
                    pre.next.random = new Node(head.random.val);
                    map.put(head.random, pre.next.random);
                }
                pre = pre.next;
            }

            head = head.next;
        }

        return first;
    }
}
