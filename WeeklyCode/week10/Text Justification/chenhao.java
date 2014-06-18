public class Solution {
    ArrayList<String> res;
	String[] words;
	int L;
	
	String multiplyString(String str,int n){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(str);
		}
		return sb.toString();
	}
	
	int nextLine(int start){
		int len=words[start].length();
		int end=start+1;
		while(end<words.length){
			len+=words[end].length()+1;
			if(len>L){
				break;
			}
			end++;
		}
		
		int nWords=end-start;
		if(nWords==1 || end==words.length){
			StringBuilder sb=new StringBuilder(words[start]);
			int nSpaces=L-words[start].length();
			for(int i=start+1;i<end;i++){
				sb.append(" "+words[i]);
				nSpaces-=words[i].length()+1;
			}
			sb.append(multiplyString(" ",nSpaces));
			res.add(sb.toString());
		}
		else{
			int wordsLen=0;
			for(int i=start;i<end;i++){
				wordsLen+=words[i].length();
			}
			int nSpaces=L-wordsLen;
			int nBlank=end-start-1;
			int spacesPerBlank=nSpaces/nBlank;
			int remainingSpaces=nSpaces%nBlank;
			
			StringBuilder sb=new StringBuilder(words[start]);
			for(int i=start+1;i<end;i++){
				sb.append(multiplyString(" ",spacesPerBlank+(remainingSpaces-->0?1:0)));
				sb.append(words[i]);
			}
			res.add(sb.toString());
		}
		return end;
	}
	
	public ArrayList<String> fullJustify(String[] words, int L) {
		res=new ArrayList<>();
		this.words=words;
		this.L=L;
        int start=0;
        while(start<words.length){
        	start=nextLine(start);
        }
        return res;
    }
}