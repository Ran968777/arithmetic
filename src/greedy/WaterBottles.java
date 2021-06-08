package greedy;

/**
 * 1518. 换酒问题 Y
 *
 * @author Ran
 * @date 2021-06-04 14:48
 */
public class WaterBottles {

    /**
     * 1. 模拟的方法
     * 每次拿到空瓶都判断能换多少瓶,
     * 空瓶数 = 原来的空瓶数 + 新得到(1-交换一次需要的瓶数)
     * total += 每次新得到的瓶数
     *
     */
    /**
     * @param numBottles  买的瓶数
     * @param numExchange 多少空瓶可以换一瓶酒
     * @return
     */
    public static int numWaterBottles(int numBottles, int numExchange) {
        int empty = numBottles;
        while (empty >= numExchange) {
            // 每次能交换多少瓶
            int exchanges = empty / numExchange;
            empty = empty + (exchanges * (1 - numExchange));
            numBottles += exchanges;
        }
        return numBottles;
    }

    /**
     * 官方解答之一 : 数学的算法,直接算出来
     */
    public static int numWaterBottles2(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;

    }


    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
}
