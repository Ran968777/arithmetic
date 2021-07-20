package sort;

/**
 * @description: 选择排序
 * 不稳定 举个例子：数组 6、7、6、2、8，在对其进行第一遍循环的时候，会将第一个位置的6与后面的2进行交换。此时，就已经将两个6的相对前后位置改变了。因此选择排序不是稳定性排序算法。
 * 时间复杂度：O(n^2)
 * @author: Ran
 * @create: 2021-07-20 14:19
 **/
public class Selection {

    /**
     * 选择最小的数，放在最前面
     *
     * @param arr
     * @return
     */
    public static Integer[] sol(Integer[] arr) {
        int minIndex, temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            // 找到最小的下标
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i){
               temp =  arr[i];
               arr[i] = arr[minIndex];
               arr[minIndex] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        CommonData.equal(sol(CommonData.ARR));
    }
}
