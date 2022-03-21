import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N개의 스위치와 N개의 전구가 있다. 
 * 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다. i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다.
 *  즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다. 1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.

	N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때, 그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 자연수 N(2 ≤ N ≤ 100,000)이 주어진다. 
	다음 줄에는 전구들의 현재 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 
	그 다음 줄에는 우리가 만들고자 하는 전구들의 상태를 나타내는 숫자 N개가 공백 없이 주어진다. 0은 켜져 있는 상태, 1은 꺼져 있는 상태를 의미한다.

	출력
	첫째 줄에 답을 출력한다. 불가능한 경우에는 -1을 출력한다.
	
	
	
 */
public class BOJ_2138 {

	/**
	 * @param args
	 * 소요시간 : 2시 53분 ~ 5시 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */ 
	
  
  // Greedy 문제
  // 재귀 호출로 풀 경우, 시간초과
  // 해당 위치를 여러 번 누른 것이 의미가 없음. 
  // 시작부터 누르는 경우와 안누르는 경우로 나누고, 이전 위치의 전구 상태랑 비교해서 이전 위치 상태가 다른 경우 현재위치의 전구 스위치를 누름. 
	static int ans = Integer.MAX_VALUE;
	static char [] origin;
	static char [] comp1;
	static char [] comp2;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	    char [] tmp = br.readLine().toCharArray();
		comp1 = new char[N];
		comp2 = new char[N];
		origin = new char[N];
		for(int i=0;i<N;i++){
			
			comp1[i] = tmp[i];
			comp2[i] = tmp[i];
			
		}
		tmp = br.readLine().toCharArray();
		for(int i=0;i<N;i++){
			
			origin[i] = tmp[i];
			
		}
		
		push(comp1, 0);
		int cnt1=1;
    int cnt2=0;
		
		for(int i=1;i<N;i++){
			
			if(comp1[i-1]!=origin[i-1]){
				push(comp1, i);
				cnt1++;
			}
			
			if(comp2[i-1]!=origin[i-1]){
				push(comp2, i);
				cnt2++;
			}
		}
		
		check(cnt1, cnt2);
		
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
	public static void check(int cnt1, int cnt2){
		boolean compB1 = true;
		boolean compB2 = true;
		for(int i=0;i<N;i++){
			
			if(comp1[i]!=origin[i]){
				compB1 = false;
			} 
			if(comp2[i]!=origin[i]){
				compB2 = false;
			}
			
		}
		
		if(compB1){
			ans = cnt1;
		}
		
		if(compB2){
			ans = Math.min(ans, cnt2);
		}
		
	}
	public static void push(char[] c, int idx){
		
		
		for(int i=idx-1;i<=idx+1;i++){
			if(i>=0 && i<c.length){
				c[i] = c[i] == '0' ? '1' : '0';
			}
		}
		
		
	}


}
