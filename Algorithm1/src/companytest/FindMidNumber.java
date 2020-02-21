package companytest;

import java.util.Arrays;
import java.util.Scanner;

public class FindMidNumber {
    public static void main(String[] args){
//        int[] nums = new int[]{1, 4, 9, 10, 11, 23};
//        int[] nums2 = new int[]{2, 3, 8, 12, 13, 15};

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        int[] nums2 = new int[len];
        int i = 0;
        while(i < len)
            nums[i++] = sc.nextInt();
        i = 0;
        while(i < len)
            nums2[i++] = sc.nextInt();
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));

//        System.out.println((int)findMedianSortedArrays(nums, nums2));
    }

//    private static int findMidNumber(int[] nums, int[] nums2){
//        if(nums == null || nums.length == 0)
//            return nums2[nums2.length / 2];
//        if(nums2 == null || nums2.length == 0)
//            return nums[nums.length / 2];
//        Arrays.
//    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a, b;
        if(nums1.length <= nums2.length) {
            a = nums1;
            b = nums2;
        } else {
            a = nums2;
            b = nums1;
        }
        int m = a.length;
        int n = b.length;
        int low = 0;
        int high = m;
        int i, j;
        while(low <= high) {
            i = (low + high)/2;
            j = (m + n + 1)/2-i;
            if(i > low && a[i-1] > b[j])
                high = i - 1;
            else if(i < high && b[j-1] > a[i])
                low = i + 1;
            else {
                int maxLeft;
                if(i == 0)
                    maxLeft = b[j-1];
                else if(j == 0)
                    maxLeft = a[i-1];
                else
                    maxLeft = Math.max(a[i-1], b[j-1]);
                if((m+n)%2 == 1)
                    return maxLeft;

                int minRight;
                if(i == m)
                    minRight = b[j];
                else if(j == n)
                    minRight = a[i];
                else
                    minRight = Math.min(a[i], b[j]);
                return (maxLeft + minRight)/2.0;
            }
        }
        return 0.0;
    }
}
