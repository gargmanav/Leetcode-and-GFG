class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int day = events[0][0];
        int i = 0;
        int count = 0;

        int maxDay = 0;
        for(int[] event : events){
            maxDay = Math.max(maxDay,event[1]);
        }

        while(day <= maxDay){
            while(i < n && events[i][0] == day){
                pq.add(events[i][1]);
                i++;
            }

            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;
        }
        return count;
    }
}