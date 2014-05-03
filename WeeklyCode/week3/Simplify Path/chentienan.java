public class Solution {
    public String simplifyPath(String path)
    {
        if(path == null || path.length() == 1) return path;
        //Make sure the last character is slash
        if(path.charAt(path.length() - 1) != '/') path += "/";
        char[] pathCharArray = path.toCharArray();
        //temp record the content between two slash
        StringBuffer result = new StringBuffer(), temp = new StringBuffer();
        for(int index = 0; index < pathCharArray.length; index++)
        {
            if(index == 0) {
                result.append(pathCharArray[index]);
                continue;
            }
            if(pathCharArray[index] == '/'){
                doForBefore(index, pathCharArray, result, temp);
            }else{
                temp.append(pathCharArray[index]);
            }
        }
        if(temp.length() > 0) result.append(temp);
        return result.toString();
    }
    
    private void doForBefore(int index, char[] input, StringBuffer result, StringBuffer temp){
        if(temp.length() > 0){
            if(temp.toString().equals("..")){
                dealWithUpperLayer(result);
            }else if(temp.toString().equals(".")){
                //Jump this dot
            }else{
                result.append(temp);
            }
            temp.delete(0, temp.length());
        }
        if(result.charAt(result.length() - 1) == '/'){
            return;
        }
        if(index == input.length - 1){
            return;
        }
        result.append('/');
    }
    
    private void dealWithUpperLayer(StringBuffer result)
    {
        result.deleteCharAt(result.length() - 1);
        int index = result.lastIndexOf("//");
        if(index == 0 || index == -1) {
            return;
        }
        result.delete(index, result.length() - 1);
    }
}