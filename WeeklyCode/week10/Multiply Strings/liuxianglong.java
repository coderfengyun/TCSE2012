class liuxianglong {
	public String multiply(String num1, String num2) {
        if(num1.length()==0||num2.length()==0)return "";
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        int len = cs1.length+cs2.length;
        int[] res = new int[len];
        for(int i=cs1.length-1;i>=0;i--){
            int cur = len-(cs1.length-i);
            for(int j=cs2.length-1;j>=0;j--){
                res[cur]+=(cs1[i]-'0')*(cs2[j]-'0');
                res[cur-1]+=res[cur]/10;
                res[cur]%=10;
                cur--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur =0;
        while(cur<len&&res[cur]==0) cur++;
        for(int i=cur;i<len;i++) sb.append((char)('0'+res[i]));
        return sb.length()==0?"0":sb.toString();
    }
}