class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int n = candyType.length;
        for(int i = 0;i<n;i++){
            set.add(candyType[i]);
        }
        if(set.size() < n/2)return set.size();
        return n/2;
    }
}