public class LRUCache {
	// The key is the input key, the value is the visitTime of this key, it's
	// sorted by the visitTimes descending
	VisitTupple[] visitQueue;
	// The key is the input key, the value is the input value, and it's sorted
	// by the key
	KeyValuePair[] keyValuePairs;
	private int currentSize;
	private int capacity;

	public LRUCache(int capacity) {
		this.visitQueue = new VisitTupple[capacity];
		this.keyValuePairs = new KeyValuePair[capacity];
		this.capacity = capacity;
		this.currentSize = 0;
	}

	public void set(int key, int value) {
		int keyIndex = getKeyIndex(key);
		if (keyIndex == -1) {
			doInsertForKeyNotExist(key, value);
		} else {
			doArrangeForKeyExist(keyIndex);
		}
	}

	private void doArrangeForKeyExist(int keyIndex) {
		int visitTimes = this.keyValuePairs[keyIndex].visitTimes;
		int visitTimesIndex = this.getVisitTimesIndex(visitTimes,
				this.keyValuePairs[keyIndex].key);
		updateVisitQueue(visitTimesIndex);
		this.keyValuePairs[keyIndex]
				.editValue(this.keyValuePairs[keyIndex].value);
	}

	private void updateVisitQueue(int visitTimesIndex) {
		// Don't forget to visit the item
		int iterator = visitTimesIndex;
		int targetVisitTimes = this.visitQueue[visitTimesIndex].visitTimes;
		while (iterator >= 0) {
			if (this.visitQueue[iterator].visitTimes < targetVisitTimes + 2) {
				iterator--;
			}
		}
		this.arrangeVisitQueue(iterator + 1, visitTimesIndex);
		this.visitQueue[iterator + 1].visit();
	}

	private void arrangeVisitQueue(int targetIndex, int originIndex) {
		if (originIndex == 0) {
			this.visitQueue[originIndex].visit();
			return;
		}
		VisitTupple copy = this.visitQueue[originIndex];
		for (int i = originIndex - 1; i >= targetIndex; i--) {
			this.visitQueue[i + 1] = this.visitQueue[i];
		}
		this.visitQueue[targetIndex] = copy;
	}

	private void doInsertForKeyNotExist(int key, int value) {
		if (isFull()) {
			doRemoveLRU();
		}
		this.visitQueue[this.currentSize] = new VisitTupple(key);
		this.insertKeyValuePair(new KeyValuePair(key, value));
		this.currentSize++;
	}

	private void doRemoveLRU() {
		int keyToRemove = this.visitQueue[this.currentSize - 1].key;
		this.visitQueue[this.currentSize - 1] = null;
		int keyIndex = this.getKeyIndex(keyToRemove);

		for (int i = keyIndex; i < this.currentSize - 1; i++) {
			this.keyValuePairs[i] = this.keyValuePairs[i + 1];
		}
		this.currentSize--;
	}

	public int get(int key) {
		int keyIndex = this.getKeyIndex(key);
		return keyIndex == -1 ? -1 : this.keyValuePairs[keyIndex].value;
	}

	/**
	 * insert and sort
	 * 
	 * @param keyValuePair
	 */
	private void insertKeyValuePair(KeyValuePair keyValuePair) {
		int i = 0;
		for (; i < this.keyValuePairs.length; i++) {
			if (keyValuePair.key < this.keyValuePairs[i].key) {
				break;
			}
		}
		for (int j = this.keyValuePairs.length - 1; j >= i; j--) {
			this.keyValuePairs[j + 1] = this.keyValuePairs[j];
		}
		this.keyValuePairs[i] = keyValuePair;
	}

	private boolean isFull() {
		return this.currentSize == this.capacity;
	}

	private int getVisitTimesIndex(int visitTimes, int key) {
		int leftBound = 0, rightBound = this.currentSize - 1;
		int mid = 0;
		while (leftBound <= rightBound) {
			mid = (leftBound + rightBound) / 2;
			if (visitTimes == this.visitQueue[mid].visitTimes
					&& key == this.visitQueue[mid].key) {
				return mid;
			}
			if (visitTimes < this.visitQueue[mid].visitTimes) {
				leftBound = mid + 1;
			} else if (visitTimes > this.visitQueue[mid].visitTimes) {
				rightBound = mid - 1;
			}
		}
		return -1;
	}

	private int getKeyIndex(int key) {
		int leftBound = 0, rightBound = this.currentSize - 1;
		int mid = 0;
		while (leftBound <= rightBound) {
			mid = (leftBound + rightBound) / 2;
			if (key == this.keyValuePairs[mid].key) {
				return mid;
			}
			if (key > this.keyValuePairs[mid].key) {
				leftBound = mid + 1;
			} else if (key < this.keyValuePairs[mid].key) {
				rightBound = mid - 1;
			}
		}
		return -1;
	}

	private static class VisitTupple {
		private int key;
		private int visitTimes;

		public VisitTupple(int key) {
			this.key = key;
			this.visitTimes = 0;
		}

		public void visit() {
			this.visitTimes++;
		}
	}

	private static class KeyValuePair {
		private int key;
		private int value;
		private int visitTimes;

		public KeyValuePair(int key, int value) {
			this.key = key;
			this.value = value;
			this.visitTimes = 0;
		}

		public void editValue(int value) {
			this.value = value;
			this.visitTimes++;
		}
	}
}