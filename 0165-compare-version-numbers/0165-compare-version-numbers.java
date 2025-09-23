class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length();
        int n = version2.length();
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        for(int i = 0;i < Math.max(m,n);i++){
            int x = 0,y = 0;
            if(i < str1.length){
                x = Integer.parseInt(str1[i]);
            }
            if(i < str2.length){
                y = Integer.parseInt(str2[i]);
            }
            if(x < y)return -1;
            else if(x > y)return 1;
        }
        return 0;
    }
}