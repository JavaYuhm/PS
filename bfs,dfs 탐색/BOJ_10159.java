import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_10159 {
/*
 * 저울
문제
무게가 서로 다른 N 개의 물건이 있다. 
각 물건은 1부터 N 까지 번호가 매겨져 있다. 
우리는 일부 물건 쌍에 대해서 양팔 저울로 어떤 것이 무거운 것인지를 측정한 결과표를 가지고 있다. 
이 결과표로부터 직접 측정하지 않은 물건 쌍의 비교 결과를 알아낼 수도 있고 알아내지 못할 수도 있다. 예
를 들어, 총 6개의 물건이 있고, 다음 5개의 비교 결과가 주어졌다고 가정하자. ([1]은 1번 물건의 무게를 의미한다.)

[1]>[2], [2]>[3], [3]>[4], [5]>[4], [6]>[5]

우리는 [2]>[3], [3]>[4]로부터 [2]>[4]라는 것을 알 수 있다. 하지만, 물건 2와 물건 6을 비교하는 경우, 앞서의 결과만으로는 어느 것이 무거운지 알 수 없다. 이와 같이, 물건 2는 물건 1, 3, 4와의 비교 결과는 알 수 있지만, 물건 5, 6과의 비교 결과는 알 수 없다. 
물건 4는 모든 다른 물건과의 비교 결과를 알 수 있다. 

비교 결과가 모순되는 입력은 없다고 가정한다. 
위 예제의 기존 측정 결과에 [3]>[1]이 추가되었다고 가정하자. 이 경우 [1]>[2], [2]>[3]이므로 우리는 [1]>[3]이라는 것을 예측할 수 있는데, 이는 기존에 측정된 결과 [3]>[1]과 서로 모순이므로 이러한 입력은 가능하지 않다. 

물건의 개수 N 과 일부 물건 쌍의 비교 결과가 주어졌을 때, 각 물건에 대해서 그 물건과의 비교 결과를 알 수 없는 물건의 개수를 출력하는 프로그램을 작성하시오. 

[1]>[2], [2]>[3], [3]>[4], [5]>[4], [6]>[5]
5 1 
1 > 2 > 3 > 4 
<- 5 <- 1 

소요 시간 : 오후 12:34:30 ~ 13:09:43
그래프 탐색 - 단방향 인접리스트 2개(큰쪽으로 가는 것, 작은쪽으로 가는 것) 생성하여 각각 BFS 를 진행하여, 몇번 돌았는 지 Cnt 해서 알 수 없는 물건 개수 카운팅
추가사항 - 플로이드 와샬로도 풀 수 있음 -> 플로이드 와샬에 대해서 공부하고 적용해볼 것
 */
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<ArrayList<Integer>> BigadjList = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> smalladjList = new ArrayList<ArrayList<Integer>>();

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=N;i++){
			BigadjList.add(new ArrayList<Integer>());
			smalladjList.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int big = Integer.parseInt(st.nextToken());
			int small = Integer.parseInt(st.nextToken());
			
			BigadjList.get(big).add(small);
			smalladjList.get(small).add(big);
		}
		
		for(int i=1;i<=N;i++){
			int sum = 0;
			sum+=bfs(BigadjList, i);
			sum+=bfs(smalladjList, i);
			System.out.println(N-sum-1);
		}
	}
	public static int bfs(ArrayList<ArrayList<Integer>> adjList, int start){
		
		Queue<Integer> que = new LinkedList<Integer>();
		boolean check[] = new boolean[N+1]; 
		que.add(start);
		check[start] = true;
		int cnt = 0;
		while(!que.isEmpty()){
			
			int cur = que.poll();
			ArrayList<Integer> tmp = adjList.get(cur);
			for(int idx : tmp){
				if(!check[idx]){
					check[idx] = true;
					que.add(idx);
					cnt++;
				}
				
			}
		}
		return cnt;
		
	}
}
