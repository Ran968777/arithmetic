package sort;


/**
 * 冒泡总结：
 * 稳定
 * 时间复杂度： O(n^2)
 * 每趟循环可以把一个元素放在最终的位置上
 * Date：2021-07-19 21:37
 */
public class Bubble {

    public static Integer[] sol(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换位置
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
        return arr;
    }

    public static void main(String[] args) {
       CommonData.equal(sol(CommonData.ARR));
    }
}
