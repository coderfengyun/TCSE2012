struct CacheNode{
	int key;
	int value;
	CacheNode(int key,int value):key(key) ,value(value){}
};
class LRUCache{
public:
	LRUCache(int capacity) {
		maxSize=capacity;
		cacheList.clear();
		cacheMap.clear();
	}

	int get(int key) {

		if(cacheMap.find(key)!=cacheMap.end()){
			list<CacheNode>::iterator it=cacheMap[key];
			cacheList.push_front(*it);
			cacheList.erase(it);
			cacheMap[key]=cacheList.begin();
			return cacheList.front().value;
		}else{
			return -1;
		}
	}

	void set(int key, int value) {
		if(cacheMap.find(key)!=cacheMap.end()){
			list<CacheNode>::iterator it=cacheMap[key];
			it->value=value;
			cacheList.push_front(*it);
			cacheList.erase(it);
			cacheMap[key]=cacheList.begin();
		}
		else{
			if(maxSize>cacheList.size()){
				CacheNode newNode(key,value);
				cacheList.push_front(newNode);
				cacheMap[key]=cacheList.begin();
			}
			else{
				CacheNode newNode(key,value);
				CacheNode tbr=cacheList.back();
				int tbrKey=tbr.key;
				cacheMap.erase(tbrKey);
				cacheList.pop_back();
				cacheList.push_front(newNode);
				cacheMap[newNode.key]=cacheList.begin();
			}
		}
	}
private:
	int maxSize;
	list<CacheNode> cacheList;
	unordered_map<int,list<CacheNode>::iterator> cacheMap;

};
