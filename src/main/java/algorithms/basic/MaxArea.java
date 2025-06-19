package algorithms.basic;

//Container With Most Water
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int currentArea = 0;
        int left = 0, right = height.length -1;
        while (left < right){
            currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(currentArea, maxArea);
            if (height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;
    }
}
