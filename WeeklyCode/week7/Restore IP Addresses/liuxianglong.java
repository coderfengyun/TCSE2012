class liuxianglong {
	private boolean isIpNum(String ipNum){
        if(ipNum.charAt(0)=='0'&&ipNum.length()!=1) return false;
        int ip = Integer.valueOf(ipNum);
        return ip>=0&&ip<=255;
    }
    private void permuteIp(List<String> res, StringBuilder sb,String s,int begin,int num){
        if(begin==s.length()&&num==0){
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }else{
            int len = s.length()-begin;
            if(len>=num&&len<=num*3){
                for(int l=1;l<=(len<3?len:3);l++){
                    String ipNum = s.substring(begin,begin+l);
                    if(isIpNum(ipNum)){
                        permuteIp(res,new StringBuilder(sb).append(ipNum).append('.'),s,begin+l,num-1);
                    }
                }
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<String>();
        permuteIp(res,sb,s,0,4);
        return res;
    }
}