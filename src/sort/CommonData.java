package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonData {
    public static final Integer[] ARR = {3, 4, 1, 38, 15, 90, 47, 50, 68, 90, 100, 2, 9};

    public static boolean equal(Integer[] arr) {
        List<Integer> list = transList(ARR);
        List<Integer> list2 = transList(arr);
        if (list.size() != arr.length) return false;
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(list2.get(i))) {
                System.out.println("expect: " + list.toString());
                System.out.println("actual: " + list2.toString());
                return false;
            }
        }
        System.out.println("恭喜：排序成功");
        return true;
    }

    private static List<Integer> transList(Integer[] arr) {
        List<Integer> list = new ArrayList<>();
        for (Integer integer : arr) {
            list.add(integer);
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        equal(ARR);
    }
}
