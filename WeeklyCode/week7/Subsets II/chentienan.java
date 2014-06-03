public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(num == null || num.length == 0){
            return result;
        }
        Arrays.sort(num);
        int i = 0, j = -1;
        while(i < num.length){
            int repeatCount = 1;
            j = i + 1;
            while(j < num.length && num[i] == num[j]){
                repeatCount++;
                j++;
            }
            addToResult(num[i], repeatCount, result);
            i = j;
        }
        return result;
    }
    
    private void addToResult(int value, int repeatCount, List<List<Integer>> result){
        List<List<Integer>> temp = null;
        List<Integer> current = new ArrayList<Integer>();
        List<List<Integer>> tempContainer = new ArrayList<List<Integer>>();
        for(int i = 0; i < repeatCount; i++){
            temp = deepCopy(result);
            current.add(value);
            for(List<Integer> list : temp){
                list.addAll(current);
            }
            tempContainer.addAll(temp);
        }
        result.addAll(tempContainer);
    }

    private List<List<Integer>> deepCopy(List<List<Integer>> target){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(List<Integer> list : target){
            List<Integer> listCopy = new ArrayList<Integer>();
            for(Integer i : list){
                listCopy.add(i);
            }
            result.add(listCopy);
        }
        return result;
    }
}