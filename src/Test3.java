import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        List<String> answer = new ArrayList<>();
        String str = "121";
        for (int i = 0; i < str.length(); i++) {
            int l = i;
            int r = i;
            //奇数情况
            while(l >= 0 && r <= str.length() - 1){
                l--;
                r++;
                System.out.println("i="+i+",l="+l+",r="+r);
                if(l < 0 || r > str.length() -1 || str.charAt(l) != str.charAt(r)){
                    answer.add(str.substring(l + 1, r));
                    break;
                }

            }
            //偶数情况
            /*
            l = i-1;
            r = i;
            while(l > -1 && r < str.length){

                l--;
                r++;
            }
            */
        }

        System.out.println(answer);
    }
}
