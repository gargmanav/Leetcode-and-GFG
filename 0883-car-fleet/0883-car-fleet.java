class Solution {
    class Pair{
        int pos;
        float time;
        Pair(int pos,float time){
           this.pos = pos;
           this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pair = new Pair[n];
        for(int i = 0;i<n;i++){
            pair[i] = new Pair(position[i], (float)(target - position[i]) / (float)speed[i]);
        }
        Stack<Float> st = new Stack<>();
        Arrays.sort(pair,(a,b)->b.pos - a.pos);
        for(int i = 0;i<n;i++){
            float time = pair[i].time;
            while(st.isEmpty() || time > st.peek()){
                st.add(time);
            }
            
        }
        return st.size();
    }
}