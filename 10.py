# 1. 不考虑正则符号情况下如果是普通字符串进行比较，利用递归思想进行，只编写第一个字母是否匹配的程序，然后进行递归
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if p is empty:
            return s is empty

        first_match = (s not empty) and p[0] == s[0]
        return first_match and isMatch(t[1:], p[1:])

# 2. 考录处理*
class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if not p:   # p为空且s为空时为True
            return not s

        first_match = bool(s) and p[0] in {s[0], '.'}   # 第一个字母匹配与否
        if len(p) >= 2 and p[1] == '*':
            # 看第二个字母的情况，这里相当于不管第一个字母是否匹配，继续看第二个字母
            return self.isMatch(s, p[2:]) or \
                    first_match and self.isMatch(s[1:], p)   # 第二个字母为*,则判断是否匹配
        else:
            return first_match and self.isMatch(s[1:], p[1:])
