
// Tag - Medium
class RandomizedSet {

    // declare list and map
    List<Integer> list;
    Map<Integer,Integer> map;
    // create random obj for getRandom method
    Random random = new Random();

    public RandomizedSet() {
        // initialise list and map
        list = new ArrayList<Integer>();
        map = new HashMap<Integer,Integer>();
    }
    
    public boolean insert(int val) {
        // return false if val already exists in map
        if(map.containsKey(val)) return false;
        // else put at list size position and add it to list
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        // return false if map doesn't contain val
        if(!map.containsKey(val)) return false;
        // else get that position
        int pos = map.get(val);
        // if the position is not the last index
        if(pos != list.size()-1){
            // need to swap element with last element
            // get last element from list
            int lastElement = list.get(list.size()-1);
            // set that element at pos we get
            list.set(pos,lastElement);
            // update map with last element at pos we get
            map.put(lastElement,pos);
        }
        // remove last element
        list.remove(list.size()-1);
        // remove that val from map
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        // nextInt method will generate a random index with in list size
        return list.get(random.nextInt(list.size()));
    }
}