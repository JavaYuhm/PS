import java.util.*;
class Solution {
    // Leetcode https://leetcode.com/contest/weekly-contest-294/problems/minimum-lines-to-represent-a-line-chart/
    // adjacent points(Lines 의 수 구하는 문제)
    // 풀이과정 1. y축 증가량 / x축 증가량으로 기울기를 구해서 변경이 생기면 lines 증가
    // double 형으로 나누기를 했으나 소숫점 9자리이상으로 작아지면 작은 변화는 동일한 기울기로 판단하는 현상이 있었음.
    // -> 곱셈 형태로 값을 구해서, 비교하니 테스트 케이스 통과됨.
    public int minimumLines(int[][] stockPrices) {
        
        ArrayList<Point> arr = new ArrayList<>();
        
        for(int i=0;i<stockPrices.length;i++){
            arr.add(new Point(stockPrices[i][0],stockPrices[i][1]));
        }
        
        Collections.sort(arr);
        
        int lines = 1;
        if(arr.size()==1) return 0;
        if(arr.size()==2) return 1;
        for(int i=0;i<arr.size()-2;i++){
            
            Point first = arr.get(i);
            Point second = arr.get(i+1);
            Point third = arr.get(i+2);
            
            // 세 점을 이용해, 첫번째 점과 두번째 점 사이의 기울기 = 두번째 점과 세번 째 점 사이의 기울기 같은 지 확인.
            int calc1 = (third.x-second.x) * (second.y-first.y);
            int calc2 = (second.x-first.x) * (third.y-second.y);
            
            System.out.println(calc1);
            System.out.println(calc2);
            if(calc1!=calc2){
                lines++;
            }

        }
        
        return lines;
            
    }
    public static class Point implements Comparable<Point> {
        
        int x;
        int y;
        
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Point o){
            return (int) this.x - (int) o.x;
        }
    }
}
