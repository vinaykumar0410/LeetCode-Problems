
// Tag - Medium

class Solution {
    public int maxProfitAssignment(int[] diff, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList();
        for(int i=0; i<diff.length; i++){
            list.add(new int[]{diff[i],profit[i]});
        }
        Collections.sort(list,(a,b)->Integer.compare(a[0],b[0]));
        // alternate way (a,b)-> a[0]-b[0]
        Arrays.sort(worker);
        int ans = 0;
        int maxProfit = 0;
        int j = 0;
        for(int i=0; i<worker.length; i++){
            while(j < list.size() && list.get(j)[0] <= worker[i]){
                maxProfit = Math.max(maxProfit,list.get(j)[1]);
                j++;
            }
            ans += maxProfit;
        }
        return ans;
    }
}