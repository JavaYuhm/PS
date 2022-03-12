package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SK_algo1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int money = 4578;
		//int costs[] = {1,4,99,35,50,1000};'
		int money = 1999;
		int costs[] = {2,11,20,100,200,600};
		int answer = solution(money, costs);
		System.out.println(answer);
	}
	
    public static int solution(int money, int[] costs) {
        int answer = 0;
        
        double moneys[] = {1,5,10,50,100,500};
        
        int idx = 0;
        ArrayList<Coin> coins = new ArrayList<>();
        for(int i=0;i<6;i++) {
        	
        	
        	coins.add(new Coin(moneys[i],costs[i], (double)costs[i]/moneys[i]));
        	
        }
        
        Collections.sort(coins);
        
        for(int i=0;i<6;i++) {
        	
        	if(money==0) return answer;
        	
        	Coin c = coins.get(i);
        	int cnt = (int) (money/c.money);
        	answer += (cnt*c.cost);
        	money = (int) (money - (c.money*cnt));
        }
                
        return answer;
    }
    public static class Coin implements Comparable<Coin>{
    	double money;
    	int cost;
    	double makeCost;
    	Coin(double money, int cost,double makeCost){
    		this.money = money;
    		this.cost  = cost;
    		this.makeCost = makeCost;
    	}
		@Override
		public int compareTo(Coin o) {
			// TODO Auto-generated method stub
			return (this.makeCost>o.makeCost ? 1 : -1);
		}
    }
}
