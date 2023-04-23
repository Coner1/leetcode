

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A {


    public static void main(String[] args) {
        // Readwritel
        ReadWriteLock lock = new ReentrantReadWriteLock();
        // AbstractQueuedSynchronizer
        // CountDownLatch
        int result = new A().locate(new int[]{1,-2,3,10,9,-6,9,8});
        System.out.println(result);
        // System.arraycopy(args, result, lock, result, result);
        int[] nums = new int[]{};
        List<List<Integer>> list = new A().threeSum(nums);
        System.out.println(list);

    }


    public int findGreatestSumOfSubArray(int[] array) {
        int x = array[0];
        int y = 0;
        int maxsum = x;
        for(int i = 1; i < array.length; i++){
            //状态转移：连续子数组和最大值
            y = Math.max(x + array[i], array[i]);
            //维护最大值
            maxsum = Math.max(maxsum, y); 
            //更新x的状态
            x = y; 
        }
        return maxsum;
    }


    

    private int locate(int[] array){
        int low = array[0];
        int high = low;
        int maxAdd = -100;
        for (int i = 1; i < array.length; i++) {
            high = Math.max(low + array[i], array[i]);
            maxAdd = Math.max(high, maxAdd);
            low = high;
        }
        return maxAdd;
    }


        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList();
            int target = 0;
            Arrays.sort(nums);
            for(int i = 0; i < nums.length - 2; i++){
                int left = i+1; 
                int right = nums.length - 1; 
                while(left < right){
                    int value = nums[i] + nums[left] + nums[right];
                    if(value == target){
                        List<Integer> interList = new ArrayList<Integer>();
                        interList.add(nums[i]);
                        interList.add(nums[left]);
                        interList.add(nums[right]);
                        // if(!checkExists(list, interList)){
                            list.add(interList);
                        // }
                        left ++;
                    }else if(value < target){
                        left ++;
                    }else {
                        right --;
                    }
                }
            }
            return list;
        }
        private boolean checkExists(List<List<Integer>> list, List<Integer> interList){
            if(list.size() < 1){
                return false;
            }
    
            for(int i = 0; i < list.size(); i++){
                if(checkExists0(list.get(list.size() - 1 - i), interList)){
                   return true; 
                }
            }
            return false;
        }
    
        private boolean checkExists0(List<Integer> listItem, List<Integer> interList){
            for(int i = 0; i < listItem.size(); i++){
                if(!Objects.equals(listItem.get(i), interList.get(i))){
                    return false;
                }
            }
            return true;
        }
    
    
}
