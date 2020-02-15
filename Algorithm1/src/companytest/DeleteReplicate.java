package companytest;

import java.util.Scanner;

/**
 * 题目描述：
 *      已知有序正整数数组，删除数组中重复的数字；使得数组中的数字满足以下要求：
 *      数字1最多允许出现一次，数字2最多允许出现两次，以此类推，数字n(n>0)最多允许出现n次；
 *      返回满足条件数组中数组长度的最大值；
 * 输入描述：
 *      正整数数组，每个数n（n > 0）以空格隔开；
 * 输出描述：
 *      输出最长数组长度，整型；
 * 例子1：
 *      输入：1 1 1 2 2 2 3 3 3
 *      输出：6
 */
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
        int temp;   //存储当前元素
        int sum = 0;    //存储符合条件数组的最长长度
        int num = 1;    //存储temp元素的实时出现次数

        //遍历数组
        for(int i = 0; i < nums.length - 1; ++i){
            temp = Integer.parseInt(nums[i]);
            //比较一个元素与其后边的元素，若相等统计当前元素出现的次数
            if(nums[i].equals(nums[i + 1])){
                //若当前元素出现的个数还未达到此元素值，进行++num
                if(num < temp)
                    ++num;
            }else { //若当前元素与其后边的元素不相等，计算当前符合条件的数组总长度，再初始化num=1，进入下一轮
                sum = sum + num;
                num = 1;
            }
        }
        //补充for循环退出后未能添加的长度
        sum = sum + num;
        return sum;
    }
}
