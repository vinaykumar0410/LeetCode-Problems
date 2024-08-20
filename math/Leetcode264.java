
// Tag - Easy

class Solution {
    public int nthUglyNumber(int n) {
        // init TreeSet and add 1L as base case
        TreeSet<Long> orderedSet = new TreeSet<>();
        orderedSet.add(1L);
        // keep track of nth ugly number (actual holds ans after iterating n times)
        Long curr = 1L;
        // traverse from 0-n
        for(int i=0; i<n; i++){
            // poll out the first element 
            curr = orderedSet.pollFirst();
            // for sure multiples of 2 3 5 are also ugly numbers
            orderedSet.add(curr*2);
            orderedSet.add(curr*3);
            orderedSet.add(curr*5);
        }
        // cast ans from Long to int
        return curr.intValue();
    }
}