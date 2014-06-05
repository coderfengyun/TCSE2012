public class Solution {
    
    void dfs(LinkedList<Integer> cur,int nTotal,TreeMap<Integer,Integer> count,List<List<Integer>> res){
        if(cur.size()==nTotal){
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for(Integer num:count.keySet()){
            if(cur.size()>0 && cur.getLast().equals(num)){
                continue;
            }
            int cnt=count.get(num);
            for(int i=0;i<cnt;i++){
                cur.offerLast(num);
            }
            for(int i=0;i<cnt;i++){
                count.put(num,i);
                dfs(cur,nTotal,count,res);
                cur.removeLast();
            }
            count.put(num,cnt);
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        TreeMap<Integer,Integer> count=new TreeMap<>();
        for(int e:num){
            Integer cnt=count.get(e);
            count.put(e,cnt==null?1:cnt+1);
        }
        List<List<Integer>> res=new ArrayList<>();
        dfs(new LinkedList<Integer>(),num.length,count,res);
        return res;
    }
}

public class Solution {

    private void swap(int[] num,int x,int y){
        int t=num[x];
        num[x]=num[y];
        num[y]=t;
    }
    
    private void reverse(int[] num,int from,int to){
        while(from<to){
            swap(num,from++,to--);
        }
    }
    
    private boolean nextPermutation(int[] num){
        int p=num.length-2;
        while(p>=0 && num[p]>=num[p+1]){
            p--;
        }
        if(p<0){
            reverse(num,0,num.length-1);
            return false;
        }
        else{
            int q=num.length-1;
            while(num[q]<=num[p]){
                q--;
            }
            swap(num,p,q);
            reverse(num,p+1,num.length-1);
            return true;
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        int[] numbers=Arrays.copyOf(num,num.length);
        Arrays.sort(numbers);
        List<List<Integer>> res=new ArrayList<>();
        do{
            List<Integer> list=new ArrayList<>(numbers.length);
            for(int e:numbers){
                list.add(e);
            }
            res.add(list);
        }
        while(nextPermutation(numbers));
        return res;
    }
}