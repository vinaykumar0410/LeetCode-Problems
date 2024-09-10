
// Tag - Medium

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(ans[i],-1);
        }
        if(head == null){
            return ans;
        }
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = m-1;
        int colEnd = n-1;
        while(head != null && rowStart <= rowEnd && colStart <= colEnd){
            // move right
            for(int j=colStart; j<=colEnd; j++){
                if(head == null) break;
                ans[rowStart][j] = head.val;
                head = head.next;
            }
            rowStart++;
            
            // move down
            for(int i=rowStart; i<=rowEnd; i++){
                if(head == null) break;
                ans[i][colEnd] = head.val;
                head = head.next;
            }
            colEnd--;

            // move left
            if(colStart <= colEnd){
                for(int j=colEnd; j>=colStart; j--){
                    if(head == null) break;
                    ans[rowEnd][j] = head.val;
                    head = head.next;
                }
            }
            rowEnd--;
            
            // move top
            if(rowStart <= rowEnd){
                for(int i=rowEnd; i>=rowStart; i--){
                    if(head == null) break;
                    ans[i][colStart] = head.val;
                    head = head.next;
                }
            }
            colStart++;
            
        }
        return ans;
    }
}
