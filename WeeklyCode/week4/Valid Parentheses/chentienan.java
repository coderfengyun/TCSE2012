public class Solution {
    static enum BraceType{
        BIG_LEFT,BIG_RIGHT,MIDDLE_LEFT,MIDDLE_RIGHT,SMALL_LEFT,SMALL_RIGHT,NOT
    }
    
    public boolean isValid(String s) {
        Stack<BraceType> stack = new Stack<BraceType>();
        for(int i = 0; i < s.length(); i++){
            BraceType braceType = check(s.charAt(i));
            if(notBrace(braceType)){
                continue;
            }
            if(isLeft(braceType)){
                stack.push(braceType);
            }else if(isRight(braceType)){
                if(stack.empty() || !isAPair(stack.pop(), braceType)){
                    return false;
                }
            }
        }        
        return stack.empty();
    }
    
    private boolean isAPair(BraceType left, BraceType right){
        if(left == null){
            return false;
        }else if(left == BraceType.BIG_LEFT){
            return right == BraceType.BIG_RIGHT;
        }else if(left == BraceType.MIDDLE_LEFT){
            return right == BraceType.MIDDLE_RIGHT;
        }else if(left == BraceType.SMALL_LEFT){
            return right == BraceType.SMALL_RIGHT;
        }else {
            return false;
        }
    }
    
    private boolean notBrace(BraceType toBeTested){
        return toBeTested.equals(BraceType.NOT);
    }

    private boolean isLeft(BraceType toBeTested){
        return toBeTested.equals(BraceType.BIG_LEFT) || toBeTested.equals(BraceType.MIDDLE_LEFT) || toBeTested.equals(BraceType.SMALL_LEFT);
    }
    
    private boolean isRight(BraceType toBeTested){
        return toBeTested.equals(BraceType.BIG_RIGHT) || toBeTested.equals(BraceType.MIDDLE_RIGHT) || toBeTested.equals(BraceType.SMALL_RIGHT);
    }
    
    private BraceType check(char toBeTested){
        if(toBeTested == '('){
            return BraceType.SMALL_LEFT;
        }else if(toBeTested == ')'){
            return BraceType.SMALL_RIGHT;
        }else if(toBeTested == '['){
            return BraceType.MIDDLE_LEFT;
        }else if(toBeTested == ']'){
            return BraceType.MIDDLE_RIGHT;
        }else if(toBeTested == '{'){
            return BraceType.BIG_LEFT;
        }else if(toBeTested == '}'){
            return BraceType.BIG_RIGHT;
        }else {
            return BraceType.NOT;
        }
    }
    
}