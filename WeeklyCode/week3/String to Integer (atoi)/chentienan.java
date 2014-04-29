public class Solution {
    private static int BOUND_DIVIDE_TEN_QUOTIENT = 214748364;
    private static char POSITIVE_BOUND_DIVIDE_TEN_REMAINDER = '7';
    private static char NEGATIVE_BOUND_DIVIDE_TEN_REMAINDER = '8';
    
    public int atoi(String str) {
        String realContent = removeWhiteSpaceFromTheHead(str);
        Boolean isPositive = true;
        int result = 0;
        for(int index = 0; index < realContent.toCharArray().length; index++)
        {
            char current = realContent.toCharArray()[index];
            if(index == 0){
                if(current == '+'){
                    continue;
                }else if(current == '-'){
                    isPositive = false;
                    continue;
                }
            }
            if(current >= '0' && current <= '9'){
                int reachBoundChecker = checkForBound(result, current, isPositive);
                if(reachBoundChecker == 1){
                    return Integer.MAX_VALUE;
                }else if(reachBoundChecker == -1){
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + (current - '0');
            }else{
                break;
            }
        }
        return isPositive ? result : result * (-1);
    }
    
    /**
     *@return
     *  if return value is 0, not reach the bound,
     *  if return value is 1, reach the positive bound,
     *  if return value is -1, reach the negative bound
     *
     * */
    private int checkForBound(int valueToMultiplyTen, char valueToPlus, boolean isPositive)
    {
        if(valueToPlus < '0' || valueToPlus > '9') return 0;
        if(valueToMultiplyTen > BOUND_DIVIDE_TEN_QUOTIENT){
            return isPositive ? 1 : -1;
        }else if(valueToMultiplyTen == BOUND_DIVIDE_TEN_QUOTIENT){
            if(valueToPlus >= NEGATIVE_BOUND_DIVIDE_TEN_REMAINDER){
                return isPositive ? 1 : -1;
            }else if(valueToPlus == POSITIVE_BOUND_DIVIDE_TEN_REMAINDER){
                return isPositive ? 1 : 0;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
    
    private String removeWhiteSpaceFromTheHead(String input)
    {
        int index = 0;
        char[] charArray = input.toCharArray();
        for(; index < charArray.length; index++)
        {
            
            //If not white space, then break
            if(charArray[index] != ' ')
            {
                break;
            }
        }
        return input.substring(index);
    }
}