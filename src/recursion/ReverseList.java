package recursion;

import common.ListNode;

/**
 * 反转链表,返回反转后的头节点
 *
 * @author Ran
 * @date 2021-06-04 17:13
 */
public class ReverseList {
    /**
     * 1.返回反转链表后的头结点,
     * 2.结束条件 进入的节点的next是null时返回
     * 3.等价关系
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newList = reverse(head.next);

        ListNode n1 = head.next;
        n1.next = head;
        head.next = null;

        return newList;

    }

    public static void main(String[] args) {
        ListNode a3 = new ListNode(4);
        ListNode a2 = new ListNode(6, a3);
        ListNode a1 = new ListNode(2, a2);
        ListNode reverse = reverse(a1);
        System.out.println(reverse.val);
        System.out.println(reverse.next.val);
        System.out.println(reverse.next.next.val);

    }
}
