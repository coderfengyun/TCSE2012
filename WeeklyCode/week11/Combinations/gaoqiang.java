public class Solution {
    private List<List<Integer>> result = null;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        if(n<=0||k<=0||n<k){
            return result;
        }
        combineNext(n, k, 1, new ArrayList<Integer>());
        return result;
    }
    
    public void combineNext(int n, int k, int current, List<Integer> currentList){
        if(currentList.size()==k){
            result.add(currentList);
            return;
        }
        if(current>n||(currentList.size() +(n-current+1))<k){
            return;
        }
        List<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
        left.addAll(currentList);
        right.addAll(currentList);
        right.add(current);
        combineNext(n,k,current+1,left);
        combineNext(n,k,current+1,right);
    }
}