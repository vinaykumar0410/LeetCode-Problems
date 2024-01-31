
// Tag - Easy
class MyQueue {

    // declare two stacks
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        // initialise two stacks
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int x) {
        // push all the elements to 2nd stack from 1st stack
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        // push x to 1st stack
        s1.push(x);
        // push back all the elements from 2nd stack to 1st stack
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        // just pop out from 1st stack
        return s1.pop();
    }
    
    public int peek() {
         // just peek from 1st stack
        return s1.peek();
    }
    
    public boolean empty() {
         // just check if 1st stack is empty
        return s1.isEmpty();
    }
}
