package leetcode;

import java.util.Arrays;

/**
 * 题目描述：LeetCode 80.删除排序数组中的重复项Ⅱ
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
 *      返回移除后数组的新长度；不要使用额外的数组空间，你必须在原地修改输入数组并
 *      在使用 O(1) 额外空间的条件下完成；
 *
 * 示例1：
 *      给定 nums = [1,1,1,2,2,3],函数应返回新长度 length = 5, 并且原数组的前
 *      五个元素被修改为 1, 1, 2, 2, 3 ；你不需要考虑数组中超出新长度后面的元素；
 * 示例2：
 *      给定 nums = [0,0,1,1,1,1,2,3,3],函数应返回新长度 length = 7, 并且原数
 *      组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 ；你不需要考虑数组中超出新长
 *      度后面的元素；
 *
 * 说明：
 *      为什么返回数值是整数，但输出的答案是数组呢?请注意，输入数组是以“引用”方式
 *      传递的，这意味着在函数里修改输入数组对于调用者是可见的；
 */
public class RemoveDuplicates2 {
    public static void main(String[] args){
//        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 4};
        int res = removeDuplicates(nums);
//        System.out.println(removeDuplicates(nums));
        System.out.println("length:" + res + ";\nnums:" + Arrays.toString(nums));
    }

    /**
     * 使用双指针法，指针j指向被覆盖的元素，指针i指向当前元素；
     * 若nums[i]和nums[i - 1]相等，则说明出现重复元素，固++count；
     * 若nums[i]和nums[i - 1]不相等，则说明出现新的元素，count初始化为1；
     * 只要count<=2，则必须使用nums[i]覆盖nums[j]，之后进行++j；
     *
     * 总结：其实这个算法非常的优雅；
     * 她所使用的三个变量，i始终指向当前元素，且它每次都只与它前边的变量比较；
     * j始终指向被覆盖的元素；
     * 而count始终代表当前i指向元素所出现的个数；
     * @param nums
     * @return
     */
    private static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;

        int j = 1, count = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == nums[i - 1])
                ++count;
            else
                count = 1;
            if(count <= 2)
                nums[j++] = nums[i];
        }
        return j;
    }
}
