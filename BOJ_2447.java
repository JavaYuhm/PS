import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*

분할 정복 - 재귀
: 규칙성이 있음(찾음), 문제를 나눌 수 없을 때까지 나누어서 각각을 풀면서 다시 합병하여 문제의 답을 얻는 알고리즘이
=> 별 찍기
가장 기초적인 모양
***
* *
***
(1,1)인 경우는 가운데 빈 공간이 됨.

이를 더 크게 확장해서 봐도 동일함.

 */

public class BOJ_2447 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static char [][] star;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		star = new char [N][N];
		for(int i=0;i<N;i++){
			Arrays.fill(star[i], ' ');
		}
		printStart(N,0,0);
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++){
			sb.append(star[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void printStart(int n, int x, int y){
		
		if(n==1){
			star[x][y] = '*';
			return ;
		}
    // n 을 3으로 나눠서 분할		
		int div = n/3;
		
    // 3x3 가장 기초 규칙 형태
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
        // 1,1 인 경우는 공백
				if(i==1 && j==1) continue;
        // 더 들어감, div*i(0~2) 좌표 이동  
				printStart(div, x+(div*i), y+(div*j));
			}
		}
		
	}

}
