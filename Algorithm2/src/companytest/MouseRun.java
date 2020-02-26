import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 力扣62题：不同路径（https://leetcode-cn.com/problems/unique-paths/）
 * 题目描述：
 *      一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）；
 *      机器人每次只能向下或者向右移动一步；机器人试图达到网格的右下角（在下图中标记为“Finish”）；
 *      问总共有多少条不同的路径？
 * 说明：m和n的值均不超过100；
 * 例子1：
 *      输入：m=3，n=2
 *      输出：3
 * 例子2：
 *      输入：m=7，n=3
 *      输出：28
 */
public class MouseRun {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        BigInteger res = calculateStep(m, n);
        System.out.println(res);
    }

    private static BigInteger calculateStep(int m, int n){
        if(m == 0 || n == 0)
            return new BigInteger(String.valueOf(0));
        BigInteger[] nums = new BigInteger[n];
        Arrays.fill(nums, new BigInteger(String.valueOf(1)));
        for(int i = 1; i < m; ++i)
            for(int j = 1; j < n; ++j)
                nums[j] = nums[j].add(nums[j - 1]);

        return nums[n - 1];
    }
}
