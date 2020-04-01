enum OPERATOR_PRIORITY {
    SUBTRACT(1), ADD(1), MULTIPLY(3), DIVIDE(3), EXPONENT(5), PARENTHESIS(6);
    public int value;
    OPERATOR_PRIORITY(int i){
        value = i;
    }
}