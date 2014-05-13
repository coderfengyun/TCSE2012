class Solution:
    """see http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html"""
    # @param height, a list of integer
    # @return an integer
    def largestRectangleArea(self, height):
        maxArea=0
        stack=[-1]
        h=height+[0]
        for i in range(0,len(h)):
            while len(stack)>1 and h[stack[-1]]>h[i]:
                area=h[stack[-1]]*(i-stack[-2]-1)
                maxArea=max(maxArea,area)
                stack.pop()
            stack.append(i)
        return maxArea