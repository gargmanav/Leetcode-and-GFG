class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1] - a[1]);
        for(int i = 0;i < 26;i++){
            if(freq[i] > 0){
                pq.add(new int[]{i,freq[i]});
            }
        }
    Queue<int[]> que = new LinkedList<>();
    int time = 0;
    while(!pq.isEmpty() || !que.isEmpty()){
        time++;
        if(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currfreq = curr[1] - 1;
            if(currfreq > 0){
                que.add(new int[]{curr[0],currfreq,time + n});
            }
        }

        if(!que.isEmpty() && que.peek()[2] == time){
            int[] curr = que.poll();
            pq.add(new int[]{curr[0],curr[1]});
        }
    }
    return time;
    }
}