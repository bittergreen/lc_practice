# 1657. 确定两个字符串是否接近

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False

        def get_dict(l):
            res = {}
            for elem in l:
                if elem not in res:
                    res[elem] = 1
                else:
                    res[elem] += 1
            return res

        dict1 = get_dict(word1)
        dict2 = get_dict(word2)

        # same set of keys and same frequency
        if set(dict1.keys()) != set(dict2.keys()):
            return False
        if sorted(dict1.values()) != sorted(dict2.values()):
            return False
        return True
