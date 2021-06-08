package binarySearch;

import sun.security.provider.MD2;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 思路:
 * 1.数学的方法算,效率很差 Y
 * 2.在数组中找到第一个下标不等于元素值的元素,返回下标即可 N
 *
 * @author Ran
 * @date 2021-06-08 14:53
 */
public class TheLostNumber {
    public int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public int missingNumber2(int[] nums) {
        int sum = sum(nums.length);
        int t = 0;
        for (int num : nums) {
            t += num;
        }
        return sum - t;
    }

    public int missingNumber(int[] nums) {
        int head = 0, rear = nums.length - 1;

        while (head <= rear) {
            int mid = (head + rear) >> 1;
            if (nums[mid] == mid) {
                head = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        TheLostNumber theLostNumber = new TheLostNumber();
        int[] a = {0,1,2,3,4,5,6,7,9};
        int sum = theLostNumber.missingNumber(a);

        System.out.println(sum);
    }
}
