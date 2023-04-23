
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

public class F{
    public static void main(String[] args) {
        // System.out.println(new F().reverse(123));
        System.out.println((2L << 30) -1);
    }

    public int reverse(int x) {
        
        boolean postive = true;
        if(x < 0){
            postive = false;
        }
        int remain = Math.abs(x);
        int reversed = 0;
        while(remain > 0){
            int point = remain%10;
            remain = remain/10;

            if(reversed > (((2 << 31) - point)/10 )){
                return 0;
            }
            reversed = reversed * 10 + point;
        }
        return postive? reversed : -1 * reversed;

    }
}