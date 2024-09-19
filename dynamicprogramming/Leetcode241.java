
// Tag - Medium

class Solution {
    Map<String, List<Integer>> cache = new HashMap();
    public List<Integer> diffWaysToCompute(String expression) {
        if(cache.containsKey(expression)){
            return cache.get(expression);
        }
        List<Integer> list = new ArrayList();
        // base cases
        if(expression.length() == 0){
            return list;
        }
        if(expression.length() <= 2){
            list.add(Integer.parseInt(expression));
            cache.put(expression, list);
            return list;
        }

        for(int i=0; i<expression.length(); i++){
            char ch = expression.charAt(i);
            // skip digits
            if(Character.isDigit(ch)) continue;
            List<Integer> left = diffWaysToCompute(expression.substring(0,i));
            List<Integer> right = diffWaysToCompute(expression.substring(i+1));
            for(int l : left){
                for(int r : right){
                    switch (ch) {
                        case '+' -> list.add(l+r);
                        case '-' -> list.add(l-r);
                        case '*' -> list.add(l*r);
                    }
                }
            }
        }
        cache.put(expression, list);
        return list;
    }
}