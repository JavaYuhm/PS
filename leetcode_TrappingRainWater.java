import java.util.Stack;

public class leetcode_TrappingRainWater {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result  = trap(height);
        System.out.println(result);
    }

    public static  int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans =0;
        int current = 0;

        while(current < height.length){

            while(!stack.empty() && height[current] > height[stack.peek()]){
                int top = stack.peek();
                stack.pop();
                if(stack.empty()){
                    break;
                }
                int dist = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()])- height[top];
                //System.out.println("bounded_height "+ bounded_height+ " dist "+ dist);
                ans += dist * bounded_height;
            }
            stack.push(current++);

        }

        return ans;

    }

}
