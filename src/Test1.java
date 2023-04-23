import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Test1 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Test1().permute(new int[]{1, 2});
//        S
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        permute0(nums, 0, list, null);
        return list;
    }
    public void permute0(int[] nums, int curIndex, List<List<Integer>> list, List<Integer>  list1) {

        if(curIndex > nums.length - 1){
            return;
        }
        if(curIndex == 0){
            list1 = new ArrayList();
        }

        for(int i = curIndex; i < nums.length; i++){
            System.out.println("curIndex="+curIndex+",i="+i);
            swap(nums, curIndex, i);
             list1.add(nums[curIndex]);
            permute0(nums, curIndex + 1, list, list1);
            swap(nums, curIndex, i);

//            System.out.println();
        }

    }
    public void swap(int[] nums, int i, int j) {
        System.out.println("swap i="+i+",j="+j);
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
