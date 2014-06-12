class liuxianglong {
	public boolean isScramble(String s1, String s2) {
        if(s1==null||s2==null) return false;
    	if(s1.length()!=s2.length()) return false;
    	int length = s1.length();
    	if(length==0) return true;
    	boolean[][][] isScramble = new boolean[length+1][length][length];
    	for(int subLength=1;subLength<=length;subLength++){
    		for(int s1Index=0;s1Index<length-subLength+1;s1Index++){
    			for(int s2Index=0;s2Index<length-subLength+1;s2Index++){
    				if(subLength==1){
    					isScramble[subLength][s1Index][s2Index]=
    							s1.charAt(s1Index)==s2.charAt(s2Index);
    				}else{
    					for(int cut=1;cut<subLength;cut++){
    						if(isScramble[cut][s1Index][s2Index]&&isScramble[subLength-cut][s1Index+cut][s2Index+cut]){
    							isScramble[subLength][s1Index][s2Index]=true;
    							break;
    						}
    						if(isScramble[cut][s1Index][s2Index+subLength-cut]&&isScramble[subLength-cut][s1Index+cut][s2Index]){
    							isScramble[subLength][s1Index][s2Index]=true;
    							break;
    						}
    						isScramble[subLength][s1Index][s2Index]=false;
    					}
    				}
    			}
    		}
    	}
    	return isScramble[length][0][0];
    }
}