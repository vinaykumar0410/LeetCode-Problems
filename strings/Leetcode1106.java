
// Tag - Hard

class Solution {
    int i = 0;
    public boolean parseBoolExpr(String expression) {
        char ch = expression.charAt(i++);

        // base case
        if(ch == 't') return true;
        if(ch == 'f') return false;

        // found !
        if(ch == '!'){
            i++; // found ( move forward
            boolean res = !parseBoolExpr(expression);
            i++; // found ) move forward
            return res;
        }

        // for & | need to evaluate all the boolean values inside ()
        List<Boolean> list = new ArrayList();
        i++; // found ( move forward
        while(expression.charAt(i) != ')'){
            if(expression.charAt(i) != ','){
                list.add(parseBoolExpr(expression));
            }else{
                i++;
            }
        }
        i++; // found ) move forward

        // found &
        if(ch == '&'){
            for(Boolean value : list){
                if(!value) return false;
            }
            return true;
        }

        // found |
        if(ch == '|'){
             for(Boolean value : list){
                if(value) return true;
            }
            return false;
        }

        return false;
    }
}