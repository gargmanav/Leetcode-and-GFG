class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0,ten = 0;
        for(int i = 0;i<n;i++){
            if(bills[i] == 5){
                five += 5;
            }
            else if(bills[i] == 10){
                if(five > 0){
                    five -= 5;
                    ten += 10;
                }else return false;
            }else {
                if(five > 0 && ten > 0){
                    ten -= 10;
                    five -= 5;
                }else if(five >= 15){
                    five -= 15;
                }else return false;
            }
        }
        return true;
    }
}