
// Tag - Medium
class Solution {
    public String simplifyPath(String path) {
        // The path starts with a single slash '/'.
        // The path does not end with a trailing '/'.
        // '.' -> skip & '..' -> move back to previous dir

        // need a stack for moving to dir
        Stack<String> stack = new Stack<>();

        // splits string based on "/"
        String[] pathItems = path.split("\\/");

        // traverse string array 
        for(String pathItem : pathItems){
            if(pathItem.isEmpty() || pathItem.equals(".")){
                // skip it
                continue;
            }else{
                // something valid string found
                if(pathItem.equals("..")){
                    // move one level up (previous dir)
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    // push to stack as valid one found
                    stack.push(pathItem);
                }
            }
        }

        // to store canonical path
        StringBuilder sb = new StringBuilder();
        
        // add every element in stack at starting 
        while(!stack.isEmpty()){
            sb.insert(0,"/" + stack.pop());
        }

        // handle edge case
        if(sb.isEmpty()) return "/";
        return sb.toString();
    }
}