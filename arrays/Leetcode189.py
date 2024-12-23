
# Tag - Medium

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(l, r, nums):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
        n = len(nums)
        k %= n
        reverse(0, n-k-1, nums)
        reverse(n-k, n-1, nums)
        reverse(0, n-1, nums)