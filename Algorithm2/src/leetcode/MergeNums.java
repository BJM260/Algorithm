package leetcode;

import java.util.Arrays;

/**
 * 题目描述：LeetCode 88.合并两个有序数组
 *      给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明：
 *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */
public class MergeNums {
    public static void main(String[] args){
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums1 = new int[]{0};
//        int[] nums2 = new int[]{2, 5, 6};
        int[] nums2 = new int[]{1};
        merge3(nums1, 0, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 思路：最简单的方式，合并之后再排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge1(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums1.length == 0)
            return;
        if(nums2 == null || nums2.length == 0)
            return;
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 思路：合并数组，双指针法，i指针指向nums1开头，j指针指向nums2开头；
     * 每一步将最小元素存入数组nums1中，nums1中插入元素后需要往后移动nums1数组的元素；
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge2(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums1.length == 0)
            return;
        if(nums2 == null || nums2.length == 0)
            return;
        int count = 0;
        for(int i = 0, j = 0; i < m + n && j < n; ){
            if(nums1[i] <= nums2[j] && i < m + count) {
                ++i;
            } else{
                for(int k = m + (count++); k >= i + 1;)
                    nums1[k] = nums1[--k];
                nums1[i++] = nums2[j++];
            }
        }
    }

    /**
     * 优美的算法：从尾部开始向头部遍历；
     * 指针p指向合并之后的数组最后一个元素；
     * 指针p1指向nums1最后一个元素；
     * 指针p2指向nums2最后一个元素；
     *
     * 思路：从尾部开始遍历元素，在nums1和nums2中把大点的元素存入合并之后的数组的p位置；
     * 有特例，nums1[0], m = 0; nums2[1], n = 1;
     * 需用最后一句解决：System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge3(int[] nums1, int m, int[] nums2, int n){
        if(nums1 == null || nums1.length == 0)
            return;
        if(nums2 == null || nums2.length == 0)
            return;
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2])? nums2[p2--]: nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
