class liuxianglong {
    private boolean isAlphanumetric(char c){
        return (c>='a'&&c<='z')||(c>='0'&&c<='9');
    }
    public boolean isPalindrome1(String s) {
        int length = s.length();
        int ib=0,ie=length-1;
        s=s.toLowerCase();
        while(ib<ie){
            char begin = s.charAt(ib);
            char end = s.charAt(ie);
            while(!isAlphanumetric(begin)) {
                if(ib>=ie) return true;
                begin = s.charAt(++ib);
            }
            while(!isAlphanumetric(end)) {
                if(ib>=ie) return true;
                end = s.charAt(--ie);
            }
            if(begin!=end) return false;
            ie--;ib++;
        }
        return true;
    }
}