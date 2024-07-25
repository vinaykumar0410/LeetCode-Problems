
// Tag - Medium

class Solution {
    public int numberOfBeams(String[] bank) {
        // total laser beams
        int laserBeams = 0;
        // keep track of previous row devices
        int prev = 0;
        for(String row : bank){
            // keep track of current row devices
            int curr = getDevices(row);
            // no devices found nothing to do
            if(curr == 0){
                continue;
            }
            // calculate possible beams (when 2 rows have devices)
            if(prev != 0){
                laserBeams += curr * prev;
            }
            // update previous with current
            prev = curr;
        }
        // return laser beams count
        return laserBeams;
    }
    int getDevices(String row){
        // devices keep track of devices count
        int devices = 0;
        for(int i=0; i<row.length(); i++){
            // increment devices if char found to be 1
            if(row.charAt(i) == '1'){
                devices++;
            }
        }
        return devices;
    }
}
