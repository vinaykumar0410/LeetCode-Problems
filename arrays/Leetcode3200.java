
// Tag - Easy

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        // there are 2 cases starting with blue or with red can form more height
        int case1 = maxHeight(red,blue);
        int case2 = maxHeight(blue,red);
        return Math.max(case1,case2);
    }
    private int maxHeight(int a,int b){
        int height = 0;
        int rows = 1;
        boolean flag = true;
        while(true){
            if(flag){
                a -= rows;
            }else{
                b -= rows;
            }
            if(a < 0 || b < 0) break;
            flag = !flag;
            rows++;
            height++;
        }
        return height;
    }
}