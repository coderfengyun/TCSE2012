public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start.equals(end)) {
			return 2;
		}
		if (dict.size() == 0) {
			return 0;
		}
		dict.add(start);
		dict.add(end);
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		for (String word : dict) {
			visited.put(word, false);
		}

		Queue<String> queue = new LinkedList<String>(), queue2 = new LinkedList<String>();
		queue.add(start);
		visited.put(start, true);
		int depth =1;
		while (queue.size() > 0) {
			while (queue.size() > 0) {
				String current = queue.poll();
				for (int i = 0; i < current.length(); i++) {
					for (int j = 0; j < 26; j++) {
						if (current.charAt(i) == 'a' + j) {
							continue;
						}
						String newWord = current.substring(0, i) + (char)('a' + j)
								+ current.substring(i + 1);
						if (dict.contains(newWord) && !visited.get(newWord)) {
							if (newWord.equals(end)) {
								return depth + 1;
							}
							visited.put(newWord, true);
							queue2.add(newWord);
						}
					}
				}
			}
			queue.addAll(queue2);
			queue2.clear();
			depth = depth + 1;
		}
		return 0;
	}
}