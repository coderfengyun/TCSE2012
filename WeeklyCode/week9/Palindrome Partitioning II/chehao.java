public class Solution {
    
    String s;
    int[][] palindrome;
    
    boolean isPalindrome(int from,int to){
        if(palindrome[from][to]!=0){
            return palindrome[from][to]>0;
        }
        if(from>=to){
            palindrome[from][to]=1;
            return true;
        }
        else{
            boolean p=s.charAt(from)==s.charAt(to) && isPalindrome(from+1,to-1);
            palindrome[from][to]=p?1:-1;
            return p;
        }
    }
    
    public int minCut(String s) {
        int n=s.length();
        this.s=s;
        palindrome=new int[n][n];
        int[] minCut=new int[n+1];
   
        for(int i=1;i<=n;i++){
            minCut[i]=i;
            for(int j=0;j<i;j++){
                if(isPalindrome(j,i-1)){
                    minCut[i]=Math.min(minCut[i],minCut[j]+1);
                }
            }
        }
        return minCut[n]-1;
    }
}