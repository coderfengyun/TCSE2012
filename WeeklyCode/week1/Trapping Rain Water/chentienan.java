public class Solution {
    public int trap(int[] A) {
        if(A.length < 3) return 0;
        return trap(A, 0 , A.length - 1);
    }
    
    private int trap(int[] A, int begin, int end)
    {
        if(end - begin < 2) return 0;
        int maxValueIndex = A[begin] > A[begin + 1] ? begin : begin + 1, secondMaxValueIndex = A[begin] > A[begin + 1] ? begin + 1 : begin;
        for(int i = begin + 2; i <= end; i++)
        {
            if(A[i] > A[maxValueIndex]) 
            {
                secondMaxValueIndex = maxValueIndex;
                maxValueIndex = i;
            }
            else if(A[i] > A[secondMaxValueIndex])
            {
                secondMaxValueIndex = i;
            }
        }
        int minorOne = maxValueIndex > secondMaxValueIndex ? secondMaxValueIndex : maxValueIndex;
        int largerOne = maxValueIndex > secondMaxValueIndex ? maxValueIndex : secondMaxValueIndex;
        return calculateTheTrapBetweenTwoTurnningPoint(minorOne, largerOne, A) + trap(A, begin, minorOne) + trap(A, largerOne, end);
    }
    
    private int calculateTheTrapBetweenTwoTurnningPoint(int firstTurnningPoint, int secondTurnningPoint, int[] A)
    {
        if(secondTurnningPoint - firstTurnningPoint < 2) return 0;
        int min = getMin(A[firstTurnningPoint], A[secondTurnningPoint]);
        int result = (secondTurnningPoint - firstTurnningPoint -1) * min;
        for(int i = firstTurnningPoint + 1; i < secondTurnningPoint; i++)
        {
            result -= A[i];
        }
        return result;
    }
    
    private int getMin(int first, int second)
    {
        return first >= second ? second : first;
    }
}