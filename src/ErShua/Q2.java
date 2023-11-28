package ErShua;

import java.util.List;

public class Q2 {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = new ListNode(0);
         ListNode cur = head;
         ListNode pre = null;
        while(l1!=null&&l2!=null){
            int temp = cur.val+l1.val+ l2.val;
            cur.val = temp%10;
            cur.next = new ListNode(temp/10);
            pre = cur;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int temp = cur.val+l1.val;
            cur.val = temp%10;
            cur.next = new ListNode(temp/10);
            pre = cur;
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int temp = cur.val+l2.val;
            cur.val = temp%10;
            cur.next = new ListNode(temp/10);
            pre = cur;
            cur = cur.next;
            l2 = l2.next;
        }
        if(cur.val==0) pre.next=null;
        return head;
    }
}
