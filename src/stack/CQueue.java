package stack;

import java.util.LinkedList;

/**
 * 两个栈模拟队列
 *
 * @author RanJianSong
 * @date 2021/5/11
 */
public class CQueue {
    // 模拟 queue
    private LinkedList<Integer> s1;
    // 辅助
    private LinkedList<Integer> s2;

    public CQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        }else {
           return s2.pop();
        }

    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.s1.push(1);
        cQueue.s1.push(2);
        cQueue.s1.push(3);
        System.out.println(cQueue.s1);
        cQueue.s1.pop();
        System.out.println(cQueue.s1);

    }
}
