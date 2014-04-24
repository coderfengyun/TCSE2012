struct CacheNode {
    CacheNode* pre;
    int key;
    int value;
    CacheNode* next;
    CacheNode(int k, int v):key(k),value(v),pre(NULL),next(NULL) {};
};

class LRUCache {
public:
    LRUCache(int c):capacity(c),size(0) {
        tail = new CacheNode(0,0);
        tail->pre = tail;
        tail->next = tail;
    }

    int get(int k) {
        unordered_map<int, CacheNode*>::iterator it = m.find(k);
        if(it == m.end())
            return -1;
        CacheNode *cn = it->second;
        cn->pre->next = cn->next;
        cn->next->pre = cn->pre;
        push_back(cn);
        return cn->value;
    }

    void set(int k, int val) {
        unordered_map<int, CacheNode*>::iterator it = m.find(k);
        if(it == m.end())
        {
            if(size < capacity)
            {
                CacheNode *cn = new CacheNode(k, val);
                push_back(cn);
                m[k] = cn;
                size++;
            }
            else
            {
                CacheNode *cn = tail->next;
                tail->next = cn->next;
                cn->next->pre = tail;
                m.erase(cn->key);
                cn->key=k;
                cn->value = val;
                push_back(cn);
                m[k] = cn;
            }
        }

        else
        {
            CacheNode *cn = it->second;
            cn->value = val;
            cn->pre->next = cn->next;
            cn->next->pre = cn->pre;
            push_back(cn);
        }
    }

    void push_back(CacheNode *cn)
    {
        cn->next = tail;
        tail->pre->next=cn;
        cn->pre = tail->pre;
        tail->pre=cn;
    }

private:
    unordered_map<int ,CacheNode*> m;
    CacheNode *tail;
    int size;
    int capacity;
};