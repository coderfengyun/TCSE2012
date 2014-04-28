public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> res=new LinkedList<>();
        String[] segs=path.split("/");
        for(String seg:segs){
        	if(seg.trim().isEmpty()){
        		continue;
        	}
        	else if(seg.equals(".")){
        		continue;
        	}
        	else if(seg.equals("..")){
        		res.pollLast();
        	}
        	else{
        		res.offerLast(seg);
        	}
        }
        if(res.isEmpty()){
        	return "/";
        }
        else{
        	StringBuilder sb=new StringBuilder();
        	for(String seg:res){
        		sb.append("/"+seg);
        	}
        	return sb.toString();
        }
    }
}