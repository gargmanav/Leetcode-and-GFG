
class Solution {
    static class Pair{
        Node root;
        int level;
        Pair(Node root,int level){
            this.root = root;
            this.level = level;
        }
    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)return result;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root,0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!que.isEmpty()){
            int len = que.size();
            for(int i = 0;i<len;i++){
                Pair curr = que.poll();
                if(!map.containsKey(curr.level)){
                    map.put(curr.level,curr.root.data);
                }
                if(curr.root.left != null){
                    que.add(new Pair(curr.root.left,curr.level - 1));
                }
                if(curr.root.right != null){
                    que.add(new Pair(curr.root.right,curr.level + 1));
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
}