package sort;

import common.ListNode;
import java.util.Random;

/**
 * 链表归并排序
 */
public class MergeSortForLinkedList {

    public static void main(String[] args) {
        Random random = new Random();
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        for (int i = 0; i < 5; i++) {
            ListNode current = new ListNode();
            current.val = random.nextInt(100);
            tail.next = current;
            tail = tail.next;
        }
        ListNode head = sortList(dummyHead.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = (left == null) ? right : left;
        return dummyHead.next;
    }

    private static ListNode getMid(ListNode head) {
        ListNode mid = null;
        while (head != null && head.next != null) {
            mid = (mid == null) ? head : mid.next;
            head = head.next.next;
        }
        ListNode tmp = (mid == null) ? head : mid.next;
        if (mid != null) {
            mid.next = null;
        }
        return tmp;
    }
}
