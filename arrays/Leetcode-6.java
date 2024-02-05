
class Solution {
    public String convert(String s, int numRows) {
        // edge case
        if(numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }

        boolean goingDown = true;
        int row = 0;
        int index = 0;
        while(index < s.length()){
            char ch = s.charAt(index++);

            rows[row].append(ch);

            if(goingDown){
                row++;
            }else{
                row--;
            }

            if(row == 0 || row == numRows-1){
                goingDown = !goingDown;
            }
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder str : rows){
            ans.append(str);
        }

        return ans.toString();
    }
}


/*

// Using HashMap

class Solution {
    public String convert(String s, int numRows) {
        // edge case
        if(numRows == 1) return s;

        Map<Integer,String> map = new HashMap();
        int row = 0;
        boolean increase = true;

        for(char ch : s.toCharArray()){

            String currentString = map.getOrDefault(row,"");
            map.put(row,currentString+ch);
            
            if(increase){
                row++;

                if(row == numRows-1){
                    increase = false;
                } 
            }else{
                row--;

                if(row == 0){
                    increase = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int currentRow : map.keySet()){
            sb.append(map.get(currentRow));
        }
        
        return sb.toString();
    }
}

*/