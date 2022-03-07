import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 약수 구하기 : n의 약수 중 k번 째 약수 구하기
// 내 풀이 -> n k 를 받고 반복문을 돌려 약수를 구해 ArrayList에 넣고 get(k-1) 또는 k번째가 없는 경우 0
// 더 나은 풀이 -> 1~k번째까지 약수를 구하면 바로 해당 결과 값을 return 
public class BOJ_2501 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer = findFactor(n, k);
		System.out.println(answer);
	}
	private static int findFactor(int n,int k){
		
		ArrayList<Integer> saveFactors = new ArrayList<Integer>();
		
		for(int i=1;i<=n;i++){
			
			if(n%i==0) saveFactors.add(i);
			
		}
		
		Collections.sort(saveFactors);
		if(k>saveFactors.size()) return 0;
		return saveFactors.get(k-1);
	}

}
