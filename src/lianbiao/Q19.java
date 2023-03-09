package lianbiao;

public class Q19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1,head);
        ListNode slow=dummy,fast=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public ListNode createList(int[] x){
        ListNode head=new ListNode(-1,null);//头节点
        ListNode cur=head;
        for(int i=0;i<x.length;i++){
            ListNode node=new ListNode(x[i],null);
            cur.next=node;
            cur=node;
        }
        return head.next;
    }
    public static void main(String[] args){
        int[] x={1};
        int val=1;
        Q19 demo=new Q19();
        ListNode head=demo.createList(x);
        ListNode node=demo.removeNthFromEnd(head,val);
        int a=1;
    }
}
