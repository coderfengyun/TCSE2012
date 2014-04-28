class liuxianglong {
	private RandomListNode getCloneNode(Map<RandomListNode,RandomListNode> map,RandomListNode original){
		if(original==null) return null;
		RandomListNode exist = map.get(original);
		if(exist==null){
			exist = new RandomListNode(original.label);
			map.put(original, exist);
		}
		return exist;
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null) return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode cloneHead = new RandomListNode(head.label);
        map.put(head, cloneHead);
        RandomListNode cur= head;
        while(cur!=null){
        	RandomListNode clone = getCloneNode(map, cur);
        	clone.next = getCloneNode(map,cur.next);
        	clone.random = getCloneNode(map, cur.random);
        	cur = cur.next;
        }
        return cloneHead;
    }
}