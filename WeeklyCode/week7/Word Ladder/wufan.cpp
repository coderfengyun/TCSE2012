class Solution {
public:
	int ladderLength(string start, string end, unordered_set<string> &dict) {
		int level = 1;
		unordered_set<string> visited;
		queue<string>cur, next;
		cur.push(start);
		visited.insert(start);
		while (!cur.empty()){
			while (!cur.empty()){
				string s = cur.front();
				cur.pop();
				//extend states
				for (int i = 0; i < s.size(); i++){
					for (char c = 'a'; c <= 'z'; c++){
						if (s[i] == c) continue;
						string tmp = s;
						tmp[i] = c;
						if (tmp == end)
							return level;
						if (visited.find(tmp) == visited.end() && dict.find(tmp)!= dict.end()){
							visited.insert(tmp);
							next.push(tmp);
						}
					}
				}
			}
			swap(cur, next);
			level++;
		}
		return 0;
	}
};
