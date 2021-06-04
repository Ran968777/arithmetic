package greedy;

/**
 * INTERSECTION-OF-TWO-LINKED-LISTS  Y
 *
 * @author Ran
 * @date 2021-06-04 10:34
 */

import common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class IntersectionOfTwoLinkedList {


    /**
     * 输入：intersectVal = 8, listA =   [4,1,8,4,5],
     * listB = [5,0,1,8,4,5],
     * skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 第一个指针
        ListNode p1 = headA;
        // 第二个指针
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(6, a3);
        ListNode a1 = new ListNode(2, a2);

        ListNode b2 = new ListNode(5);
        ListNode b1 = new ListNode(1, b2);

        ListNode intersectionNode = getIntersectionNode(a1, b1);
    }
}
