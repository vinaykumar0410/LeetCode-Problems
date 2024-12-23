
# Tag - Medium

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        write = 1
        cnt = 1
        for read in range(1, len(nums)):
            # found duplicate cnt it else reset to 1
            if nums[read] == nums[read-1]:
                cnt += 1
            else:
                cnt = 1
            # 2 duplicates allowed so fill them
            if cnt <= 2:
                nums[write] = nums[read]
                write += 1
        return write
