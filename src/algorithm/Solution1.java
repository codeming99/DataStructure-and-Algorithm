package algorithm;

/**
 * 删除链表值为val的元素(没有使用虚拟头结点)
 */
public class Solution1 {
    public ListNode removeElements(ListNode head,int val){

        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution1()).removeElements(head,6);
        System.out.println(res);

    }
}
