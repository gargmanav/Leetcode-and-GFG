class Solution {
    
    class Pair{
        char ch;
        int freq;
        Pair(char ch,int freq){
           this.ch = ch;
           this.freq = freq; 
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
           map.put(c,map.getOrDefault(c,0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (p1, p2) -> p2.freq - p1.freq        // descending order
        );
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            pq.add(new Pair(e.getKey(),e.getValue()));
            if(e.getValue() > (s.length() + 1 )/2)return "";
        }
        
        StringBuilder str = new StringBuilder();
        while(pq.size() >= 2){
            Pair max = pq.poll();
            Pair curr = pq.poll();
            
            str.append(max.ch);
            str.append(curr.ch);

            if(--max.freq > 0)pq.add(max);
            if(--curr.freq > 0)pq.add(curr);
        }
        if(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(curr.freq >=2)return "";
            str.append(curr.ch);
        }
        return str.toString();
    }
}