import java.util.HashMap;
import java.util.Map;



public class LRUCache {
	
	private class ListNode{
		
		int key;
		int value;
		
		ListNode prev;
		ListNode next;
		
		public ListNode(){
		}
		
		public ListNode(int key,int value){
			this.key=key;
			this.value=value;
		}
	}
	
	int capacity;
	
	ListNode head,tail;
	
	Map<Integer,ListNode> nodeMap;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=null;
        this.tail=null;
        this.nodeMap=new HashMap<>();
    }
    
    private ListNode findNode(int key){
    	return nodeMap.get(key);
    }
    
    private void offerFirst(ListNode node){
    	nodeMap.put(node.key,node);
    	if(nodeMap.size()==1){
    		head=tail=node;
    		node.prev=node.next=null;
    	}
    	else{
    		node.prev=null;
    		node.next=head;
    		head.prev=node;
    		head=node;
    	}
    }
    
    private void removeNode(ListNode node){
    	if(node==tail){
    		tail=node.prev;
    	}
    	if(node==head){
    		head=node.next;
    	}
    	nodeMap.remove(node.key);
    	ListNode prev=node.prev;
    	ListNode next=node.next;
    	if(prev!=null){
    		prev.next=next;
    	}
    	if(next!=null){
    		next.prev=prev;
    	}
    }
    
    private void updateNode(ListNode node){
    	removeNode(node);
    	offerFirst(node);
    }
    
    public int get(int key) {
        ListNode node=findNode(key);
        if(node!=null){
        	updateNode(node);
        	return node.value;
        }
        else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
    	if(capacity<=0){
    		return;
    	}
        ListNode node=findNode(key);
        if(node!=null){
        	node.value=value;
        	updateNode(node);
        }
        else{
        	if(nodeMap.size()==capacity){
        		removeNode(tail);
        	}
        	ListNode newNode=new ListNode(key,value);
        	offerFirst(newNode);
        }
    }
    
    public static void main(String[] args){
		LRUCache cache=new LRUCache(2);
		cache.set(2,1);
		cache.set(3,2);
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		cache.set(4,3);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}
}