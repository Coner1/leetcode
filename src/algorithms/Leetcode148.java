package algorithms;

import base.ListNode;

public class Leetcode148 {
    public static void main(String[] args) {
        ListNode listNode = new Leetcode148().sortList(ListNode.parseArrays(new int[]{4, 2, 1, 3}));
        listNode.print();
    }
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            ListNode post = head.next;
            head.next = null;
            return mergeTwoSortedList(head, post);
        }
        ListNode fastNode = head;
        ListNode slowNode = head;
//        System.out.println(fastNode);
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode postHead = slowNode.next;
        slowNode.next = null;
//        System.out.println(String.format("pre=%s,post=%s",preHead, postHead));
        ListNode preSorted = sortList(head);
        ListNode postSorted = sortList(postHead);
        return mergeTwoSortedList(preSorted, postSorted);
    }


    private ListNode mergeTwoSortedList(ListNode preSorted, ListNode postSorted){
//        System.out.println(String.format("pre=%s,post=%s",preSorted, postSorted));
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(preSorted != null && postSorted != null){
            if(preSorted.val > postSorted.val){
                cur.next = postSorted;
                postSorted = postSorted.next;
            }else{
                cur.next = preSorted;
                preSorted = preSorted.next;
            }
            cur = cur.next;
        }
        if(preSorted == null){
            cur.next = postSorted;
        }else {
            cur.next = preSorted;
        }
        return dummyHead.next;
    }
}
