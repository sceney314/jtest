package algorithm.elimination;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

/**
 * LRU（Least recently used，最近最少使用）
 *
 * 原理：LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高”。
 *
 * 最常见的实现是使用一个链表保存缓存数据，详细算法实现如下：
 * 1. 新数据插入到链表头部；
 * 2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部；
 * 3. 当链表满的时候，将链表尾部的数据丢弃。
 *
 * 2020-04-17 19:47
 */
@Data
public class LeastRecentlyUsed {
    private Node head;

    private Node tail;

    private int maxCapacity;

    private int size;

    private Node revise(int val){
        Node h = head;
        if (h == null){
            return null;
        }

        while (h != null){
            if (h.val == val){
                break;
            }
            h = h.next;
        }

        // 存在，且不头（是头，不需要调整）
        if (h != null && h != head){
            h.prev.next = h.next;
            if (h.next == null){
                tail = h.prev;
            }else{
                h.next.prev = h.prev;
            }

            head.prev = h;
            h.prev = null;
            h.next = head;
            head = h;
        }

        return h;
    }

    public void add(int val){
        Node n = revise(val);
        if (n == null){
            n = new Node(val);
            Node h = head;
            if (head == null){
                head = tail = n;
            }else {
                n.next = h;
                h.prev = n;
                head = n;
            }
            size++;
            if (size > maxCapacity){
                Node t = tail;
                if (t != null){
                    tail = t.prev;
                    t.prev.next = null;
                    t.prev = null;
                }
            }
        }
    }

    private List<Integer> getAll(){
        Node h = head;
        if (h == null){
            return null;
        }

        List<Integer> elems = new LinkedList<>();
        while (h != null){
            elems.add(h.val);
            h = h.next;
        }

        return elems;
    }


    public static void main(String[] args) {
        LeastRecentlyUsed lru = new LeastRecentlyUsed();
        lru.setMaxCapacity(5);

        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.add(6);
        lru.add(6);
        lru.add(7);
        lru.add(6);
        lru.add(8);
        lru.add(9);
        lru.add(6);

        System.out.println(lru.getAll());
    }

}
