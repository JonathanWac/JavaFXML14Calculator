import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculationsDoubleInfixPostfix {
    private double lastSum;

    public CalculationsDoubleInfixPostfix() {
        this.lastSum = 0;
    }
    private static final String regExp = "[\\x00-\\x20]*[+-]?(((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";
    private static final Pattern pattern = Pattern.compile(regExp);

    public static boolean isDouble(String s) { //Fastest isDouble method according to StackExchange
        Matcher m = pattern.matcher(s);
        return m.matches();
    }

    public LinkedList<String> toPostFix(String[] origEquation){
        LinkedList<String> postFixEquation = new LinkedList<>();
        Stack<String>   operatorStack = new Stack<>();
        int parenthStackIndex = 0;
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //  Rules:                                                                                                       //
        //      If pushing ) onto stack, pop everything onto stack in reverse order that is in between                   //
        //              the ( )                                                                                          //
        //      When pushing other operators onto stack, if there is another operator with                               //
        //          Greater than / Equal priority already on stack,only after the last ( , you must pop that element off //
        //                                                                                                               //
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < origEquation.length; i++){
            String element = origEquation[i];
            if (isDouble(element)){ // Is double number
                postFixEquation.add(element);
            }else if (element.equals("(")){// Is Parentheses
                operatorStack.add(element);
                parenthStackIndex = operatorStack.size()-1;
            }else if (element.equals(")")){// Is Parentheses
                popUntilParenthesis(postFixEquation, operatorStack);
            }else if (element.equals("^")){// Exponent
                checkOpPriorityOnStack(postFixEquation, operatorStack, element, OPERATOR_PRIORITY.EXPONENT);
            }else if (element.equals("*")){// Multiply
                checkOpPriorityOnStack(postFixEquation, operatorStack, element, OPERATOR_PRIORITY.MULTIPLY);
            }else if (element.equals("/")){// Divide
                checkOpPriorityOnStack(postFixEquation, operatorStack, element, OPERATOR_PRIORITY.DIVIDE);
            }else if (element.equals("+")){// Add
                checkOpPriorityOnStack(postFixEquation, operatorStack, element, OPERATOR_PRIORITY.ADD);
            }else if (element.equals("-")){// Sub
                checkOpPriorityOnStack(postFixEquation, operatorStack, element, OPERATOR_PRIORITY.SUBTRACT);
            }
        }
        for (int i = operatorStack.size(); i > 0; i--){
            postFixEquation.add(operatorStack.pop());
        }
        return postFixEquation;
    }
    private void popUntilParenthesis(LinkedList<String> postFixEquation, Stack<String> operatorStack){

        for (int j = operatorStack.size()-1; j >= 0; j--){
            String element2 = operatorStack.get(j);
            if (element2.equals("(")){
                operatorStack.remove(j);
                break;
            }
            else if (element2.equals("^")){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("*")){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("/")){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("+")){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("-")){
                postFixEquation.add(operatorStack.remove(j));
            }
        }
    }
    private void checkOpPriorityOnStack(LinkedList<String> postFixEquation, Stack<String> operatorStack, String element, OPERATOR_PRIORITY operator_priority) {
        int priority = operator_priority.value;
        for (int j = operatorStack.size()-1; j >= 0; j--){
            String element2 = operatorStack.get(j);
            if (element2.equals("(")){
                break;
            }
            else if (element2.equals("^") && priority <= OPERATOR_PRIORITY.EXPONENT.value){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("*") && priority <= OPERATOR_PRIORITY.MULTIPLY.value){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("/")&& priority <= OPERATOR_PRIORITY.MULTIPLY.value){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("+")&& priority <= OPERATOR_PRIORITY.ADD.value){
                postFixEquation.add(operatorStack.remove(j));
            }
            else if (element2.equals("-")&& priority <= OPERATOR_PRIORITY.SUBTRACT.value){
                postFixEquation.add(operatorStack.remove(j));
            }
        }
        operatorStack.add(element);
    }

    public LinkedList<String> calcPostFix(LinkedList<String> postFixEquation){
        double sum =0.0, a = 0.0, b = 0.0;
        while (postFixEquation.size()>1){
            for (int i = 2; i < postFixEquation.size(); i++){
                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Starts at the 3rd element in list, because you must have 2 operands infront of an operation  //
                //i is the index of c:(^ * / + -)                                                              //
                // i-2 = a, i-1 = b                                                                            //
                //  sum = a  operand(c)  b                                                                     //
                /////////////////////////////////////////////////////////////////////////////////////////////////
                String element = postFixEquation.get(i);
                if (isDouble(element)){ // Is double number
                    //
                    //
                    //
                }else if (element.equals("^")){// Exponent
                    a = Double.parseDouble(postFixEquation.get(i-2));
                    b = Double.parseDouble(postFixEquation.get(i-1));
                    //Need a check here for negative a values to a fractional exponent I.E. (-5)^(1/2)
                    //  !!!
                    sum = Math.pow(a, b);
                    if (Double.isNaN(sum)){
                        LinkedList<String> list = new LinkedList<String>();
                        list.add("Err: Performing an Exponential Calculation");
                        list.add("NaN");
                        list.add(postFixEquation.get(i-2)+" ^ "+postFixEquation.get(i-1));
                        return list;
                    }
                    postFixEquation.remove(i);      //Remove pos 3
                    postFixEquation.remove(i-1);  //Remove pos 2
                    postFixEquation.set(i-2, String.valueOf(sum));  //Set pos 1 to new sum
                    break;
                }else if (element.equals("*")){// Multiply
                    a = Double.parseDouble(postFixEquation.get(i-2));
                    b = Double.parseDouble(postFixEquation.get(i-1));
                    sum = a * b;
                    postFixEquation.remove(i);      //Remove pos 3
                    postFixEquation.remove(i-1);  //Remove pos 2
                    postFixEquation.set(i-2, String.valueOf(sum));  //Set pos 1 to new sum
                    break;
                }else if (element.equals("/")){// Divide
                    a = Double.parseDouble(postFixEquation.get(i-2));
                    b = Double.parseDouble(postFixEquation.get(i-1));
                    if (b == 0){
                        LinkedList<String> list = new LinkedList<String>();
                        list.add("Err: Div by 0");
                        list.add("NaN");
                        return list;
                    }
                    sum = a / b;
                    postFixEquation.remove(i);      //Remove pos 3
                    postFixEquation.remove(i-1);  //Remove pos 2
                    postFixEquation.set(i-2, String.valueOf(sum));  //Set pos 1 to new sum
                    break;
                }else if (element.equals("+")){// Add
                    a = Double.parseDouble(postFixEquation.get(i-2));
                    b = Double.parseDouble(postFixEquation.get(i-1));
                    sum = a + b;
                    postFixEquation.remove(i);      //Remove pos 3
                    postFixEquation.remove(i-1);  //Remove pos 2
                    postFixEquation.set(i-2, String.valueOf(sum));  //Set pos 1 to new sum
                    break;
                }else if (element.equals("-")){// Sub
                    a = Double.parseDouble(postFixEquation.get(i-2));
                    b = Double.parseDouble(postFixEquation.get(i-1));
                    sum = a - b;
                    postFixEquation.remove(i);      //Remove pos 3
                    postFixEquation.remove(i-1);  //Remove pos 2
                    postFixEquation.set(i-2, String.valueOf(sum));  //Set pos 1 to new sum
                    break;
                }
            }
        }
        return postFixEquation;
    }
    public LinkedList<String> getNewSum(String[] origEquation){
        return calcPostFix(toPostFix(origEquation));
    }
}
