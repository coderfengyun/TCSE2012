class liuxianglong {
public static class LRUCache{
	private int capacity;
	private HashMap<Integer,LinkedEntry> map;
	private class LinkedEntry{
		LinkedEntry before;
		int key;
		int value;
		LinkedEntry after;
		LinkedEntry(){
		}
		LinkedEntry(int key,int value){
			this.key = key;
			this.value = value;
		}
		void remove(){
			before.after = after;
			after.before = before;
		}
		void addBefore(LinkedEntry e){
			before = e.before;
			after = e;
			before.after = this;
			after.before = this;
		}
	}
	private LinkedEntry header;
	public LRUCache(int capacity) {
		map = new HashMap<Integer, LinkedEntry>();
		header = new LinkedEntry();
		header.before=header.after=header;
		this.capacity = capacity;
    }
    
    public int get(int key) {
    	LinkedEntry target = map.get(key);
    	if(target==null) return -1;
    	target.remove();
    	target.addBefore(header);
        return target.value;
    }
    
    public void set(int key, int value) {
    	LinkedEntry target = map.get(key);
    	if(target==null){
    		if(capacity==map.size()){
    			int removeKey = header.after.key;
    			map.remove(removeKey);
    			header.after.remove();
    		}
    		target = new LinkedEntry(key, value);
            target.addBefore(header);
            map.put(key,target);
    	}else{
    		target.value=value;
    		target.remove();
    		target.addBefore(header);
    	}
    }
}
}