package leetcode;

public class RemoveElement {
    public static void main(String[] args){
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    private static int removeElement(int[] nums, int val){
        if(nums == null || nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 1;
        for(; fast < nums.length; ++fast){
            if(nums[slow] == val && nums[fast] != val){
                swapNums(nums, slow++, fast);
            }else if(nums[slow] != val){
                ++slow;
                continue;
            }
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
