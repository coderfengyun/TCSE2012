class Solution:
	count=0
	def isValid(self, queues, checkQ):
		if checkQ>= len(queues):
			return False
		checkPos=queues[checkQ]
		for i in range(0,checkQ):
			prePos = queues[i]
			if prePos==checkPos:
				return False
			dpx=abs(prePos-checkPos)
			dpy=abs(i-checkQ)
			if dpx==dpy:
				return False
		return True

	# @return a list of lists of string
	def totalNQueens(self, n):
		self.count = 0
		queues=[0]*n
		currentQ=0
		forward=True
		while currentQ>=0 and currentQ<n:
			if forward:
				if self.isValid(queues, currentQ):
					if currentQ==n-1:
						self.count=self.count+1
						forward=False
					else:
						currentQ=currentQ+1
						queues[currentQ]=0 #may walk back
				else:
					forward=False
			else:
				if queues[currentQ]<n-1:
					queues[currentQ]=queues[currentQ]+1
					forward=True
				else:
					currentQ=currentQ-1
		return self.count