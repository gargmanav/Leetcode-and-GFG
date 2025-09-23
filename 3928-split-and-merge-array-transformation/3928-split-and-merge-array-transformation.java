class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        List<Integer> start = new ArrayList<>();
        for(int num : nums1)start.add(num);
        List<Integer> target = new ArrayList<>();
        for(int num : nums2)target.add(num);
        if(start.equals(target))return 0;
        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        q.add(start);
        set.add(start);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                List<Integer> curr = q.poll();
                if(curr.equals(target))return moves;
                for(int l = 0;l < n;l++){
                    for(int r = l;r < n;r++){
                        List<Integer> cut = new ArrayList<>(curr.subList(l,r + 1));
                        List<Integer> remaining = new ArrayList<>();
                        remaining.addAll(curr.subList(0,l));
                        remaining.addAll(curr.subList(r + 1,n));
                        for(int pos = 0;pos < remaining.size();pos++){
                            if(pos == l)continue;
                            List<Integer> list = new ArrayList<>(remaining);
                            list.addAll(pos,cut);
                            if(set.add(list))q.add(list);
                        }
                    }
                }
                size--;
            }
            moves++;
        }
        return moves;
    }
}