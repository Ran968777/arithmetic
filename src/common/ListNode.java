package common;

/**
 * @author Ran
 * @date 2021-06-04 11:17
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3000; i++) {


          sb.append("帅");
        }
        System.out.println(sb);
    }
}
