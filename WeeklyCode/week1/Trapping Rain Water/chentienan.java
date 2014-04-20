public class Solution {
    public int trap(int[] A) {
        if(A.length < 3) return 0;
        int firstTurningPoint = -1, secondTurnningPoint = -1, result = 0;
        for(int i = 1; i < A.length - 1 ; i++)
        {
            if(firstTurningPoint != -1 && secondTurnningPoint != -1)
            {
                result += calculateTheTrapBetweenTwoTurnningPoint(firstTurningPoint, secondTurnningPoint);
                firstTurningPoint = -1;
                secondTurnningPoint = -1;
            }
            else 
            {
                if(isTurnningPoint(i, A))
                {
                    if(firstTurningPoint == -1) firstTurningPoint = i;
                    else   //The secondTurnningPoint is -1
                    {
                        
                        secondTurnningPoint = i;
                    }
                }
            }
        }
        return result;
    }
    
    private int calculateTheTrapBetweenTwoTurnningPoint(int firstTurningPoint, int secondTurnningPoint, int[] A)
    {
        //TODO: fulfill this function
        return -1;
    }
    
    private boolean isTurnningPoint(int index, int[] A)
    {
        if(index == 0)
        {
            return A[0] > A[1];
        }
        else if(index == A.length -1)
        {
            return A[A.length -1] > A[A.length -2]
        }
        else{
            return A[i] >= A[i - 1] && A[i] >= A[i + 1];
        }
    }
}