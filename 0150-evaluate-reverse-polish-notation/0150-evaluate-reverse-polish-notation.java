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
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(isNumeric(str)){
                st.push(Integer.parseInt(str));
            }else{
                int b = st.pop();
                int a = st.pop();
                switch (str){
                    case "+":
                    st.push(a+b);
                    break;
                    case "-":
                    st.push(a-b);
                    break;
                    case "*":
                    st.push(a*b);
                    break;
                    case "/":
                    st.push(a/b);
                    break;
                }
            }
        }
       return st.pop();
    }
}