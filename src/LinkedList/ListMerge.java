package LinkedList;

public class ListMerge {
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA=headA,preB=headB;
        int lenA=0,lenB=0;
        while(preA!=null){
            lenA++;
            preA=preA.next;
        }
        while(preB!=null){
            lenB++;
            preB=preB.next;
        }
        preA=headA;
        preB=headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                preA=preA.next;
            }
        }else if(lenA<lenB){
            for(int i=0;i<lenB-lenA;i++){
                preB=preB.next;
            }
        }
        while (preA!=null || preB!=null){
            if(preA==preB){
                return preA;
            }else{
                preA=preA.next;
                preB=preB.next;
            }
        }
        return null;
    }
}
