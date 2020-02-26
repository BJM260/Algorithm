package leetcode;

/**
 * 题目描述：Leetcode 27.移除元素
 *      给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
 *      返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组
 *      并在使用 O(1) 额外空间的条件下完成。元素的顺序可以改变。你不需要考虑数组
 *      中超出新长度后面的元素。
 *  示例1：
 *      给定 nums = [3,2,2,3], val = 3,
 *      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 *  示例2：
 *      给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *      函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *      注意这五个元素可为任意顺序。
 *      你不需要考虑数组中超出新长度后面的元素。
 *  说明：
 *      为什么返回数值是整数，但输出的答案是数组呢?
 *      请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 */
public class RemoveElement {
    public static void main(String[] args){
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    /**
     * 使用快慢指针，slow：慢指针，fast：快指针；
     * 当nums[fast]与给定值相等时，递增fast以跳过该元素；只要nums[fast]不等于val，
     * 交换nums[slow]和nums[fast]并同时递增两个索引；重复这一过程直到fast到达，数组末尾；
     * 该数组的新长度为slow；
     * @param nums
     * @param val
     * @return
     */
    private static int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 0;
        for(; fast < nums.length; ++fast){
            if(nums[fast] != val)
                swapNums(nums, slow++, fast);
        }
        return slow;
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
