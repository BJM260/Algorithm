package rememberalgorithm;

import java.util.Arrays;
import java.util.Random;

public class compositor {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 0, 8, 1, 7, 2, 6, 3, 5, 4};
//        int[] nums = new int[]{5, 2, 3, 1};
//        BubbleSort(nums);
//        insertSort(nums);
//        selectSort(nums);
//        quickSort2(nums, 0, nums.length - 1);
//        quickSort3(nums, 0, nums.length - 1);
        HeapSort(nums);
        System.out.println(Arrays.toString(nums));
//        while (true)
//            System.out.println(new Random(8).nextInt());
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    private static void BubbleSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        //冒泡次数，由于每个元素都与其相邻的元素作比较，但是不跟自己比较所以总的比较次数为数组长度减一
        for (int i = 0; i < nums.length - 1; ++i)
            //每遍历完一次，会选出最大（小）的一个元素，所以下次不需要跟这次选出来的元素比较，所以减i
            for (int j = 0; j < nums.length - 1 - i; ++j)
                //当前元素与下一个元素比较，大（小）时交换
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
    }

    /**
     * 冒泡算法改进版：
     * 改进点：冒泡排序的结束条件加了一条，即一趟排序过程中未发生关键字交换
     *
     * @param nums
     */
    private static void BubbleSort2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = nums.length - 1; i >= 1; --i) {
            boolean flag = true;
            for (int j = 1; j <= i; ++j)
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                    flag = false;
                }
            if (flag)
                return;
        }
    }

    /**
     * 直接插入排序：数组分为有序和无序两个部分，每次从无序部分中顺序拿出一个元素插入到有序部分的相应位置；
     *
     * @param nums
     */
    private static void insertSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length; ++i) {
            int temp = nums[i];     //待插入的元素
            int j = i - 1;      //j指向数组未排序部分的最后一个元素
            //在未排序部分中寻找到合适的位置插入元素temp，
            //会有往后移动元素给temp元素让出位置的问题
            while (j >= 0 && temp < nums[j])
                nums[j + 1] = nums[j--];
            nums[j + 1] = temp;
        }
    }

    /**
     * 简单选择排序：数组分有序和无序两个部分，每次从无序部分中选出最小（大）的元素插入到有序部分末尾；
     *
     * @param nums
     */
    private static void selectSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int i = 0; i < nums.length; ++i) {
            //无序序列中找出最小（大）的元素
            int min = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[min])
                    min = j;
            }
            //无序序列中取出最小（大）的元素插入到有序序列末尾
            swap(nums, i, min);
        }
    }

    /**
     * 快速排序：设定枢轴，递归遍历数组，每次把小于（大于）枢轴的元素放到枢轴的同一边，直到数组下线不小于数组上线为止
     *
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0)
            return;
        if (low < high) {     //数组下线小于上线时才进行交换
//            int randomNumber = new Random(low, high).nextInt();
            int temp = nums[low];   //定为枢轴
            int i = low;    //数组下线
            int j = high;   //数组上线
            while (i != j) {  //遍历数组中i到j的部分
                while (i < j && nums[j] >= temp) //从数组上线开始在数组中寻找小于枢轴的元素
                    --j;
                if (i < j)   //刚刚的元素放到枢轴左边
                    nums[i++] = nums[j];
                while (i < j && nums[i] <= temp) //从数组下线开始在数组中寻找大于枢轴的元素
                    ++i;
                if (i < j)   //刚刚的元素放到枢轴的右边
                    nums[j--] = nums[i];
            }
            nums[i] = temp; //temp放在中间值的位置
            quickSort(nums, low, i - 1);    //递归的对数组枢轴左边的部分进行排序
            quickSort(nums, i + 1, high);    //递归的对数组枢轴右边的部分进行排序
        }
    }

    /**
     * 快排优化版:随机选择枢轴
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort2(int[] nums, int low, int high) {
        if (nums == null || nums.length == 0)
            return;
        if (low < high) {
            //随机选择枢轴：生成随机数，然后此数对应的元素与low对应的元素互相交换
            int index = new Random().nextInt(high - low + 1) + low;
            swap(nums, low, index);
            int pivot = nums[low];
            int i = low;
            int j = high;

            while (i < j) {
                while (i < j && pivot <= nums[j])
                    --j;
                if (i < j)
                    nums[i++] = nums[j];
                while (i < j && pivot >= nums[i])
                    ++i;
                if (i < j)
                    nums[j--] = nums[i];
            }

            nums[i] = pivot;
            quickSort2(nums, low, i - 1);
            quickSort2(nums, j + 1, high);
        }
    }

    /**
     * 三路快排：<pivot(小于pivot) ==pivot(等于pivot) >pivot(大于pivot)三个部分，从头到尾遍历；每遍历完一次，都要递归遍历pivot的左右部分；
     * @param nums
     * @param low
     * @param high
     */
    private static void quickSort3(int[] nums, int low, int high){
        if(nums == null || nums.length == 0)
            return;
        if(low > high)
            return;

        int pivot = nums[low];
        int l = low - 1;
        int h = high + 1;
        int i = low + 1;

        while (i < h){
            if(nums[i] < pivot)
                swap(nums, ++l, i++);
            else if(nums[i] > pivot)
                swap(nums, i, --h);
            else
                ++i;
        }

        //递归进行排序
        quickSort3(nums, low, l);
        quickSort3(nums, h, high);
    }

    /**
     * 堆排序：
     * @param nums
     */
    private static void HeapSort(int[] nums){
        if(nums == null || nums.length == 0)
            return;
        //构建大顶堆
        for(int i = nums.length / 2 - 1; i >= 0; --i)
            HeapAdjust(nums, i, nums.length);
        //逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for(int i = nums.length - 1; i > 0; --i){
            swap(nums, 0, i);   //将堆顶记录和当前未经排序子序列的最后一个记录交换
            HeapAdjust(nums, 0, i); //交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }
    }

    /**
     * 构建堆
     * @param nums  数组
     * @param i 需构建堆的根节点序列
     * @param n 数组长度
     */
    private static void HeapAdjust(int[] nums, int i, int n){
        if(nums == null || nums.length == 0)
            return;
        int child;
        int father;
        for(father = nums[i]; (child = LeftChild(i)) < n; i = child){
//            child = LeftChild(i);
            //如果左子树小于右子树，则需要比较右子树和父节点
            if(child != n - 1 && nums[child] < nums[child + 1])
                ++child;    //序号增1，指向右子树
            //如果父节点小于孩子节点，则需要交换
            if(father < nums[child])
                nums[i] = nums[child];
            else
                break;  //大顶堆结构未被破坏，不需要调整
        }
        nums[i] = father;
    }

    /**
     * 获取左孩子下标
     * @param i
     * @return
     */
    private static int LeftChild(int i){
        return 2 * i + 1;
    }

    /**
     * 交换数组nums中下标i和j的元素
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        if (nums == null || nums.length == 0)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
