package Algo;

import java.util.*;

public class algo1 {
	
	// 친구 중에서 가장 많이 연결되어있는 친구 리스트를 찾음.
  // Map
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] friends = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
		String user_id = "david";
		algo1 ssg = new SSGalgo1();
		ssg.solution(friends, user_id);
	}
	
    public String[] solution(String[][] friends, String user_id) {

        ArrayList<String> flist = new ArrayList<String>();
        HashMap<String, Integer> answerMap = new HashMap<String, Integer>();
        for(int i=0;i<friends.length;i++) {
        	String name1 = friends[i][0];
        	String name2 = friends[i][1];
        	
        	if(name1.equals(user_id)) {
        		flist.add(name2);
        		answerMap.put(name2, -100000);
        	}
        	
        	if(name2.equals(user_id)) {
        		flist.add(name1);
        		answerMap.put(name1, -100000);
        	}
        	
        }
        
       
        
        for(String fname : flist) {
        	
        	for(int i=0;i<friends.length;i++) {
            	String name1 = friends[i][0];
            	String name2 = friends[i][1];
        		
        		if(fname.equals(name1) && !name2.equals(user_id)) {
        			answerMap.put(name2, answerMap.getOrDefault(name2, 0)+1);
        		}
        		if(fname.equals(name2) && !name1.equals(user_id)) {
        			answerMap.put(name1, answerMap.getOrDefault(name1, 0)+1);
        		}
        	}
        	
        }
        
        List<String> keySetList = new ArrayList<>(answerMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (answerMap.get(o2).compareTo(answerMap.get(o1))));
        ArrayList<String> answerList = new ArrayList<String>();
        int value = 0;
		for(String key : keySetList) {
			if(answerMap.get(key) >= value){
				answerList.add(key);
				value = answerMap.get(key);
			}
		}
		Collections.sort(answerList);
		String ans [] = (String[])answerList.toArray();
        return ans;
    }
}
