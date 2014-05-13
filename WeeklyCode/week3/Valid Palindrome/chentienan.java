public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }
        char[] charArray = s.toCharArray();
        int leftBound = 0, rightBound = charArray.length - 1;
        while(leftBound < rightBound){
            if(!isLetter(charArray[leftBound])){
                leftBound++;
                continue;
            }
            if(!isLetter(charArray[rightBound])){
                rightBound--;
                continue;
            }
            if(!isSame(charArray[leftBound], charArray[rightBound])){
                return false;
            }
            leftBound++;
            rightBound--;
        }
        return true;
      }
      
      private boolean isLetter(char input){
          return (input >= 'a' && input <= 'z') || (input >= 'A' && input <='Z') || (input >= '0' && input <= '9');
      }
      
      private boolean isSame(char value1, char value2){
          return Character.toLowerCase(value1) == Character.toLowerCase(value2);
      }
}