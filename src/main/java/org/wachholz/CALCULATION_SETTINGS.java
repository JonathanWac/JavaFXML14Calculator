package org.wachholz;
import javafx.fxml.FXML;


enum OPERATOR_PRIORITY {
    SUBTRACT(1), ADD(1), MULTIPLY(3), DIVIDE(3), EXPONENT(5), PARENTHESIS(6);
    public int value;
    OPERATOR_PRIORITY(int i){
        value = i;
    }
}

enum CALCULATION_MODE{
    HEXADECIMAL("Hexadecimal"), DECIMAL("Decimal"), OCTAL("Octal"), BINARY("Binary");
    public String value;
    CALCULATION_MODE(String i){
        value = i;
    }

}