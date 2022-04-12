package linkedlist;

import common.ListNode;

/**
 * 获取一个指定链表的中间节点 （存在两个时取后面一个）
 */
public class GetMidNode {

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for (int i = 0; i < 5; i++) {
            ListNode current = new ListNode();
            current.val = i;
            tail.next = current;
            tail = tail.next;
        }
        ListNode mid = getMid(dummyHead.next);
        System.out.println(mid.val);
    }

    private static ListNode getMid(ListNode head) {
        ListNode mid = null;
        while (head != null && head.next != null) {
            mid = (mid == null) ? head : mid.next;
            head = head.next.next;
        }
        mid = (mid == null) ? head : mid.next;
        return mid;
    }
}
