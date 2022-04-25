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
	/*
	* TreeMap 사용이 더 나을 지도,, HashMap을 통해 Key , Value 쌍의 Map 인터페이스를 구현함. Hash를 통해 Get.Put 이 성능이 O(1)
	  하지만 answerMap 변수가 결국 정렬이 되어야 하므로 TreeMap 사용에 대해서 생각을 해봐야 함.
	*/
        HashMap<String, Integer> answerMap = new HashMap<String, Integer>();
        for(int i=0;i<friends.length;i++) {
        	String name1 = friends[i][0];
        	String name2 = friends[i][1];
        	
        	if(name1.equals(user_id)) {
        		flist.add(name2);
			// 친구, 원래 값을 엄청 작은 값을 줘서 친구는 정렬 시 체크 안되게 빼기위해 - 큰 값을 부여함.
        		answerMap.put(name2, -100000);
        	}
        	
        	if(name2.equals(user_id)) {
        		flist.add(name1);
        		answerMap.put(name1, -100000);
        	}
        	
        }
        
       
        // 친구의 친구를 찾으려고 함.
        for(String fname : flist) {
        	
        	for(int i=0;i<friends.length;i++) {
            	String name1 = friends[i][0];
            	String name2 = friends[i][1];
        		// 친구의 친구이면서 UserID 가 아닌 경우 map 에 이름과 값을 넣음 GetorDefault를 통해 해당하는 key가 있으면 value 값 아니면 0
        		if(fname.equals(name1) && !name2.equals(user_id)) {
        			answerMap.put(name2, answerMap.getOrDefault(name2, 0)+1);
        		}
        		if(fname.equals(name2) && !name1.equals(user_id)) {
        			answerMap.put(name1, answerMap.getOrDefault(name1, 0)+1);
        		}
        	}
        	
        }
        // Key의 List를 받음
        List<String> keySetList = new ArrayList<>(answerMap.keySet());
	// 내림차순으로 정렬
        Collections.sort(keySetList, (o1, o2) -> (answerMap.get(o2).compareTo(answerMap.get(o1))));
        ArrayList<String> answerList = new ArrayList<String>();
        int value = 0;
	    	// 가장 큰 값과 일치하는 키값들을 List에 저장함.
		for(String key : keySetList) {
			if(answerMap.get(key) >= value){
				answerList.add(key);
				value = answerMap.get(key);
			}
		}
		Collections.sort(answerList);
	    	// answer 값 정렬 오름차순
		String ans [] = (String[])answerList.toArray();
        return ans;
    }
}
