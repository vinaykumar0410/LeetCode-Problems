
# Tag - Easy

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        '''
        kingdoms = [2,2,1,1,1,2,2] where 1, 2 are kings
        2nd king is ruling many kingdoms (4/7 kingdoms he is ruling)
        He is One we are looking for
        '''
        # Moore Voting Algorithm
        king = nums[0] 
        freq = 1
        for i in range(1, len(nums)):
            if freq == 0:
                king = nums[i] # new king
            if king == nums[i]:
                freq += 1
            else:
                freq -= 1
        return king
            
