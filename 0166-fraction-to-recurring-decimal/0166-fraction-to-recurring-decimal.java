class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder str = new StringBuilder();
        if((numerator < 0) ^ (denominator < 0)){
            str.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        str.append(num / den);
        num %= den;
        if(num == 0)return str.toString();
        str.append(".");
        
        Map<Long,Integer> map = new HashMap<>();
        while(num != 0){
            if(map.containsKey(num)){
                str.insert(map.get(num),"(");
                str.append(')');
                break;
            }
            map.put(num,str.length());
            num *= 10;
            str.append(num/den);
            num %= den;
        }
        return str.toString();
}
}