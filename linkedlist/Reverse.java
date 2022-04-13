package linkedlist;

import common.ListNode;

/**
 * 反转链表
 */
public class Reverse {

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for (int i = 0; i < 5; i++) {
            ListNode current = new ListNode();
            current.val = i;
            tail.next = current;
            tail = tail.next;
        }
        ListNode head = reverseList(dummyHead.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
