public class Solution {

    String s;
    List<List<Integer>> prev;
    List<String> res;

    public List<String> wordBreak(String s, Set<String> dict) {
        Trie trie=new Trie();
        for(String str:dict){
            trie.add(str);
        }
        this.s=s;
        int n=s.length();
        prev=new ArrayList<>(n+1);
        for(int i=0;i<n+1;i++){
            prev.add(new LinkedList<Integer>());
        }
        prev.get(0).add(-1);
        for(int i=0;i<n;i++){
            if(prev.get(i).isEmpty()){
                continue;
            }
            for(String word:trie.find(s,i)){
                prev.get(i+word.length()).add(i);
            }
        }
        
        res=new LinkedList<>();
        backtrace(n,"");
        return res;
    }
    
    private void backtrace(int n,String output){
        if(n==0){
            res.add(output.substring(1));
            return;
        }
        for(Integer pre:prev.get(n)){
            backtrace(pre," "+s.substring(pre,n)+output);
        }
    }
    
    private static class Trie{
        private class TrieNode{
            char c;
            int cnt=0;
            Map<Character,TrieNode> children=new HashMap<>();
            
            public TrieNode(char c){
                this.c=c;
            }
        }
        
        TrieNode root=new TrieNode(' ');
        
        public void add(String str){
            TrieNode cur=root;
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                TrieNode next=cur.children.get(c);
                if(next==null){
                    next=new TrieNode(c);
                    cur.children.put(c,next);
                }
                cur=next;
            }
            cur.cnt+=1;
        }
        
        public Set<String> find(String str,int start){
            Set<String> res=new HashSet<>();
            TrieNode cur=root;
            for(int i=start;i<str.length();i++){
                char c=str.charAt(i);
                TrieNode next=cur.children.get(c);
                if(next==null){
                    break;
                }
                if(next.cnt>0){
                    res.add(str.substring(start,i+1));
                }
                cur=next;
            }
            return res;
       }
   }
}