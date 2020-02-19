package leetcode;

public class DeleteDuplicatesListNode2 {
    public static void main(String[] args){

    }

    private static ListNode deleteDuplicatesListNode2(ListNode head){
        if(head == null)
            return null;
        ListNode preNode = head;
        ListNode curNode = head;

        for(; curNode.next != null; curNode = curNode.next){
            if(curNode.val != curNode.next.val){
                curNode = curNode.next;
                preNode.next = curNode;
                preNode = preNode.next;
            }
        }
    }
}
