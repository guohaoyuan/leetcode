# 中心扩散法，存在缺陷，只会返回第一个回文字串
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        size = len(s)
        if size == 0:
            return '' # 保证字符串不为空
        
        # 至少是1
        longest_palindrome = 1
        longest_palindrome_str = s[0] # 此处时先初始化变量

        for i in range(size):   # 每个元素都进行中心传播
            palindrome_odd, odd_len = self.__center_spread(s, size, i, i)   # 计算为奇数的情况
            palindrome_even, even_len = self.__center_spread(s, size, i, i + 1) # 计算为偶数的情况

            # 当前找到的最长回文字串
            cur_max_sub = palindrome_odd if odd_len >= even_len else palindrome_even   # 判断到底为何种情况
            if len(cur_max_sub) > longest_palindrome:
                longest_palindrome = len(cur_max_sub)   # 更新回文字串的长度
                longest_palindrome_str = cur_max_sub    # 更新回文字串

        return longest_palindrome_str

    def __center_spread(self, s, size, left, right):
        """
        left = right 的时候,此时回文中心是一条线， 回文串的长度是奇数
        right = left + 1 的时候， 此时回文中心是任意一个字符，回文串的长度是偶数
        """ 
        l = left
        r = right

        while l >= 0 and r < size and s[l] == s[r]:
            l -= 1
            r += 1
        return s[l + 1 : r], r - l -1

# 动态规划
"""
解决最优子结构问题，
1. 定义状态;
2. 找到状态转移方程。
"""
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        size = len(s)
        if size <=1:
            return s
        # 二维dp问题
        # 状态: dp[l,r]: s[l,r] 包括l,r,表示的字符串是不是回文串
        # 设置为none是为了方便测试，看清楚代码的执行流程
        dp = [[False for _ in range(size)] for _ in range(size)]

        longest_l = 1
        res = s[0]

        # 因为只有1个字符的情况在最开始做了判断
        # 左边界一定要比右边界小，因此右边界从1开始
        for r in range(1, size):
            for l in range(r):
                # 状态转换方程，如果头尾字符相等且中间也是回文
                # 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有1个元素），直接返回True即可
                # 否则要继续看收缩以后的区间的回文性
                # 重点理解or的短路性质在这里的作用
                # s[l+1, r-1]至少包含两个元素等价了l+1<r-1,即rr-l>2;
                
                if s[l] == s[r] and (r - l <= 2 or dp[l + 1][r -1]):    # 该判断条件厚板句的意思是，去掉左右边界以后的字串不构成区间;且是回文串
                    dp[l][r] = True
                    cur_len = r - l + 1
                    if cur_len > longest_l: # 判断是不是最长回文串
                        longest_l = cur_len
                        res = s[l : r + 1]
            
            # 调试语句
            # for item in dp:
            #     print(item)
            # print('----')
        return res
