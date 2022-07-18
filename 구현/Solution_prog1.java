import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

public class Solution_prog1 {
    public static void main(String[] args) {
        String X = "12345";
        String Y = "2345";
        String answer = "";
        ArrayList<Integer> arr =new ArrayList<>();

        if(X.length()>Y.length()){

            for(int i=0;i<Y.length();i++) {
                for (int j = 0; j < Y.length(); j++) {
                    if (X.charAt(i) == Y.charAt(j)) {
                        char equlsChar = X.charAt(i);
                        int xlen = X.length();
                        int ylen = Y.length();
                        X = X.replaceAll(X.charAt(i) + "", "");
                        Y = Y.replaceAll(Y.charAt(j) + "", "");
                        int xcnt = xlen - X.length();
                        int ycnt = ylen - Y.length();

                        if (xcnt > ycnt) {
                            for (int k = 0; k < ycnt; k++) {
                                arr.add(equlsChar - '0');
                            }
                        } else {
                            for (int k = 0; k < xcnt; k++) {
                                arr.add(equlsChar - '0');
                            }
                        }
                        i--;
                        break;
                    }
                }
            }

        }
        else {
            for(int i=0;i<X.length();i++){

                for(int j=0;j<Y.length();j++){
                    if(X.charAt(i)==Y.charAt(j)){
                        char equlsChar = X.charAt(i);
                        int xlen = X.length();
                        int ylen = Y.length();
                        X= X.replaceAll(X.charAt(i)+"", "");
                        Y= Y.replaceAll(Y.charAt(j)+"", "");
                        int xcnt = xlen-X.length();
                        int ycnt = ylen-Y.length();

                        if(xcnt>ycnt){
                            for(int k=0;k<ycnt;k++){
                                arr.add(equlsChar-'0');
                            }
                        }else{
                            for(int k=0;k<xcnt;k++){
                                arr.add(equlsChar-'0');
                            }
                        }
                        i--;
                        break;
                    }
                }
            }
        }
        Collections.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
