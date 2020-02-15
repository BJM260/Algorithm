package companytest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

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
