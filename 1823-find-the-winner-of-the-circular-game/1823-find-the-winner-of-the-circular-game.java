class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for(int i = 0;i < n;i++){
            list.add(i);
        }
        return winner(list,k,0) + 1;
    }
    public int winner(List<Integer> list,int k,int index){
        if(list.size() == 1){
            return list.get(0);
        }
        int removeindex = (index + k - 1) % list.size();
        list.remove(removeindex);
        return winner(list,k,removeindex);
    }
}