package companytest;

import java.util.Scanner;

public class DeleteReplicate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int res = calculateLongNums(nums);
        System.out.println(res);
    }

    private static int calculateLongNums(String[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int temp;
        int sum = 0;
        int num = 1;
        int j = 0;

        for(int i = 0; i < nums.length - 1; ++i){
            temp = Integer.parseInt(nums[i]);
            if(nums[i].equals(nums[i + 1])){
                if(num < temp)
                    ++num;
            }else {
                sum = sum + num;
                num = 1;
                j = i + 1;
            }
        }

        sum = sum + num;
        if(nums[0].equals('1'))
            --num;
        return sum;
    }
}
