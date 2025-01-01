class Solution {
    private boolean isNumeric(String str){
        try{
           Integer.parseInt(str);
           return true;
        }catch(NumberFormatException e){
           return false;
        }
    }
    


    public int evalRPN(String[] tokens) {
         Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+",(a,b)->a+b);
        operations.put("-",(a,b)->a-b);
        operations.put("/",(a,b)->a/b);
        operations.put("*",(a,b)->a*b);

        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(isNumeric(str)){
                st.push(Integer.parseInt(str));
            }else{
                int b = st.pop();
                int a = st.pop();
                int res = operations.get(str).apply(a,b);
                st.push(res);
            }
        }
       return st.pop();
    }
}