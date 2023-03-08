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
        if(head.next==null){
            head=null;
        }
        ListNode pre=head,cur=head.next;
        while(cur!=null){
            ListNode temp=null;
            for(int i=0;i<n;i++){
                temp=cur.next;
            }
            if(temp==null){
                pre.next=cur.next;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        return head;
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
        int[] x={1,2,6,3,4,5,6};
        int val=3;
        Q19 demo=new Q19();
        ListNode head=demo.createList(x);
        ListNode node=demo.removeNthFromEnd(head,val);
        int a=1;
    }
}
