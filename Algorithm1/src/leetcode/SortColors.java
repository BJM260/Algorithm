package leetcode;

import java.util.Arrays;

/**
 * 题目描述：LeetCode 75.颜色分类
 *      给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，
 *      使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列；此题中，我们使
 *      用整数0、1和2分别表示红色、白色和蓝色；
 * 注意：
 *      不能使用代码库中的排序函数来解决这道题；
 * 示例：
 *      输入: [2,0,2,1,1,0]
 *      输出: [0,0,1,1,2,2]
 * 进阶：
 *      一个直观的解决方案是使用计数排序的两趟扫描算法；
 *      首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组；
 *
 *      你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {
    public static void main(String[] args){
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 常规算法，使用辅助数组记录每个元素出现的个数，再遍历覆盖原先的数组；
     * @param nums
     */
    private static void sortColors(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        int[] count = new int[3];
        for(int i = 0; i < nums.length; ++i)
            ++count[nums[i]];
        int index = 0;
        for(int i = 0; i < count.length; ++i) {
            for(int j = 0; j < count[i]; ++j){
                nums[index++] = i;
            }
        }
        return;
    }

    /**
     * 使用三指针法解决此问题比较好：
     * 指针pre：跟踪0的最右边界；
     * 指针cur：当前考虑的元素；
     * 指针next：2的最左边界；
     * 思路：本解法的思路是沿着数组移动curr指针，若nums[curr] = 0，
     * 则将其与nums[p0]互换；若nums[curr] = 2，则与nums[p2]互换；
     * @param nums
     */
    private static void sortColors2(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        //初始化pre, cur, next
        int pre = -1;
        int cur = 0;
        int next = nums.length;
        //当前元素为0时与++pre交换，当前元素为1时++cur，当前元素为2时与--next交换
        for(; cur < next; ){
            if(nums[cur] == 0)
                swap(nums, ++pre, cur++);
            else if(nums[cur] == 2)
                swap(nums, --next, cur);
            else
                ++cur;
        }
    }
    //关于为什么nums[cur] == 0时交换元素后进行++cur，
    //而nums[cur] == 2时交换元素后不进行--cur操作的解释：
    //解释1：curr左边的值已经扫描过了，所以curr要++继续扫描下一位，
    //而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++；
    //解释2： cur 如果 与 p0 不是指向同一个索引，那 cur 指向的索引值
    //如果发生交换，那交换过来的一定是 1（原因是只有当遍历过的节点有1，p0 和 cur 才不会同步），
    //而 如果索引是 1 刚好也就不用有任何操作，所以可以直接++，右边的就不行；

    private static void swap(int[] nums, int i, int two){
        if(nums == null || nums.length == 0)
            return;
        int temp = nums[i];
        nums[i] = nums[two];
        nums[two] = temp;
    }
}
