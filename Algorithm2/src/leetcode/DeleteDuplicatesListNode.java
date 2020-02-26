package leetcode;

/**
 * 题目描述：LeetCode 83.删除排序链表中的重复元素
 *      给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例1：
 *      输入: 1->1->2
 *      输出: 1->2
 * 示例2：
 *      输入: 1->1->2->3->3
 *      输出: 1->2->3
 */
public class DeleteDuplicatesListNode {
    public static void main(String[] args){

    }

    private static ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return null;
        ListNode curNode = head.next;
        ListNode preNode = head;
        for(; curNode != null; curNode = curNode.next)
            if(curNode.val != preNode.val){
                if(curNode != preNode.next)
                    preNode.next = null;
                preNode.next = curNode;
                preNode = preNode.next;
            }
        preNode.next = curNode;
        return head;
    }
}
