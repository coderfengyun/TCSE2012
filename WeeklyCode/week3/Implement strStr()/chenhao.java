import java.util.Objects;


public class StrStr {

	public String strStr(String haystack, String needle){
		if(haystack==null || needle==null){
			return null;
		}
//		StringFinder finder=new BruteForceStringFinder();
//		StringFinder finder=new KmpStringFinder(needle);
		StringFinder finder=new RabinKarpStringFinder();
		int index=finder.indexOf(haystack,needle);
		return index<0?null:haystack.substring(index);
	}
}

interface StringFinder {

	/**
	 * @param main
	 *            (Non-null) the main string to search from.
	 * @param sub
	 *            (Non-null) the sub string to find.
	 * @return the index of first appearance if found, else -1.
	 */
	int indexOf(String main, String sub);
}

class BruteForceStringFinder implements StringFinder {

	@Override
	public int indexOf(String main, String sub){
		main=Objects.requireNonNull(main);
		sub=Objects.requireNonNull(sub);
		int n=main.length();
		int m=sub.length();
		if(m==0){
			return 0;
		}

		mainLoop: for(int i=0; i+m<=n; i++){
			for(int j=0; j<m; j++){
				if(main.charAt(i+j)!=sub.charAt(j)){
					continue mainLoop;
				}
			}
			return i;
		}
		return -1;
	}
}

class KmpStringFinder implements StringFinder{
	
	private String sub;
	private int[] match;
	
	public KmpStringFinder(){
		this(null);
	}
	
	public KmpStringFinder(String sub){
		initialize(sub);
	}
	
	private void initialize(String sub){
		this.sub=sub;
		if(sub==null || sub.isEmpty()){
			return;
		}
		int n=sub.length();
		match=new int[n];
		match[0]=0;
		for(int i=1,matched=0;i<n;i++){
			while(matched>0 && sub.charAt(i)!=sub.charAt(matched)){
				matched=match[matched-1];
			}
			if(sub.charAt(i)==sub.charAt(matched)){
				matched++;
			}
			match[i]=matched;
		}
	}
	
	public int indexOf(String main){
		main=Objects.requireNonNull(main);
		if(this.sub==null){
			throw new IllegalStateException("sub string not set.");
		}
		if(sub.isEmpty()){
			return 0;
		}
		for(int i=0,j=0;i<main.length();i++){
			while(j>0 && main.charAt(i)!=sub.charAt(j)){
				j=match[j-1];
			}
			if(main.charAt(i)==sub.charAt(j)){
				j++;
			}
			if(j==sub.length()){
				return i-j+1;
			}
		}
		return -1;
	}

	@Override
	public int indexOf(String main, String sub){
		main=Objects.requireNonNull(main);
		sub=Objects.requireNonNull(sub);
		if(!sub.equals(this.sub)){
			initialize(sub);
		}
		return indexOf(main);
	}
}

class RabinKarpStringFinder implements StringFinder{
	
	private static final long BASE=Character.MAX_CODE_POINT+1;
	private static final long MOD=(long)(1e9+7);

	@Override
	public int indexOf(String main, String sub){
		main=Objects.requireNonNull(main);
		sub=Objects.requireNonNull(sub);
		int n=main.length();
		int m=sub.length();
		if(m==0){
			return 0;
		}
		if(m>n){
			return -1;
		}
		if(m==n){
			return main.equals(sub)?0:-1;
		}
		
		long b=1;
		for(int i=0;i<m-1;i++){
			b=(b*BASE)%MOD;
		}
		
		long h1=0,h2=0;
		for(int i=0;i<m;i++){
			h1=(h1*BASE+main.codePointAt(i))%MOD;
			h2=(h2*BASE+sub.codePointAt(i))%MOD;
		}
		
		for(int i=m;i<n;i++){
			if(h1==h2){
				if(main.substring(i-m,i).equals(sub)){
					return i-m;
				}
			}
			h1=((h1-main.codePointAt(i-m)*b)*BASE+main.codePointAt(i))%MOD;
			if(h1<0){
				h1+=MOD;
			}
		}

		return -1;
	}
}