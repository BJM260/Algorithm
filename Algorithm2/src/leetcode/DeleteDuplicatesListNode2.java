package leetcode;

/**
 * 题目描述：LeetCode 82.删除排序链表中的重复元素Ⅱ
 *      给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 * 示例1：
 *      输入: 1->2->3->3->4->4->5
 *      输出: 1->2->5
 * 示例2：
 *      输入: 1->1->1->2->3
 *      输出: 2->3
 */
public class DeleteDuplicatesListNode2 {
    public static void main(String[] args){

    }

    /**
     * 本算法使用了一个虚拟头节点（自己在算法中新声明了个head节点前的节点）；
     * 使用pre和cur两个指针遍历链表，其中pre始终指向当前遍历过的节点中未重复的节点的最后一个节点(初始化时pre指向虚拟头节点)，而cur始终指向当前节点；
     * 使用双层循环遍历链表，外层循环一直确定pre和cur的关系（pre指向cur还是指向cur的next）；
     * 内层循环让cur指向重复节点的最后一个节点；
     * @param head
     * @return
     */
    private static ListNode deleteDuplicatesListNode2(ListNode head){
        if(head == null)
            return null;
        //声明一个虚拟头节点，并让它指向head节点
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode pre = pHead;
        ListNode cur = head;
        //使用cur节点遍历链表
        while(cur != null){
            //让cur节点保持指向重复节点中的最后一个节点，若当前节点不是重复节点则不执行此循环
            while (cur.next != null && cur.val == cur.next.val)
                cur = cur.next;
            //确立pre节点和cur节点的关系，cur节点始终在pre节点的后边
            if(pre.next == cur)
                pre = pre.next;
            else
                pre.next = cur.next;
            cur = cur.next;
        }

        return pHead.next;
    }
}
