class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        s=''.join(c.lower() for c in s if c.isalnum())
        return s==s[::-1]