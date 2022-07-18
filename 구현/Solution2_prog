import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution2_prog {
    public static void main(String[] args) {
    String [] want = {"banana", "apple", "rice", "pork", "pot"};
    int [] number = {3,2,2,2,1};
    String [] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
       int ans= solution(want, number, discount);
        System.out.println(ans);
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        int cnt= 0;
        for(int i=0;i<=discount.length-10;i++){
            HashMap<String, Integer> map = new HashMap<>();
            for(int m=0; m<want.length;m++){
                map.put(want[m], number[m]);
            }
            int flag = 0;
            for(int j=i;j<i+10;j++){
                System.out.println("discount "+i+": "+ discount[j]);
                if(map.containsKey(discount[j])){
                    int value = map.get(discount[j]);
                    if(value>0){
                        map.put(discount[j], value-1);
                    } else {
                        flag = 1;
                        break;
                    }
                } else {
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("i 날 "+i);
                cnt++;
            }
        }
        return cnt;

    }
}
