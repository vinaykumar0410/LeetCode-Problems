
// Tag - Easy

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> map = new HashMap();
        // populate map with freq of each string
        for(String string : arr){
            if(map.containsKey(string)){
                map.put(string,map.get(string)+1);
            }else{
                map.put(string,1);
            }
        }
        // {d-1 b-2 c-2 a-1}
        for(String key : arr){
            // found unique occurance decrement k
            if(map.get(key)==1){
                k--;
            }
            // return string when k becomes 0
            if(k==0){
                return key;
            } 
        }
        return "";
    }
}