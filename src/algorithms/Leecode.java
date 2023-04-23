package algorithms;
import base.ListNode;
import base.TreeNode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.LongAdder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leecode {
    
    
    /**
     * leecode 2
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode curL1 = l1;
        ListNode curL2 = l2;
        
        int addToNext = 0;
        while (curL1 != null || curL2 != null){
            int sum = curL1.val + curL2.val + addToNext;
            int spare = sum;
            if(sum > 9){
                spare = sum%10;
                addToNext = 1;
            }
            
            cur.val = spare;
            if(addToNext > 0 || curL1 != null || curL2 != null){
                cur.next = new ListNode();
            }
            cur = cur.next;
            curL1 = curL1.next;
            curL2 = curL2.next;
        }
        //可能进位
        if(addToNext >0 ){
            cur.val = addToNext;
        }
        return head;
    }
    /**
     * 12
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersLeecode(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
    
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n ==2 ){
            return 2;
        }

        return climbStairs(n -1) + climbStairs(n -2);
    }

    private Map<Integer, Integer > climbStairsMapOptimized = new HashMap<>();
    public int climbStairsMapOptimized(int n) {
        Integer value = climbStairsMapOptimized.get(n);
        
        if(n == 1){
            return 1;
        }
        if(n ==2 ){
            return 2;
        }
        if( value != null){
            return value;
        }else{
            int steps = climbStairs(n -1) + climbStairs(n -2);
            climbStairsMapOptimized.put(n, steps);
            return steps;
        }
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        if(root.left != null){
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if(root.right != null){
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depthLeft = minDepth0(root.left);
        int depthRight= minDepth0(root.right);
        return Math.min(depthLeft, depthRight);
    }

    public int minDepth0(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null || root.right == null){
            return 1;
        }
        
        int depthLeft = minDepth0(root.left);
        int depthRight= minDepth0(root.right);
        return Math.min(depthLeft, depthRight);
    }

    public List<List<Integer>> permute(int[] nums) {

        return null;

    }
    public void permute(int[] nums, List<List<Integer>> list, List<Integer> ans) {
        list.add(null);

        if(nums.length < 1){
            return;
        }
        if(nums.length == 1){
            ans.add(nums[0]);
        }
        for (int i = 0; i < nums.length; i++) {
            ans.add(nums[i]);
            permute(nums);

        }

    }

    public int binarySearch(int[] array, int targe, int low, int high){
        int left = low;
        int right = high;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(array[mid] == targe){
                return mid;
            }else if(array[mid] > targe){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -(left + 1);
    }
    public int[] get3Sum0(int[] array, int targe){
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int third = binarySearch(array, targe - array[i] - array[j], j , array.length - 1);
                if(third >= 0){
                    return new int[]{i, j , third};
                }
            }
        }
        return null;
    }
    public int[] get3Sum1(int[] array, int targe){
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1 ;
            int right = array.length - 1;
            while(left < right){
               int temp =  array[i] + array[left] + array[right];
               System.out.println("i="+i+"left="+left+"right="+right+"temp="+temp);
               if(targe == temp){
                    return new int[]{i, left, right};
               }else if(targe > temp){
                    left ++;
               }else {
                    right --;
               }
            }
        }
        return null;
    }

    public static void thread0(){
        System.out.println("won");
    }
    public static void main(String[] args) {
        long pre = System.currentTimeMillis();
        /*
        ListNode l1 = ListNode.parseArrays(new int[]{1,8,9});
        ListNode l2 = ListNode.parseArrays(new int[]{7,3,1});
        ListNode res = new Leecode().addTwoNumbers(l1, l2);
        res.print();
         */
        // ThreadPoolExecutor
        // LongAdder
        // System.out.println(new Leecode().climbStairs(3));
        // System.out.println(new Leecode().climbStairsMapOptimized(50));
        // TreeSet
        // Stack stack = new Stack<>();
        // BlockingQueue
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        // System.out.println(new Leecode().inorderTraversal(treeNode1));
        // System.out.println(new Leecode().binarySearch(new int[]{1,2,4,6,7,9,10}, 10));
        // System.out.println( Arrays.toString(new Leecode().get3Sum1(new int[]{8,7,11,1,2,4,6,7,9,0,10}, 40)));
        
        // ConcurrentHashMap
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                thread0();
            }
            
        });
        thread.run();
        System.out.println("win");

        long post = System.currentTimeMillis();
        System.out.println(post - pre);
    }
}

