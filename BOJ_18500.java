import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_18500 {
/*
구현해야 될 것
 막대기 높이에 던짐. (방향)
 처음만나는 점 -> 빈칸으로 표기

클러스터 찾아서(바닥에 붙어있는) 체크 
-> 공중에 있으면 하강 (밑에 다른 클러스터를 만나거나, 바닥까지)

=> 초기는 공중 클러스터 찾는 로직을 복잡하게(더럽게) 구현을 했었음 : 
   for loop 를 돌면서 r,c 좌표 값이 'x' 이면서 visited 되지 않았으면 해당 부분에서 BFS 탐색하며 PQ에 값을 넣으면서
   PQ Peek가 r이 젤 높은 값이 되도록 설정해서 바닥이 아니면 바로 하강하게 구현을 해서, 실패함..
   => 클러스터를 찾는 부분과 하강을 분리해야 함.
   
소요시간 : 오후 14:00:04 ~ 16:19   

보다 더 간결하게 구현할 수 있도록 생각을 구조화해서 코드 

 */
	/**
	 * @param args
	 * @throws IOException 
	 */
	static int r, c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		char [][] map = new char [r][c];
		
		for(int i=0;i<r;i++){
			String line = br.readLine();	
			map[i] = line.toCharArray();
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int d = 2;
		
		for(int i=0;i<N;i++){
			// 막대기 던지기, 맞은 위치  . 빈칸 처리
			boolean check = throwBar(map, Integer.parseInt(st.nextToken()), d%2);
			d++;
			// 막대기 안맞은 경우 새롭게 던짐
			if(!check) continue;
			
      // 떨어뜨려야할 List(클러스터들) 찾음
			ArrayList<Point> downList = findCluster(map);
			
      // 하강
      down(map, downList);
		}
	
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static boolean throwBar (char [][] map, int height, int direct){
		// 1 -> r-1
		boolean p = false;
		if(direct==0){
			for(int i=0;i<c;i++){
				
				if(map[r-height][i]=='x'){
					map[r-height][i] = '.';
					p = true;
					return p;
				}
				
			}
		} else {
			for(int i=c-1;i>=0;i--){
				
				if(map[r-height][i]=='x'){
					map[r-height][i] = '.';
					p = true;
					return p;
				}
				
			}
		}
		return p;
				
	}
	
	public static  ArrayList<Point> findCluster(char [][] map){
		boolean visited[][] = new boolean [r+1][c+1];
		Queue<Point> que = new LinkedList<Point>();
		for(int i=0;i<c;i++){
			if(map[r-1][i]=='x'){
				que.add(new Point(r-1,i));
				visited[r-1][c] = true;
			}
		}
		int dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		while(!que.isEmpty()){
			Point tmp = que.poll();
			
			for(int d=0;d<4;d++){
				int nr = tmp.r + dir[d][0];
				int nc = tmp.c + dir[d][1];
				
				if(nr>=r || nc>=c || nr<0 || nc<0 || visited[nr][nc] || map[nr][nc]=='.')
				{
					continue;
				}
				visited[nr][nc]=true;
				que.add(new Point(nr,nc));
			}
			
		}
		ArrayList<Point> cls = new ArrayList<Point>();
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(map[i][j]=='x' && !visited[i][j]){
					cls.add(new Point(i,j));
				}
			}
		}
		return cls;
	}
	
	public static void down(char[][] map, ArrayList<Point> downList){
		
		for(Point tmp : downList){
			map[tmp.r][tmp.c] = '.';
		}
		int len = 0;
		OUTER : for(int i=0;i<r;++i){
			
			for(Point tmp : downList) {
				if(tmp.r+i>=r || map[tmp.r+i][tmp.c]=='x'){
					
					break OUTER;
				}
			}
			len = i;
		}
		for(Point tmp : downList){
			
			map[tmp.r+len][tmp.c] = 'x';
			
		}
	}
	
	private static class Point implements Comparable<Point> {
		
		int r;
		int c;
		
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}

		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return o.r - this.r;
		}
		
	}
}
