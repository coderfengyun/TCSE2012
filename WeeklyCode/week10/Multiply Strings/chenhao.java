public class Solution {
    public String multiply(String num1, String num2) {
        int s1=0,s2=0;
        while(s1<num1.length() && num1.charAt(s1)=='0'){
            s1++;
        }
        while(s2<num2.length() && num2.charAt(s2)=='0'){
            s2++;
        }
        if(s1==num1.length() || s2==num2.length()){
            return "0";
        }
        char[] res=new char[num1.length()-s1+num2.length()-s2];
        for(int i=num1.length()-1;i>=s1;i--){
            for(int j=num2.length()-1;j>=s2;j--){
                int t=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int index=i+j+1;
                res[index]+=t;
                res[index-1]+=res[index]/10;
                res[index]%=10;
            }
        }
        for(int i=0;i<res.length;i++){
        	res[i]+='0';
        }
        String str=String.valueOf(res);
        if(str.startsWith("0")){
            return str.substring(1);
        }
        else{
            return str;
        }
    }
}