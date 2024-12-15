# 1268. 搜索推荐系统
from typing import List


class Node:
    def __init__(self):
        self.children = {}
        self.products = []


class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, product: str):
        node = self.root
        for char in product:
            if char not in node.children:
                node.children[char] = Node()
            node = node.children[char]
            node.products.append(product)

    def search(self, searchWord: str):
        node = self.root
        res = []
        for char in searchWord:
            if char not in node.children:
                node = Node()
            else:
                node = node.children[char]
            res.append(node.products[:3])
        return res


class Solution:
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        products = sorted(products)
        trie = Trie()
        for p in products:
            trie.insert(p)
        result = trie.search(searchWord)
        return result

    def suggestedProductsBAOLI(self, products: List[str], searchWord: str) -> List[List[str]]:
        products = sorted(products)
        result = []
        prefix = ""
        for char in searchWord:
            prefix += char
            matches = [p for p in products if p.startswith(prefix)]
            result.append(matches[:3])
        return result

