package stack;


import java.util.*;

/**
 * 删除最外层的括号 Y
 */
public class OutermostParentheses {


    /**
     * 思路:
     * 拆分成byte数组,遍历压入stack.
     * 遇到')'就弹出一个stack中的元素.
     * 若弹出后stack为null,将当前下标的元素置为"",并且将start = 当前下标+1;
     */
    public String removeOuterParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        int length = s.length();
        char[] split = new char[length];
        s.getChars(0, length, split, 0);
        String res = "";
        // 开始的下标
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (41 != split[i]) {
                stack.push(split[i]);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    split[start] = ' ';
                    split[i] = ' ';
                    res += new String(split, start, i - start).trim();
                    start = i + 1;
                }

            }
        }
        return res;
    }

    public String removeOuterParentheses2(String s) {
        Deque<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);

        int length = s.length();
        int start = 0;
        int times = 0;
        for (int i = 0; i < length; i++) {
            if (41 != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    sb.replace(i - times * 2, 1 + i - times * 2, "");
                    sb.replace(start - times * 2, start + 1 - times * 2, "");
                    start = i + 1;
                    times++;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OutermostParentheses op = new OutermostParentheses();
        String s = op.removeOuterParentheses2("(()())(())");
        System.out.println(s);
//        StringBuilder sb = new StringBuilder("(()())(())");
//        int length = sb.length();
//        System.out.println(length);
//        sb.replace(length-1,length,"");
    }
}
