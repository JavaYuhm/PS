import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분해합
// N - (N+자릿수들의 합)
// 특정 N을 만드는 분해합은 N보다 큰 경우는 없음. 따라서 1~N까지 분해합을 구하면서 N이랑 똑같은 값이 나오면 답을 출력
public class BOJ_2231 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i=1;i<=N;i++){
			
			if(divSum(i)==N){
				ans = i;
				break;
			}
			
			
		}
		System.out.println(ans);
		
	}
	public static int divSum(int n){
		int res = n;
		while(n>0){
			
			int value = n%10;
			res+=value;
			n= n/10;
			
		}
		return res;
		
	}

}
