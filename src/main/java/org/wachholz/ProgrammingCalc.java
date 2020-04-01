package org.wachholz;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class ProgrammingCalc {
    public TextArea calculationBox1, calculationBox2;
    public ToggleButton hexToggleButton, decimalToggleButton, octalToggleButton, binaryToggleButton;
    public Text hexText, decimalText, octalText, binaryText;
    public Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF,
            buttonNum0, buttonNum1, buttonNum2, buttonNum3, buttonNum4, buttonNum5,
            buttonNum6, buttonNum7, buttonNum8, buttonNum9;
    public Button buttonMod, buttonClearE, buttonClear, buttonBack,
            buttonDivide, buttonMultiply, buttonSubtract, buttonAdd,
            buttonOpenParenthesis, buttonCloseParenthesis, buttonChangeSign, buttonDecimal, buttonEquals;
    public String displayCalculationString1, displayCalculationString2, calculationMode;
    public StringBuilder calculationString = new StringBuilder();


    public void buttonAPressed(ActionEvent actionEvent) {
        System.out.println("Button A pressed");
    }

    public void buttonBPressed(ActionEvent actionEvent) {
        System.out.println("Button B pressed");
    }

    public void buttonCPressed(ActionEvent actionEvent) {
        System.out.println("Button C pressed");
    }

    public void buttonDPressed(ActionEvent actionEvent) {
        System.out.println("Button D pressed");
    }

    public void buttonEPressed(ActionEvent actionEvent) {
        System.out.println("Button E pressed");
    }

    public void buttonFPressed(ActionEvent actionEvent) {
        System.out.println("Button F pressed");
    }

    public void buttonNum0Pressed(ActionEvent actionEvent) {
        System.out.println("Button 0 pressed");
    }

    public void buttonNum1Pressed(ActionEvent actionEvent) {
        System.out.println("Button 1 pressed");
        calculationString.append("1");
        calculationBox1.setText(calculationString.toString());
    }

    public void buttonNum2Pressed(ActionEvent actionEvent) {
        System.out.println("Button 2 pressed");
        calculationString.append("2");
        calculationBox1.setText(calculationString.toString());
    }

    public void buttonNum3Pressed(ActionEvent actionEvent) {
        System.out.println("Button 3 pressed");
        calculationString.append("3");
        calculationBox1.setText(calculationString.toString());
    }

    public void buttonNum4Pressed(ActionEvent actionEvent) {
        System.out.println("Button 4 pressed");
        calculationString.append("4");
        calculationBox1.setText(calculationString.toString());
    }

    public void buttonNum5Pressed(ActionEvent actionEvent) {
        System.out.println("Button 5 pressed");
        calculationString.append("5");
        calculationBox1.setText(calculationString.toString());
    }

    public void buttonNum6Pressed(ActionEvent actionEvent) {
        System.out.println("Button 6 pressed");
    }

    public void buttonNum7Pressed(ActionEvent actionEvent) {
        System.out.println("Button 7 pressed");
    }

    public void buttonNum8Pressed(ActionEvent actionEvent) {
        System.out.println("Button 8 pressed");
    }

    public void buttonNum9Pressed(ActionEvent actionEvent) {
        System.out.println("Button 9 pressed");
    }

    public void buttonDividePressed(ActionEvent actionEvent) {
        System.out.println("Button / pressed");
    }

    public void buttonMultiplyPressed(ActionEvent actionEvent) {
        System.out.println("Button X pressed");
    }

    public void buttonSubtractPressed(ActionEvent actionEvent) {
        System.out.println("Button - pressed");
    }

    public void buttonAddPressed(ActionEvent actionEvent) {
        System.out.println("Button + pressed");
    }

    public void buttonOpenParenthesisPressed(ActionEvent actionEvent) {
        System.out.println("Button ( pressed");
    }

    public void buttonCloseParenthesisPressed(ActionEvent actionEvent) {
        System.out.println("Button ) pressed");
    }

    public void buttonChangeSignPressed(ActionEvent actionEvent) {
        System.out.println("Button +/- pressed");
    }

    public void buttonEqualsPressed(ActionEvent actionEvent) {
        System.out.println("Button = pressed");
    }

    public void buttonDecimalPressed(ActionEvent actionEvent) {
        System.out.println("Button . pressed");
    }

    public void buttonModPressed(ActionEvent actionEvent) {
        System.out.println("Button mod pressed");
    }

    public void buttonClearEPressed(ActionEvent actionEvent) {
        System.out.println("Button ClearE pressed");
    }

    public void buttonClearPressed(ActionEvent actionEvent) {
        System.out.println("Button Clear pressed");
    }

    public void buttonBackPressed(ActionEvent actionEvent) {
        System.out.println("Button Back pressed");
    }

    public void hexToggleButtonPressed(ActionEvent actionEvent) {
        decimalToggleButton.setSelected(false);
        octalToggleButton.setSelected(false);
        binaryToggleButton.setSelected(false);
        hexToggleButton.setSelected(true);

        buttonA.setDisable(false);
        buttonB.setDisable(false);
        buttonC.setDisable(false);
        buttonD.setDisable(false);
        buttonE.setDisable(false);
        buttonF.setDisable(false);
        buttonNum0.setDisable(false);
        buttonNum1.setDisable(false);
        buttonNum2.setDisable(false);
        buttonNum3.setDisable(false);
        buttonNum4.setDisable(false);
        buttonNum5.setDisable(false);
        buttonNum6.setDisable(false);
        buttonNum7.setDisable(false);
        buttonNum8.setDisable(false);
        buttonNum9.setDisable(false);
    }

    public void decimalToggleButtonPressed(ActionEvent actionEvent) {
        decimalToggleButton.setSelected(true);
        octalToggleButton.setSelected(false);
        binaryToggleButton.setSelected(false);
        hexToggleButton.setSelected(false);

        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonE.setDisable(true);
        buttonF.setDisable(true);
        buttonNum0.setDisable(false);
        buttonNum1.setDisable(false);
        buttonNum2.setDisable(false);
        buttonNum3.setDisable(false);
        buttonNum4.setDisable(false);
        buttonNum5.setDisable(false);
        buttonNum6.setDisable(false);
        buttonNum7.setDisable(false);
        buttonNum8.setDisable(false);
        buttonNum9.setDisable(false);
    }

    public void octalToggleButtonPressed(ActionEvent actionEvent) {
        decimalToggleButton.setSelected(false);
        octalToggleButton.setSelected(true);
        binaryToggleButton.setSelected(false);
        hexToggleButton.setSelected(false);

        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonE.setDisable(true);
        buttonF.setDisable(true);
        buttonNum0.setDisable(false);
        buttonNum1.setDisable(false);
        buttonNum2.setDisable(false);
        buttonNum3.setDisable(false);
        buttonNum4.setDisable(false);
        buttonNum5.setDisable(false);
        buttonNum6.setDisable(false);
        buttonNum7.setDisable(false);
        buttonNum8.setDisable(true);
        buttonNum9.setDisable(true);
    }

    public void binaryToggleButtonPressed(ActionEvent actionEvent) {
        decimalToggleButton.setSelected(false);
        octalToggleButton.setSelected(false);
        binaryToggleButton.setSelected(true);
        hexToggleButton.setSelected(false);

        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonE.setDisable(true);
        buttonF.setDisable(true);
        buttonNum0.setDisable(false);
        buttonNum1.setDisable(false);
        buttonNum2.setDisable(true);
        buttonNum3.setDisable(true);
        buttonNum4.setDisable(true);
        buttonNum5.setDisable(true);
        buttonNum6.setDisable(true);
        buttonNum7.setDisable(true);
        buttonNum8.setDisable(true);
        buttonNum9.setDisable(true);
    }

    public void calculationBox1Pressed(MouseEvent mouseEvent) {
    }

    public void calculationBox2Pressed(MouseEvent mouseEvent) {

    }
}
