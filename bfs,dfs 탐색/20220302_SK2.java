package Algo;

import java.util.LinkedList;
import java.util.Queue;

public class SK_algo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		boolean clockwise = false;

		solution(n, clockwise);
	}

	public static int[][] solution(int n, boolean clockwise) {
		int[][] answer = {};

		answer = new int[n][n];
		boolean check[][] = new boolean[n][n];
		Point start1 = new Point(0, 0, 0);
		Point start2 = new Point(n - 1, 0, 1);
		Point start3 = new Point(0, n - 1, 2);
		Point start4 = new Point(n - 1, n - 1, 3);

		Queue<Point> que = new LinkedList<>();
		que.add(start1);
		que.add(start2);
		que.add(start3);
		que.add(start4);

		if (clockwise) {

			int dx[] = { 1, 0, 0, -1 };
			int dy[] = { 0, 1, -1, 0 };
			int times = 1;
			while (!que.isEmpty()) {

				int qsize = que.size();

				for (int i = 0; i < qsize; i++) {

					Point now = que.poll();
					answer[now.y][now.x] = times;
					check[now.y][now.x] = true;
					
					for(int d=0;d<4;d++) {
						int dir = (now.d + d)%4;
						int nx = now.x + dx[dir];
						int ny = now.y + dy[dir];
						
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[ny][nx])
							continue;
						else {
							check[ny][nx] = true;
							que.add(new Point(nx, ny, dir));
							break;
						}
					}
				}
				for(int i=0;i<n;i++) 
				{ for(int j=0;j<n;j++) {
					  System.out.print(answer[i][j]+" "); } 
				System.out.println(); 
				}
				System.out.println();
				times++;
			}

		} else {
			int dx[] = { 0, -1, 1, 0 };
			int dy[] = { 1, 0, 0, -1 };

			int times = 1;
			while (!que.isEmpty()) {

				int qsize = que.size();

				for (int i = 0; i < qsize; i++) {

					Point now = que.poll();
					answer[now.y][now.x] = times;
					check[now.y][now.x] = true;
					
					for(int d=0;d<4;d++) {
						int dir = (now.d + d)%4;
						int nx = now.x + dx[dir];
						int ny = now.y + dy[dir];
						
						if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[ny][nx])
							continue;
						else {
							check[ny][nx] = true;
							que.add(new Point(nx, ny, dir));
							break;
						}
					}
				}
				
				for(int i=0;i<n;i++) 
				{ for(int j=0;j<n;j++) {
					  System.out.print(answer[i][j]+" "); } 
				System.out.println(); 
				}
				System.out.println();
				 
				times++;
			}
		}
		
		
		 
		return answer;
	}

	private static class Point {

		int x;
		int y;
		int d;

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
