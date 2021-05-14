package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.20 有效的括号 N
 */
public class ValidParentheses {

    private byte l1 = "(".getBytes()[0];
    private byte r1 = ")".getBytes()[0];
    private byte l2 = "{".getBytes()[0];
    private byte r2 = "}".getBytes()[0];
    private byte l3 = "[".getBytes()[0];
    private byte r3 = "]".getBytes()[0];
    private Deque<Byte> stack;
    private Map<Byte, Byte> map;

    public ValidParentheses() {
        stack = new LinkedList<>();
        map = new HashMap<>();
        map.put(r1, l1);
        map.put(r2, l2);
        map.put(r3, l3);
    }

    /**
     * Input: s = "([)]"
     * Output: false
     */

    public boolean isValid(String s) {
        byte[] bytes = s.getBytes();
        if (bytes.length % 2 != 0) {
            return false;
        }
        for (byte aByte : bytes) {
            if (aByte == l1 || aByte == l2 || aByte == l3
            ) {
                stack.push(aByte);
            } else if (aByte == r1 || aByte == r2 || aByte == r3) {
                // 防止只有右括号
                if (stack.size() == 0) {
                    return false;
                }
                Byte pop = stack.pop();
                if (!map.get(aByte).equals(pop)) {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 不使用栈，但是性能很差
     * 思路：
     * 在正确的字符串中，一定在某个地方存在"()","[]","{}"的组合，而且这种组合的出现一定在[0,s.length() / 2]内，
     * 把他们替换成""，这样最后字符串的长度就会变成0了
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length() == 0;
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("()[]{}"));
    }
}
