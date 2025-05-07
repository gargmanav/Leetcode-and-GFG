class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer> map = new HashMap<>();
       
        int count = 0;
        for(char ch : chars.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(String str:words){
            Map<Character,Integer> curr = new HashMap<>();
           for(char ch : str.toCharArray()){
            curr.put(ch,curr.getOrDefault(ch,0)+1);
           }
           boolean check = true;
           for(char ch : str.toCharArray()){
            if (curr.get(ch) > map.getOrDefault(ch, 0)){
                check = false;
                break;
            }
        }
        if(check){
            count += str.length();
        }
        }
        return count;
    }
}