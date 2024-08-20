
// Tag - Easy

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0; // 10
        int ten = 0; // 
        for(int bill : bills){
            // found 5 just cnt just
            if(bill == 5){
                five++;
            }else if(bill == 10){ // found 10
                // can't give change without 5
                if(five == 0){
                    return false;
                }else{ // give him change of 5 and cnt 10
                    five--;
                    ten++;
                }
            }else{
                // found twenty and we have atleast 1 ten 1 five (10+5)
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five > 2){ // 0 tens but we have more than 2 five
                    five -= 3;
                }    
                else{ // we don't have sufficent 5 or 10 to give change
                    return false;
                }
            }
        }
        // if none of the above false condition met we gave change to everyone
        return true;
    }
}
