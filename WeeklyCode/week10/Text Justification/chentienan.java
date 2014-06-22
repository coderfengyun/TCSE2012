public class Solution {
    private String[] words = null;
    public List<String> fullJustify(String[] words, int L) {
        if(words == null){
            return null;
        }
        this.words = words;
        List<String> result = new LinkedList<String>();
        List<Line> lines = splitIntoLinesWith(L);
        for(int i = 0; i < lines.size(); i++){
            result.add(lines.get(i).fillWithBlank(i == lines.size() - 1));
        }
        return result;
    }
    
    private List<Line> splitIntoLinesWith(int lengthConstraint){
        int currentLength = 0;
        List<Line> result = new ArrayList<Line>();
        Line line = new Line(lengthConstraint);
        for(String word : this.words){
            if(!line.canAdd(word)){
                result.add(line);
                line = new Line(lengthConstraint);
            }
            line.add(word);
        }
        if(line.size() > 0){
            result.add(line);
        }
        return result;
    }
    
    private static class Line{
        private List<String> words = new ArrayList<String>();
        private int length = 0;
        private final int lengthConstrain;
        
        public Line(int lengthConstrain){
            this.lengthConstrain = lengthConstrain;
        }
        
        public boolean canAdd(String word){
            return this.length + word.length() + (this.words.isEmpty() ? 0 : 1) <= this.lengthConstrain;
        }
        
        public void add(String word){
            if(!this.words.isEmpty()){
                word = " " + word;
            }
            this.words.add(word);    
            this.length += word.length();
        }
        
        public int size(){
            return this.words.size();
        }
        
        public String fillWithBlank(boolean isLastLine){
            int remainBlanks = this.lengthConstrain - this.length;
            StringBuilder resultBuilder = new StringBuilder();
            if(isLastLine){
                for(String word : this.words){
                    resultBuilder.append(word);       
                }
                resultBuilder.append(makeUpBlanksWith(remainBlanks));
                return resultBuilder.toString();
            }
            int slots = this.size() - 1;
            if(slots == 0){
                return this.words.get(0) + makeUpBlanksWith(remainBlanks);
            }
            int averageBlanks = remainBlanks / slots;
            remainBlanks = remainBlanks % slots;
            resultBuilder.append(this.words.get(0));
            for(int i = 1; i < this.words.size(); i++){
                resultBuilder.append(makeUpBlanksWith(averageBlanks + (remainBlanks-- > 0 ? 1 : 0)));
                resultBuilder.append(this.words.get(i));
            }
            return resultBuilder.toString();
        }
        
        private String makeUpBlanksWith(int size){
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < size; i++){
                result.append(" ");
            }
            return result.toString();
        }
    }
}