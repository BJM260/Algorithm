package leetcode;

import java.util.Arrays;

/**
 * 题目描述：leetcode 26.删除排序数组中的重复项
 *      给定一个排序数组，你需要在原地删除重复出现的元素，
 *      使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组
 *      并在使用 O(1) 额外空间的条件下完成。
 * 示例 1:
 *      给定数组nums = [1,1,2], 函数应该返回新的长度2,
 *      并且原数组nums的前两个元素被修改为1, 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度5,并且原数组nums的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *      为什么返回数值是整数，但输出的答案是数组呢?
 *      请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 */
public class RemoveDuplicates {
    public static void main(String[] args){
        int[] nums = new int[]{1, 1, 2};
        System.out.println("length:" + removeDuplicates(nums));
        System.out.println("nums:" + Arrays.toString(nums));

        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("length:" + removeDuplicates(nums2));
        System.out.println("nums:" + Arrays.toString(nums2));
    }

    /**
     * 双指针法：慢指针，快指针；
     * 慢指针slow：指向当前有序不重复的子数组最后一个元素；
     * 快指针fast：指向数组中当前元素；
     * 若nums[slow] == nums[fast]，++fast，让它跳过重复的元素；
     * 若nums[slow] != nums[fast]，此时跳过重复项的运行已结束，
     * 必须把nums[fast]的值复制到nums[slow+1]中，++slow；
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for(int j = 1; j < nums.length; ++j){
            if(nums[i] != nums[j] && (j - i >= 1))
                nums[++i] = nums[j];
        }

        return i + 1;
    }
}
