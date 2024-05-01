
// Tag - Easy
class Solution {
    public int maximum69Number (int num) {
        // convert input num -> String -> char array
        char[] arr = String.valueOf(num).toCharArray();
        // iterate over char array
        for(int i=0; i<arr.length; i++){
            // found 6 replace it by 9 and exit loop
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        // convert char array -> String -> Integer
        return Integer.parseInt(new String(arr));
    }
}