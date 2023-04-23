package base;


public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append(val).append(",next=").append(next == null);
         return sb.toString();
     }
     public static ListNode parseArrays(int[] arrays){
        ListNode pre = new ListNode();
        ListNode cur = pre;
        for (int i : arrays) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return pre.next;
     }
     public void print(){
        ListNode cur = this;
        while(cur != null){
            System.out.print(cur.val);
            if(cur.next != null){
                System.out.print("->");
            }
            cur = cur.next;
        }
     }
}