package sort;

/**
 * @description: 归并排序
 * @author: Ran
 * @create: 2021-07-21 10:03
 **/
public class Merge {
    public static Integer[] mergeSort(Integer[] arr) {
        Integer[] temp = new Integer[arr.length];
        internalMergeSort(arr, temp, 0, arr.length - 1);
        return arr;
    }

    private static void internalMergeSort(Integer[] arr, Integer[] temp, int left, int right) {
        //当left==right的时，已经不需要再划分了
        if (left < right) {
            int middle = (left + right) / 2;
            internalMergeSort(arr, temp, left, middle);          //左子数组
            internalMergeSort(arr, temp, middle + 1, right);       //右子数组
            mergeSortedArray(arr, temp, left, middle, right);    //合并两个子数组
        }
    }

    // 合并两个有序子序列
    private static void mergeSortedArray(Integer arr[], Integer temp[], int left, int middle, int right) {
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
        Integer[] arr = CommonData.ARR;
        CommonData.equal(mergeSort(arr));
    }
}
