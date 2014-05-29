public class Solution {
    
    List<Integer> nums;
    Map<Integer,Integer> counter;
    List<List<Integer>> res;
    
    void dfs(int depth,LinkedList<Integer> subset){
        if(depth>=nums.size()){
            res.add(new ArrayList<>(subset));
            return;
        }
        int num=nums.get(depth);
        for(int k=0;k<=counter.get(num);k++){
            dfs(depth+1,subset);
            subset.offerLast(num);
        }
        for(int k=0;k<=counter.get(num);k++){
        	subset.removeLast();
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] num) {
        counter=new TreeMap<>();
        for(int e:num){
            Integer c=counter.get(e);
            counter.put(e,c==null?1:c+1);
        }
        this.nums=new ArrayList<>(counter.keySet());
        this.res=new ArrayList<>();
        
        dfs(0,new LinkedList<Integer>());
        return res;
    }
    
}