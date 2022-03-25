import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
// 소요시간 16분
// BFS - 배추들의 좌표를 map 에 저장한 다음, bfs로 탐색을 몇번했는 지 cnt에 저장하여 출력 * bfs 탐색한 횟수가 곧 나눠져있는 배추들 집합이므로
public class BOJ_1012 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int map[][] = new int [N][M];
			int K = Integer.parseInt(st.nextToken());
			for(int i=0;i<K;i++){
				
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			}
			int cnt = 0;
			for(int i=0;i<M;i++){
				
				for(int j=0;j<N;j++){
					if(map[j][i]==1) {
						bfs(map,i,j);
						cnt++;
					}
				}
				
			}
			System.out.println(cnt);
		}	
	}
	
	private static void bfs(int map[][], int x, int y){
		
		Point start = new Point(x,y);
		
		Queue<Point> que = new LinkedList<Point>();
		que.add(start);
		
		while(!que.isEmpty()){
			
			Point tmp = que.poll();
			int tx = tmp.x;
			int ty = tmp.y;
			for(int i=0;i<4;i++){
				
				int nx = tx+dx[i];
				int ny = ty+dy[i];
				
				if(nx<0 || ny<0||nx>=map[0].length || ny>=map.length) continue;
				else if(map[ny][nx] == 1){
					
					map[ny][nx] = 2;
					que.add(new Point(nx,ny));
				}
			}
			
		}
	}
	
	private static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
