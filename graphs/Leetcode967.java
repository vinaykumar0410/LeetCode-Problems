
// Tag - Medium

// dfs
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList();
        // lets build possible numbers with k difference
        // ofcourse 1st digit will be from 1-9
        for(int num=1; num<=9; num++){
            // check for 2nd digit
            dfs(num,n-1,k,list);
        }
        // convert list to int array
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    // dfs to find next digits
    void dfs(int num,int n,int k,List<Integer> list){
        // when n digits are formed add to list and return
        if(n == 0){
            list.add(num);
            return;
        }
        // take out last digit
        int lastDigit = num%10;
        // if the sum of last digit & k less than or equals 9 
        // yeah found next digit
        if(lastDigit + k <= 9){
            // check for another digit
            dfs(num*10 + lastDigit + k, n-1, k, list);
        }
        // if the diff of last digit & k greater than or equals 0 
        // yeah found next digit
        if(k != 0 && lastDigit - k >= 0){
            // check for another digit
            dfs(num*10 + lastDigit - k, n-1, k, list);
        }
    }
}

// bfs
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList();
        Queue<Integer> q = new LinkedList();
        for(int i=1; i<=9; i++) q.offer(i);
        int level = 1;
        while(!q.isEmpty() && level < n){
            level++;
            int size = q.size();
            for(int i=0; i<size; i++){
                int num = q.poll();
                int lastDigit = num%10;
                if(lastDigit+k <= 9) q.offer(num*10 + lastDigit+k);
                if(k != 0 && lastDigit-k >= 0) q.offer(num*10 + lastDigit-k);
            }
        }
        while(!q.isEmpty()){
            list.add(q.poll());
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}