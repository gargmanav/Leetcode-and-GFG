class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        int left = 0;
        StringBuilder str = new StringBuilder();
        for(int right = 0;right < n;right++){
            str.append(s.charAt(right));
            if(str.length() == k){
                res.add(str.toString());
                str.delete(0,k);
                left += k;
            }
        }
        if(str.length() > 0){
            int requiredfill = k - str.length();
        for(int i = 0;i<requiredfill;i++){
            str.append(fill);
        }
        if(requiredfill > 0){
            res.add(str.toString());
        }
        }
        return res.toArray(new String[0]);
    }
}