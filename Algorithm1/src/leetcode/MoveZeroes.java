package leetcode;

import java.util.Arrays;

/**
 * 题目描述：Leet code 283.移动零
 *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例：
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 * 说明:
 *      1.必须在原数组上操作，不能拷贝额外的数组。
 *      2.尽量减少操作次数。
 */
public class MoveZeroes {
    public static void main(String[] args){
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：
     * 使用快慢指针解决：
     * 慢指针slow指向首个零元素，快指针fast指向当前元素；它们两个相互交换；有以下集中情况：
     * ①slow指向0元素，fast指向非零元素；
     * ②slow指向非零元素，fast指向什么无所谓；
     * ③fast指向0元素，fast指向0元素；
     * 其中不管fast指向的元素值为多少，每次遍历都要++；而slow在情况③时不进行++操作；
     * @param nums
     */
    private static void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        int slow = 0;
        int fast = 1;
        for(; fast < nums.length; ++fast){
            if(nums[slow] == 0 && nums[fast] != 0){
                swapNums(nums, slow++, fast);
            }else if(nums[slow] != 0){
                ++slow;
                continue;
            }
        }
        return;
    }

    private static void swapNums(int[] nums, int slow, int fast){
        if(nums == null || nums.length == 0)
            return;
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
        return;
    }
}
