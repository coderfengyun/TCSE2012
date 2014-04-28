struct CacheNode{
     CacheNode(int k, int v){
         key = k;
         value = v;
         pre = nullptr;
         next = nullptr;
     }
     int key;
     int value;
     CacheNode *pre;
     CacheNode *next;
 };

 struct List{
     List(){
         head = new CacheNode(-1, -1);
         tail = head;
     }
     void printList(){
         cout << "print List\n" ;
         CacheNode *node = head;
         while (node != nullptr){
             cout << node->value << " ";
         }
         cout << "\nend print>>>\n";
     }
     void AdjustList(CacheNode *node){
         if (node == tail)
             return;
         CacheNode *pre = node->pre;
         CacheNode *next = node->next;
         pre->next = next;
         next->pre = pre;
         tail->next = node;
         node->pre = tail;
         tail = node;
     }
      void AdjustList(CacheNode *node, int value){
         node->value = value;
         if (node == tail)
             return;
         CacheNode *pre = node->pre;
         CacheNode *next = node->next;
         pre->next = next;
         next->pre = pre;
         tail->next = node;
         node->pre = tail;
         tail = node;
     }

      void addNode(CacheNode *node){
          tail->next = node;
          node->pre = tail;
          tail = node;
      }

      int deleteNode(){
          CacheNode *node = head->next;
          int key = node->key;
          if (node != tail){
              CacheNode *next = node->next;
              head->next = next;
              next->pre = head;
              delete node;
          }else{
               head->next = nullptr;
               tail = head;
               delete node;
          }
          return key;
      }

     CacheNode *head;
     CacheNode *tail;
 };


class LRUCache{ 
public:
    LRUCache(int capacity) {
        m_capacity = capacity;
        m_visit = List();
    }
    
    int get(int key) {
      if (m_cache.find(key) != m_cache.end()){
          m_visit.AdjustList(m_cache[key]);
          return m_cache[key]->value;
      }
      return -1;
    }

    void set(int key, int value) {
        if (m_cache.find(key) != m_cache.end()){
            m_visit.AdjustList(m_cache[key], value);
        }else{
            if (m_cache.size() == m_capacity){
                int k = m_visit.deleteNode();
                m_cache.erase(k);
            }
                CacheNode *node =  new CacheNode(key, value);
                m_visit.addNode(node);
                m_cache[key] = node;
        }
    }
   
    int m_capacity;
    map<int, CacheNode *> m_cache;
    List m_visit;
    
};
