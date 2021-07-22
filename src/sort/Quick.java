package sort;

/**
 * 快速排序
 * 算法描述
 * 从数列中挑出一个元素，称为"基准"（pivot），
 * 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * @author Ran
 * @date 2021-07-22 10:50
 */
public class Quick {
    public static Integer[] quickSort(Integer[] arr){
        qsort(arr, 0, arr.length-1);
        return arr;
    }
    private static void qsort(Integer[] arr, int low, int high){
        if (low >= high)
            return;
        int pivot = partition(arr, low, high);        //将数组分为两部分
        qsort(arr, low, pivot-1);                   //递归排序左子数组
        qsort(arr, pivot+1, high);                  //递归排序右子数组
    }
    public static int partition(Integer[] arr, int low, int height) {
        // 基准
        int pivot = arr[low];
        while (low < height) {
            while (low < height && arr[height] >= pivot) {
                height--;
            }
            // 跳出while,说明找到了数组尾巴上小于基准的值,把小的值放到数组前面
            arr[low] = arr[height];
            while (low < height && arr[low] <= pivot) {
                low++;
            }
            // 跳出while,说明找到了数组开始大于基准的值,把大值放到数组后面
            arr[height] = arr[low];
        }
        //扫描完成，基准到数组中间的位置
        arr[low] = pivot;
        //返回的是基准的位置
        return low;
    }

    public static void main(String[] args) {
        CommonData.equal(quickSort(CommonData.ARR));
    }
}
