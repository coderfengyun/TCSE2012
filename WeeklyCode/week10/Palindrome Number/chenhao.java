public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int original=x;
        int reverse=0;
        while(x>0){
            reverse=reverse*10+x%10;
            x/=10;
        }
        return reverse==original;
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int b=1;
        while(b<=x/10){
            b*=10;
        }
        while(x>0){
            int first=x/b;
            int last=x%10;
            if(first!=last){
                return false;
            }
            x=(x-(first*b))/10;
            b/=100;
        }
        return true;
    }
}