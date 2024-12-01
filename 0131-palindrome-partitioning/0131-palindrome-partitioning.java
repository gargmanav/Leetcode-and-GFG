class Solution {
    public void findPartition(String s,int index,List<List<String>> ans,List<String> ds){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
               ds.add(s.substring(index,i+1));
               findPartition(s,i+1,ans,ds);
               ds.remove(ds.size() - 1);
            }
        }
    }
    

    public boolean isPalindrome(String s,int index,int end){
        while(index <= end){
            if(s.charAt(index++) != s.charAt(end--))return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        findPartition(s,0,ans,ds);
        return ans;
    }
}