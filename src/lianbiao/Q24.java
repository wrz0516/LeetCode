package lianbiao;

public class Q24 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1,head);
        ListNode temp=dummy,pre=head,cur=head.next;

        while(cur!=null){
            pre.next=cur.next;
            temp.next=cur;
            cur.next=pre;
            temp=pre;
            pre=pre.next;
            if(pre==null){
                break;
            }else{
                cur=pre.next;
            }
        }
        return dummy.next;
    }
}
