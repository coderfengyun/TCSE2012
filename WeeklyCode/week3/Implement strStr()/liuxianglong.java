class liuxianglong {
	enum StringMatcher{
		KMP{
			private int[] computeCovers(String needle){
				int len = needle.length();
				int[] cover = new int[len];
				cover[0]=-1;
				for(int i=1;i<len;i++){
					int last= cover[i-1];
					while(last>=0&&needle.charAt(last+1)!=needle.charAt(i)) last = cover[last];
					if(needle.charAt(last+1)==needle.charAt(i)) last++;
					cover[i]= last;
				}
				return cover;
			}
			@Override
			int strStr(String haystack, String needle) {
				if(haystack==null || needle==null) return -1;
				if(needle.length()==0) return 0;
				if(haystack.length()<needle.length()) return -1;
				int[] cover = computeCovers(needle);
				int last = cover[0];
				for(int i =0;i<haystack.length();i++){
					while(last>=0&&needle.charAt(last+1)!=haystack.charAt(i)) last = cover[last];
					if(needle.charAt(last+1)==haystack.charAt(i)){
						last++;
					}
					if(last ==needle.length()-1) return i-last;
				}
				return -1;
			}
			
		},
		NAIVE{
			@Override
			int strStr(String haystack,String needle){
				for(int i =0;i<=haystack.length()-needle.length();i++){
					int j =0;
					while(j<needle.length()&&haystack.charAt(i+j)==needle.charAt(j)) j++;
					if(j==needle.length()) return i;
				}
				return -1;
			}
		};
		abstract int strStr(String haystack, String needle);
	}
	public String strStr(String haystack, String needle){
		int index = StringMatcher.NAIVE.strStr(haystack,needle);
		if(index==-1) return null;
		return haystack.substring(index);
	}

}