
// Tag - Medium

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        int n = chalk.length;
        // try to minimise k 
        long sum = 0;
        for(int ch : chalk) sum += ch;
        k %= sum;
        while(k > 0){
            if(chalk[i] <= k){
                k -= chalk[i];
                i++;
                i %= n;
            }else{
                break;
            }
        }
        return i;
    }
}