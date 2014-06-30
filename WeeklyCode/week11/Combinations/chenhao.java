public class Solution {

    int n,k;
    List<List<Integer>> res;
    
    private void dfs(int depth,LinkedList<Integer> cur){
        if(cur.size()==k){
            res.add(new ArrayList(cur));
            return;
        }
        if(depth>n){
            return;
        }
        cur.add(depth);
        dfs(depth+1,cur);
        cur.removeLast();
        dfs(depth+1,cur);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n=n;
        this.k=k;
        this.res=new ArrayList<>();
        dfs(1,new LinkedList<Integer>());
        return res;
    }
}