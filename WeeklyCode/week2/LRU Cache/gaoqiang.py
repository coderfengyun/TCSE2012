class LRUCache:
    capacity = 0
    cache = {}
    LRUList = []
    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.LRUList = []

    # @return an integer
    def get(self, key):
    	value = self.cache.get(key,-1)
    	if value!=-1:
    		self.LRUList.remove(key)
    		self.LRUList.append(key)
        return value

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
    	if self.cache.has_key(key):
    		self.LRUList.remove(key)
    	else:
    		if len(self.LRUList)==self.capacity:
    			self.cache.pop(self.LRUList[0])
    			del self.LRUList[0]

    	self.LRUList.append(key)
    	self.cache.update({key : value})

if __name__=='__main__':
	cache = LRUCache(1)
	cache.set(2,1)
	print cache.get(2)

