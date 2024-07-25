
// Tag - Hard

class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        // interestingly for the 1st time im storing ordered map in stack
        Stack<TreeMap<String,Integer>> stack = new Stack();
        // by default push map object (as formula never start with opening parenthesis)
        stack.push(new TreeMap<>());
        int i = 0;
        // traverse each character in the formula
        while(i < n){
            char ch = formula.charAt(i);
            // found opening parenthesis? push map object
            if(ch == '('){
                stack.push(new TreeMap<>());
                i++;
            }else if(ch == ')'){ // found closing?
                i++;
                // after every closing we have some cnt so cnt it
                int cnt = 0;
                // loop until we found non digit char and calculate count
                while(i < n && Character.isDigit(formula.charAt(i))){
                    cnt = cnt*10 + formula.charAt(i)-'0';
                    i++;
                }
                // if there is no count then cnt it as 1
                if(cnt==0) cnt = 1;
                // poll out peek object from stack and multiple cnt with existing cnt
                TreeMap<String,Integer> top = stack.pop();
                for(String key : top.keySet()){
                    top.put(key,top.get(key)*cnt);
                }
                // after multiplying update stack's peek cnt + multiplied cnt
                for(String key : top.keySet()){
                    stack.peek().put(key,stack.peek().getOrDefault(key,0)+top.get(key));
                }
            }else{
                // no open or close parenthesis? definitely it will an atom
                StringBuilder atom = new StringBuilder();
                atom.append(ch);
                i++;
                // loop until digit found
                while(i < n && Character.isLowerCase(formula.charAt(i))){
                    atom.append(formula.charAt(i));
                    i++;
                }
                // found digit calculate cnt
                int cnt = 0;
                while(i < n && Character.isDigit(formula.charAt(i))){
                    cnt = cnt*10 + formula.charAt(i)-'0';
                    i++;
                }
                // if there is no count then cnt it as 1
                if(cnt==0) cnt = 1;
                // update atom and its cnt
                stack.peek().put(atom.toString(),stack.peek().getOrDefault(atom.toString(),0)+cnt);
            }
        }
        // stack only contains one map with atoms & cnt
        StringBuilder ans = new StringBuilder();
        for(String atom : stack.peek().keySet()){
            ans.append(atom);
            int cnt = stack.peek().get(atom);
            if(cnt > 1){
                ans.append(cnt);
            }
        }
        return ans.toString();
    }
}