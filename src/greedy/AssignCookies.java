package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分配饼干 Y
 *
 * @author Ran
 * @date 2021-06-09 15:25
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        /**
         * 排序
         */
        List<Integer> girls = Arrays.stream(g).boxed().sorted().collect(Collectors.toList());
        List<Integer> cookies = Arrays.stream(s).boxed().sorted().collect(Collectors.toList());


        /**
         * 遍历两个数组中小的那个
         */
        List<Integer> cookiesBak = new ArrayList<>();
        cookiesBak.addAll(cookies);

        int amount = 0;
        for (Integer girl : girls) {
            int index = find(girl, cookiesBak);
            if (index != -1) {
                cookiesBak.remove(index);
                amount++;
            }

        }
        return amount;

    }

    /**
     * 二分查找,找到大于等或者goal的最小值
     *
     * @param goal
     * @param list
     * @return 能找到这样的值
     */
    int find(int goal, List<Integer> list) {
        int head = 0, rear = list.size() - 1;
        int mid = 0;
        while (head <= rear) {
            mid = (head + rear) / 2;
            if (list.get(mid) < goal) {
                head = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        if (list.get(mid)>= goal) {
            return mid;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 5, 5, 5, 7, 7, 8, 9, 10);
        AssignCookies assignCookies = new AssignCookies();
        int i = assignCookies.find(4, arr);
        System.out.println(arr.get(i));
        int i1 = assignCookies.find(6, arr);
        System.out.println(arr.get(i1));
        int i2 = assignCookies.find(6, arr);
        System.out.println(arr.get(i2));
//        assignCookies.find(11, arr);

    }

    public int findContentChildren2(int[] g, int[] s) {
        /**
         * 排序
         */
        List<Integer> girls = Arrays.stream(g).boxed().sorted().collect(Collectors.toList());
        List<Integer> cookies = Arrays.stream(s).boxed().sorted().collect(Collectors.toList());
//        for (Integer cookie : cookies) {
//
//        }
        return 0;
    }

}
