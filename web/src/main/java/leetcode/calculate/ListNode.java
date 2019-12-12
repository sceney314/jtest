package leetcode.calculate;

import lombok.Data;

/**
 * 两数相加节点
 *
 * @author zhengzp
 * 2019-12-12 19:13
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;;

    public ListNode(int val) {
        this.val = val;
    }
}
