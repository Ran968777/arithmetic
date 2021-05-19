package stack;

import java.util.*;

/**
 * No.496
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
 */
public class NextGreaterNum {

    /**
     * 思路：暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = nums1.length - 1; i >= 0; i--) {
            int curr = nums1[i];
            int index = getIndex(curr, nums2);
            // 当没找到或者元素已在nums末尾时，直接存入-1
            if (index == -1) {
                res[i] = -1;
                continue;
            } else {
                while (true) {
                    if (index == nums2.length - 1) {
                        res[i] = -1;
                        break;
                    }
                    if (nums2[index + 1] > curr) {
                        res[i] = nums2[index + 1];
                        break;
                    } else {
                        index++;
                    }
                }
            }


        }
        return res;

    }

    private int getIndex(int goal, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (goal == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 用栈+哈希表
     * 思路：
     * 把nums2中所有元素右边第一个大于它的元素存入哈希表，在遍历nums取查询哈希表即可
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(N)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 所有的元素都会存入到stack中一次
            while ((!stack.isEmpty()) && stack.peek() < nums2[i]) {
                stack.pop();
            }

            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }

        int length = nums1.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }


    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        NextGreaterNum next = new NextGreaterNum();
        int[] ints = next.nextGreaterElement2(nums1, nums2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
