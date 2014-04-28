public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        int listLength = getListLength(head);
        int[] randomIndexArray = new int[listLength];
	RandomListNode[] mapIndexToNode = new RandomListNode[listLength];
        
        initArray(randomIndexArray);
        
        int currentIndex = 0;
        RandomListNode headForIteration = head, result = null;
        while(headForIteration != null)
        {
            result = new RandomListNode(headForIteration.label);
	    mapIndexToNode[currentIndex] = result;
            if(headForIteration.random == null)
            {
                result.random = null;
            }else{
                 randomIndexArray[currentIndex] = findForRandomTarget(head, headForIteration.random);
            }
            headForIteration = headForIteration.next;
            result = result.next;
            currentIndex++;
        }
        
        return buildUpRandom(result, randomIndexArray);
    }

    private RandomListNode buildUpRandom(RandomListNode index, int[] randomIndexArray, RandomListNode[] map)
    {
        RandomListNode result = index;
        for(int i = 0; i < randomIndexArray.length && result != null; i++)
        {
            if(randomIndexArray[i] == -1) 
            {
                result.random = null;
            }else{
		result.random = map[randomIndexArray[i]];
            }
            result = result.next;
        }
        return result;
    }

    private int findForRandomTarget(RandomListNode head, RandomListNode randomTarget)
    {
        if(head == randomTarget) return -1;
        int result = 0;
        while(head != null)
        {
            if(head.equals(randomTarget))
            {
                break;
            }
            head = head.next;
            result++;
        }
        return result;
    }
    
    private int getListLength(RandomListNode head)
    {
        int result = 0;
        while(head != null)
        {
            result++;
            head = head.next;
        }
        return result;
    }
    private void initArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = -1;
        }
    }
}