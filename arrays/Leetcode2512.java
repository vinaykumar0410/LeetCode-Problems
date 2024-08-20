
// Tag - Medium


// TAKES TIME BUT EASY 
class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // init ans list that stores students with more posivite feedback
        List<Integer> ans = new ArrayList();
        // to eliminate TEL use hashset for positive_feedback & negative_feedback
        Set<String> postives = new HashSet();
        for(String pos : positive_feedback) postives.add(pos);
        Set<String> negatives = new HashSet();
        for(String neg : negative_feedback) negatives.add(neg);
        // PriorityQueue uses custom sorting
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                // both students have same points(feedback) sort based on student_id
                if(Integer.compare(b[0],a[0]) == 0){
                    return Integer.compare(a[1],b[1]);
                }else{
                    // else sort based on points (feedback)
                    return Integer.compare(b[0],a[0]);
                }
            }
        );
        // traverse each student id and calculate points through respective report
        for(int i=0; i<student_id.length; i++){
            int points = 0;
            for(String word : report[i].split(" ")){
                // positive feedback increment points by 3
                if(postives.contains(word)){ // O(1)
                    points += 3;
                }
                // negative feedback decrement points by 1
                if(negatives.contains(word)){ // O(1)
                    points -= 1;
                }       
            }
            // add points & respective student_id
            pq.offer(new int[]{points,student_id[i]});
        }
        // filter only top k students with more points
        while(!pq.isEmpty()){
            if(k==0) break;
            k--;
            // add student_id to ans list
            ans.add(pq.poll()[1]);
        }
        return ans;
    }
}
// +3 -1

//    8 7 6  3
//    7 5 5 -1