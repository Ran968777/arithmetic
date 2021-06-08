package recursion;

/**
 * 斐波那契数列第n项等于前2项知乎, 小青蛙跳台阶也是类似
 * @author Ran
 * @date 2021-06-04 17:05
 */
public class Fibonacc {
    public static int getN(int n){
        if (n==1 || n==2){
            return 1;
        }
        // 尾递归
        return getN(n-1)+getN(n-2);
    }

    public static void main(String[] args) {
        System.out.println(getN(10));
    }
}
