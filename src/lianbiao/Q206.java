package lianbiao;

public class Q206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode createList(int[] x){
        ListNode head=new ListNode(-1,null);
        ListNode cur=head;
        for(int i=0;i<x.length;i++){
            ListNode node=new ListNode(x[i],null);
            cur.next=node;
            cur=node;
        }
        return head.next;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=head,cur=head.next,next=cur.next;
        head.next=null;
        while(next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=next.next;
        }
        cur.next=pre;
        return cur;
    }
    public static void main(String[] args){
        int[] x={1,2,6,3,4,5,6};
        int val=6;
        Q206 demo=new Q206();
        ListNode head=demo.createList(x);
        ListNode newHead=demo.reverseList(head);
        int a=1;
    }
}
