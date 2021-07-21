package sort;

/**
 * 归并，迭代
 *
 * @author Ran
 * @date 2021-07-21 15:38
 */
public class Merge2 {

    /**
     * 初始的length为1，把 2个相邻length长度的有序列比较后，存入临时数组
     *
     * @param arr
     */
    public static void sol(Integer[] arr) {
        int length = arr.length;
        int len = 1;// 宽度为1
        Integer[] temp = new Integer[length];

        while (len < length) {
            mergePass(arr, temp, len);
            len *= 2;
        }


    }

    /**
     * 初始length是1, 第一趟刚开始比较前2个元素 放入临时数组,
     * 第二趟 比较 前4个元素,放入临时数组
     *
     * @param arr
     * @param tempA
     * @param length
     */
    public static void mergePass(Integer[] arr, Integer[] tempA, int length) {
        int i = 0;
        for (; i < arr.length - 2 * length; i += 2 * length) {
            if (length == 1) {
                Merge1(arr, tempA, i, i, i + 2 * length - 1);
            } else {
                Merge1(arr, tempA, i, i + length, i + 2 * length - 1);
            }
        }
        // 归并最后2个子列
        if (i + length < arr.length) {
            Merge1(arr, tempA, i, i + length, arr.length - 1);
        } else {

        }

    }

    // 合并两个有序子序列
    private static void Merge1(Integer arr[], Integer temp[], int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++]; // 当左边的数字等于右边的数字是取左边的数，这样就保证了稳定性
        }
        // 左边数组不空
        while (i <= middle) {
            temp[k++] = arr[i++];
        }
        // 右边数组不空
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i = 0; i < k; ++i) {
            arr[left + i] = temp[i];
        }
    }


    public static void main(String[] args) {
        int len = 1;
        Integer[] arr = CommonData.ARR;
        while (len < arr.length) {
            mergePass(arr, new Integer[CommonData.ARR.length], 1);
            len *= 2;
        }
    }
}
