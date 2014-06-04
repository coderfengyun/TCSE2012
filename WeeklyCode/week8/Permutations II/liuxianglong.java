class liuxianglong {
	private void permute(int[] num,boolean[] visited,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> seq){
        if(seq.size()==num.length){
            res.add(seq);
        }else{
            HashSet<Integer> dup = new HashSet<Integer>();
            for(int i=0;i<num.length;i++){
                if(!visited[i]&&!dup.contains(num[i])){
                    dup.add(num[i]);
                    ArrayList<Integer> newSeq = new ArrayList<Integer>(seq);
                    newSeq.add(num[i]);
                    visited[i]=true;
                    permute(num,visited,res,newSeq);
                    visited[i]=false;
                }
            }
        }
    }
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num==null||num.length==0) return res;
        ArrayList<Integer> seq = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        permute(num,visited,res,seq);
        return res;
    }
}