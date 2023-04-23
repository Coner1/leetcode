package algorithms;

public class A {

    public static void main(String[] args) {
        System.out.println(new A().addNums(138));
        
    }
    public int addNums(int num){
        while(true){
            int sum = addNums0(num);
            if(sum < 9){
                return sum;
            }
            num = sum;
        }
    }
    public int addNums0(int num) {
        if(num < 0){
            return -1;
        }
        if(num < 10){
            return num;
        }
        int sum = 0;
        while(num > 0){
            int n1 = num % 10;
            num = num / 10;
            sum = sum + n1;
        }
        return sum;
    }
    
}
