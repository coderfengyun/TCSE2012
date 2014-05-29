
public class Solution {

    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> words=new HashSet<>(dict);
        words.add(start);
        words.add(end);
        Map<String,Integer> indexMap=new HashMap<>();
        int n=0;
        for(String word:words){
            indexMap.put(word,n++);
        }
        
        Dijkstra dij=new Dijkstra(n);
        for(String word:words){
            int from=indexMap.get(word);
            StringBuilder changed=new StringBuilder(word);
            for(int i=0;i<word.length();i++){
                for(int j=0;j<26;j++){
                    if(j==word.charAt(i)-'a'){
                        continue;
                    }
                    changed.setCharAt(i,(char)(j+'a'));
                    Integer to=indexMap.get(changed.toString());
                    if(to!=null){
                        dij.addEdge(from,to,1);
                    }
                }
                changed.setCharAt(i,word.charAt(i));
            }
        }
        return 1+dij.findShortestDistance(indexMap.get(start),
                indexMap.get(end));
    }
    
    private static class Dijkstra{
        
        private static final int INF=1<<30;
        
        private class Edge{
            final int to;
            final int distance;
            public Edge(int to,int distance){
                this.to=to;
                this.distance=distance;
            }
        }
        
        int n;
        List<List<Edge>> edges;
        
        public Dijkstra(int n){
            this.n=n;
            this.edges=new ArrayList<>(n);
            for(int i=0;i<n;i++){
                edges.add(new LinkedList<Edge>());
            }
        }
        
        public void addEdge(int from,int to,int distance){
            edges.get(from).add(new Edge(to,distance));
        }
        
        public int findShortestDistance(int start,int end){
            final int[] minDis=new int[n];
            
//            Queue<Integer> queue=new LinkedList<>();
            PriorityQueue<Integer> queue=new PriorityQueue<>(n,new Comparator<Integer>(){
               
               @Override
               public int compare(Integer i1,Integer i2){
                   return minDis[i1]-minDis[i2];
               } 
            });
            
            Arrays.fill(minDis,INF);
            minDis[start]=0;
            queue.offer(start);
            
            while(!queue.isEmpty()){
                Integer cur=queue.poll();
                for(Edge edge:edges.get(cur)){
                    int next=edge.to;
                    if(minDis[cur]+edge.distance<minDis[next]){
                        minDis[next]=minDis[cur]+edge.distance;
                        if(next==end){
                            return minDis[next];
                        }
                        queue.offer(next);
                    }
                }
            }
            return -1;
        } 
    }
}