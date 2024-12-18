
def binary_search_equal(nums, target):
    left = 0
    right = len(nums) - 1
    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    return left


def binary_search_gt(nums, target):
    left = 0
    right = len(nums)
    while left < right:
        mid = (left + right) // 2
        if nums[mid] > target:
            right = mid
        else:
            left = mid + 1
    return left


def binary_search_gte(nums, target):
    left = 0
    right = len(nums)
    while left < right:
        mid = (left + right) // 2
        if nums[mid] >= target:
            right = mid
        else:
            left = mid + 1
    return left


def binary_search_lt(nums, target):
    left = 0
    right = len(nums) - 1
    while left < right:
        mid = (left + right + 1) // 2
        if nums[mid] >= target:
            right = mid - 1
        else:
            left = mid
    return left


def binary_search_lte(nums, target):
    left = 0
    right = len(nums) - 1
    while left < right:
        mid = (left + right + 1) // 2
        if nums[mid] > target:
            right = mid - 1
        else:
            left = mid
    return left


if __name__ == '__main__':
    test_arr = [1, 2, 3, 3, 4, 6]
    target = 1
    res = binary_search_lt(test_arr, target)
    print(res)
