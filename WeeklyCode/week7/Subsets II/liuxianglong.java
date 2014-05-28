class liuxianglong {
    private List<List<Integer>> buildDup(int dup,int target,List<Integer> subset){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<=dup;i++){
            List<Integer> newSet = new ArrayList<Integer>(subset);
            for(int j=0;j<i;j++){
                newSet.add(target);
            }
            res.add(newSet);
        }
        return res;
    }
    private void permute(List<List<Integer>> res,List<Integer> subset,int[] num,int cur){
        if(cur==num.length){
            res.add(subset);
        }else{
            int dup = 1;
            while(cur+dup<num.length&&num[cur+dup]==num[cur]) dup++;
            for(List<Integer> set:buildDup(dup,num[cur],subset)){
                permute(res,set,num,cur+dup);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        permute(res,subset,num,0);
        return res;
    }
}