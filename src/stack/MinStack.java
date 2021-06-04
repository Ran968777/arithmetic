package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 用一个集合存储每插入一个元素后的最小值(集合的大小=栈的大小)
 */
public class MinStack {
    private Integer min = Integer.MAX_VALUE;
    private Map<Integer, Integer> minMap;
    private Deque<Integer> q;

    public MinStack() {
        minMap = new HashMap<>();
        q = new LinkedList<>();
    }

    public void push(int x) {
        int size = q.size();
        if (x < min) {
            min = x;
        }
        minMap.put(size + 1, min);
        q.push(x);
    }

    public void pop() {
        int size = q.size();
        if (size==1){
            min = Integer.MAX_VALUE;
        }
        Integer currMin = minMap.get(size);
        if (currMin.equals(min) && size != 1) {
            // 如果当前次的最小值等于全局最小值，就把全局最小值移动到上一次的最小值
            min = minMap.get(size - 1);
            minMap.remove(size);
        }
        q.pop();
    }

    public int top() {
        return q.size() == 0 ? -1 : q.peek();
//        int size = q.size();
//        if (size==0){
//            return -1;
//        }
//        Integer currMin = minMap.get(size);
//        if (currMin.equals(min) && size!=1) {
//            // 如果当前次的最小值等于全局最小值，就把全局最小值移动到上一次的最小值
//            min = minMap.get(size-1);
//        }

    }

    public int min() {
        return min;
    }

    //        ["MinStack","push","push","push","top","pop","min","pop","min","pop",  1"push","top","min", 123"push","top","min","pop","min"]
//        [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
//        System.out.println(minStack.top());
//        minStack.pop();
        System.out.println(minStack.min());
//
        minStack.pop();
//        System.out.println(minStack.min());
//        minStack.pop();
//
//        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
//
//        minStack.push(-2147483648);
//        System.out.println(minStack.top());
//        System.out.println(minStack.min());
//        minStack.pop();
//        System.out.println(minStack.min());


    }
}
