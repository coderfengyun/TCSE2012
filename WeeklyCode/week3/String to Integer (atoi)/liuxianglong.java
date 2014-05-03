class liuxianglong {
	public int atoi(String str) {
        if(str==null||str.length()==0) return 0;
        long result=0;
        int sign=1;
        int count=0;
        while(str.charAt(count)==' ') count++;
        str = str.substring(count);
        for(int i=0;i<str.length();i++){
        	int digit = str.charAt(i)-'0';
        	if(digit>=0&&digit<=9){
        		result=result*10+digit;
        	}else{
        		if(i==0){
        			if(str.charAt(0)=='-'){
        				sign=-1;
        				continue;
        			}
        			if(str.charAt(0)=='+'){
        				continue;
        			}
        			break;
        		}else{
        			break;
        		}
        	}
        }
        result*=sign;
        if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
}