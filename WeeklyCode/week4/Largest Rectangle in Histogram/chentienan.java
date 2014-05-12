public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        if(height.length == 1){
            return height[0];
        }
        return largestRectangleArea(height, 0, height.length - 1);
    }
    
    private int largestRectangleArea(int[] source, int begin, int end){
        if(begin == end){
            return source[begin];
        }
        int minIndex = findMinHeightIndex(source, begin, end);
        int areaIncludeMin = source[minIndex] * source.length;
        int leftLargetRectangleArea = largestRectangleArea(source, begin, minIndex - 1 < begin ? begin : minIndex - 1);
        int rightLargetRectangleArea = largestRectangleArea(source, minIndex + 1 > end ? end : minIndex + 1, end);
        return getMax(areaIncludeMin, leftLargetRectangleArea, rightLargetRectangleArea);
    }
    
    private int getMax(int first, int second, int third){
        if(first > second){
            return first > third ? first : third;
        }else{
            return second > third ? second : third;
        }
    }
    
    private int findMinHeightIndex(int[] sourceArray, int begin, int end){
        int minIndex = begin;
        for(int i = begin; i < end; i++){
            if(sourceArray[minIndex] > sourceArray[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}