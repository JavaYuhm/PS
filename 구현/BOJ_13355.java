import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_13335 {
/*

구현 : Queue(다리)에 트럭을 넣으면서 구현함.
순서를 바꾸거나 다 지나가지 못하는 경우가 없으므로, 초기에 가장 처음 트럭을 넣고 다리 큐가 빌때까지 실행함.

Truck 클래스에는 무게와 t(위치파악용) 갖고 있음.
만약 위치가 다리길이보다 커지면 Poll 로 제거하고 현재 다리무게값도 빼줌.

출력
출력은 표준출력을 사용한다. 모든 트럭들이 다리를 건너는 최단시간을 출력하라.
 */
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
    // 처음엔 하나 올리고 시작
		int time = 1;
		st = new StringTokenizer(br.readLine());
		
    int [] truck = new int [N];
		for(int i=0;i<N;i++){
			truck[i] = Integer.parseInt(st.nextToken());
		}
    // 다리 큐에 트럭 넣음.
		Queue<Truck> bridge = new LinkedList<Truck>();
		bridge.add(new Truck(truck[0], 1));
		int sum = truck[0];
		int idx = 1;
		while(!bridge.isEmpty()){
			
			int size = bridge.size();
			// 큐에 들어있는 트럭들의 위치를 증가
			for(int i=0;i<size;i++){				
				Truck tmp = bridge.poll();
				tmp.t++;
				bridge.add(tmp);
			}
			// 젤 위에있는 위치 트럭이 다리길이보다 큰경우 큐에서 제거하고 무게 빼줌
			if(bridge.peek().t>W){
				Truck tmp = bridge.poll();
				sum-= tmp.weight;
			}
			
	    // 트럭을 올릴 수 있는지 체크
			if(idx<N && truck[idx]+sum <= L && bridge.size()<W){
				bridge.add(new Truck(truck[idx], 1));
				sum+=truck[idx];
				idx++;
			}
			
      // 시간 증가
			time++;
			
		}
		System.out.println(time);
	}
	
	public static class Truck {
		
		int weight;
		int t;
		
		public Truck(int w, int t) {
			this.weight = w;
			this.t = t;
		}
	}

}
