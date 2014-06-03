int ladderLength(string start, string end, unordered_set<string> &dict) {
        unordered_set<string> visited;
        visited.insert(start);
        queue<pair<string, int> > q;
        q.push(make_pair(start,1));
        while(!q.empty())
        {
            string tmp = q.front().first;
            int dist = q.front().second;
            if(tmp == end) return dist;
            int len = tmp.size();
            q.pop();
            for(int i=0; i<len; i++)
            {
                char c = tmp[i];
                for(char j='a'; j<='z'; j++)
                {
                    if(j == c) continue;
                    tmp[i] = j;
                    if(visited.find(tmp) == visited.end() && dict.find(tmp) != dict.end())
                    {
                        q.push(make_pair(tmp, dist+1));
                        visited.insert(tmp);
                    }
                    tmp[i] = c;
                }
            }
        }
        return 0;
    }