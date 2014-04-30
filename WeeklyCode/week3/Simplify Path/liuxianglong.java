class liuxianglong {
	public String simplifyPath(String path) {
        ArrayList<String> list = new ArrayList<String>();
        String[] p = path.split("/");
        for(String s:p){
        	if(s.length()==0) continue;
        	if(s.equals("..")){
        		if(list.size()>0) {
        			list.remove(list.size()-1);
        		}
        	}else if(!s.equals(".")){
        		list.add(s);
        	}
        }
        StringBuilder res = new StringBuilder();
        if(list.size()==0){
        	res.append('/');
        }else{
        	for(String s:list){
        		res.append('/').append(s);
        	}
        }
        return res.toString();
    }
}