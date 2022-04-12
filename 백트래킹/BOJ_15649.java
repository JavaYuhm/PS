import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N과 M (1)

문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

3 1
백트래킹 - 순열 구현문제 ( 이미 방문한 건 또 방문하지 않음)
출력을 System.out 이 아닌 StringBulider나 BufferedWriter 등을 이용하는 게 시간이 더 적게 걸림.

 *
 */
public class BOJ_15649 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] arr = new int [N];
		int [] output = new int [N];
		boolean [] visited = new boolean[N];
		for(int i=0;i<N;i++){
			arr[i] = i+1;
		}
		
    // arr에 1~N까지의 자연수
    // output에 arr 값을 담음. 
    // N개의 숫자중에 M개를 뽑는 순열로 생각
		permutation(arr, output, visited, 0, N, M);
		// 1 2 3
		// 1 2 	1 3 / 2 1	2 3  /  3 1  3 2  
		
	}
	public static void permutation(int [] arr, int [] output, boolean [] visited, int depth , int N, int M){
		// M개를 고른 경우, 재귀 종료
		if(depth==M){
			print(output, M);
			return ;
		}
		
    // 배열에 담긴 값 0 ~ N
		for(int i=0;i<N;i++){
      // 이미 방문한 index가 아닌 경우.
			if(!visited[i]){
				visited[i] = true;
        // 현재 depth에 i값을 넣음.
				output[depth] = arr[i];
        // depth 증가 후 재귀호출
				permutation(arr, output, visited, depth+1, N, M);
        // 방문이 끝나고 나면 다시 false로 초기화
				visited[i] = false;
				
			}
			
		}
		
	}
	public static void print(int [] arr, int r){
		for(int i=0;i<r;i++){
			System.out.print((arr[i])+ " ");
		}
		System.out.println();
	}
}
