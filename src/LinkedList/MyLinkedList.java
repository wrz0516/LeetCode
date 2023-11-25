package LinkedList;

public class MyLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    int size;
    ListNode head;
    public MyLinkedList() {
        size=0;
        head=new ListNode(-1,null);
    }

    public int get(int index) {
        if(index>=size || index<0){
            return -1;
        }
        ListNode cur=head;
        for(int i=0;i<=index;i++){
            cur=cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index<0){
            index=0;
        }
        ListNode cur=head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        ListNode newNode=new ListNode(val);
        newNode.next = cur.next;
        cur.next=newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode cur=head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
    }


    public static void main(String[] args){
        int[] x={1,2,6,3,4,5,6};

        MyLinkedList demo=new MyLinkedList();
//        for(int i=0;i<x.length;i++){
//            demo.addAtIndex(i,x[i]);
//        }
        demo.addAtTail(7);
        int a=1;
    }
}
