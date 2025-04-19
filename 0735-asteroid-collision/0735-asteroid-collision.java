class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>(); // use list as stack 
        for(int asteroid : asteroids){
            if(asteroid>0) list.add(asteroid);
            else{
                while(list.size()!=0 && list.get(list.size()-1)>0 && list.get(list.size()-1)<Math.abs(asteroid)){
                    list.remove(list.size()-1); //if collision happens, destroy asteroid. 
                }
                if(list.size()!=0 && list.get(list.size()-1)==Math.abs(asteroid)) list.remove(list.size()-1);
                else if(list.size()==0 || list.get(list.size()-1)<0) list.add(asteroid);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}