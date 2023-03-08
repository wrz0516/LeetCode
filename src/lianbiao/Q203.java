package lianbiao;
import java.util.Arrays;
import java.util.Scanner;

public class Q203 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1,head);
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
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
        int[] x={1,2,6,3,4,5,6};
        int val=6;
        Q203 demo=new Q203();
        ListNode head=demo.createList(x);
        ListNode node=demo.removeElements(head,val);

    }

}


