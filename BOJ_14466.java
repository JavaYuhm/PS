import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;

public class BOJ_14466 {
/*
길을 건너지 않으면 만날 수 없다 == 길을 지나지 않고 만나는 소를 구함.  그 이외의 소들은 길을 건너지 않으면 만날 수 없는 소들임(못만나는 경우가 없으므로)
dfs, bfs 를 통해서 소의 위치 visited를 구함. 

방문되지 못한 소는 길을 건너야 만날 수 있는 cnt ++

출력
길을 건너지 않으면 만날 수 없는 소가 몇 쌍인지 출력한다.
 */
	/**
	 * @param args
	 * @throws IOException 
	 */
  
  // r,c r',c' 의 형태로 길이 입력되고 이것에 대한 인접리스트를 구현 = 2차원 배열로 ArrayList 선언.
	static ArrayList<Point>[][] adjList = null;
	static Point[] cows;
	static boolean [][] visited;
	static int N;
	static int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				adjList[i][j] = new ArrayList<Point>();
			}
		}
		cows = new Point[K];
		for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int rr = Integer.parseInt(st.nextToken()) - 1;
            int cc = Integer.parseInt(st.nextToken()) - 1;
      
            // r, c -> rr,cc 로 , rr,cc -> r,c 가는 경로를 저장함.
            adjList[r][c].add(new Point(rr,cc));
		      	adjList[rr][cc].add(new Point(r,c));

        }
		
		for(int i=0;i<K;i++){
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1; 
			cows[i] = new Point(r,c);
		}
		int ans = 0; 
		
		for(int i=0;i<K;i++){
			
			visited = new boolean[N][N];
			// 현재 소의 위치에서 dfs 실행해서 길을 건너지 않고 갈 수 있는 곳 체크함.
			dfs(cows[i].x, cows[i].y);
      // 소의 위치가 방문되었는 지 확인함.
      // 쌍이므로 i부터 ~ N 까지 for 실행
			for(int j=i;j<K;j++){
				Point tmp = cows[j];
				
				if(!visited[tmp.x][tmp.y]) ans++;
			}
		}
		System.out.println(ans);
		
	}
 	
    
	public static void dfs(int x, int y){
		
		visited[x][y] = true;
		for(int d=0;d<4;d++){
			
			int nx = x+dir[d][0];
			int ny = y+dir[d][1];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] ) {
				continue;
			}
			// 길을 통해서 지나는 경우인지 확인함
      // Point를 java.awt.Point 가 아닌 inner 클래스로 Point 만들 경우, contains로 못찾아냄.
			if(adjList[x][y].contains(new Point(nx,ny))){
				continue;
			}
			
			dfs(nx,ny);
			
		}
		
	}

}
