package others;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 将中缀表达式转为后缀表达式
 *
 * @author Ran
 * @date 2021-07-08 15:22
 */
public class mid2rear {

    /**
     * 从左到右开始扫描中缀表达式
     * 遇到数字， 直接输出
     * 遇到运算符
     * a.若为“(” 直接入栈
     * b.若为“)” 将符号栈中的元素依次出栈并输出, 直到 “(“, “(“只出栈, 不输出
     * c.若为其他符号, 将符号栈中的元素依次出栈并输出, 直到遇到比当前符号优先级更低的符号或者”(“。 将当前符号入栈。
     * 扫描完后, 将栈中剩余符号依次输出
     *
     * @param exp
     */
    public static String input(String exp) {
        // 运算符栈
        Stack<String> os = new Stack<>();
        String rear = "";

        String[] split = exp.split("");
        for (int i = 0; i < split.length; i++) {
            String temp = split[i];
            if (temp.equals("(")) {
                os.push(temp);
            } else if (temp.equals(")")) {
                while (true) {
                    if (os.peek().equals("(")) {
                        os.pop();
                        break;
                    } else {
                        rear += os.pop();
                    }
                }
            } else if (temp.matches("\\d+\\.?\\d*")) {
                rear += temp;
            }
            // 其它运算符 + - * /
            else {
                if (temp.equals("*") || temp.equals("/")) {
                    while (!os.empty() && (os.peek().equals("*") || os.peek().equals("/"))) {
                        rear += os.pop();
                    }
                    os.push(temp);
                } else if (temp.equals("+") || temp.equals("-")) {
                    while (!os.empty() && !os.peek().equals("(")) {
                        rear += os.pop();
                    }
                    os.push(temp);
                }
            }
        }

        while (!os.isEmpty()) {
            rear += os.pop();
        }
        return rear;
    }

    public static void main(String[] args) {
        String input = input("3*(4+2)");
        System.out.println(input);
    }
}
