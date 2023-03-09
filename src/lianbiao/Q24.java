package lianbiao;

import java.util.Scanner;
public class Q24 {
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
    public static void main(String[] args){
        int[] x={1,2,3,4};

        Q24 demo=new Q24();
        ListNode head=demo.createList(x);
        ListNode node=demo.swapPairs(head);
        int a=1;
    }
}
