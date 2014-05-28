class liuxianglong {
	public int ladderLength(String start, String end, Set<String> dict) {
        if(start==null||start.length()==0) return 0;
        Queue<String> queue = new LinkedList<String>();queue.offer(start);
        HashSet<String> visited = new HashSet<String>();
        int len = 1;
        while(queue.size()>0){
            len++;
            Queue<String> tmp = queue;
            queue = new LinkedList<String>();
            while(tmp.size()>0){
                String w = tmp.poll();
                char[] cs = w.toCharArray();
                for(int i=0;i<w.length();i++){
                    char orig = cs[i];
                    for(char c='a';c<='z';c++){
                        cs[i]=c;
                        String s = new String(cs);
                        if(s.equals(end)) return len;
                        if(!visited.contains(s)&&dict.contains(s)){
                            queue.offer(s);
                            visited.add(s);
                        }
                    }
                    cs[i]=orig;
                }
            }
        }
        return 0;
    }
}