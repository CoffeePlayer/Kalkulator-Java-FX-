package pl.coffee.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    private TextArea display;

    private char selectedOperator = ' ';
    private boolean go = true;
    private boolean addToDisplay = true;
    private double typedValue = 0;

    private String currentNumber = "";
    private double storedNumber = 0;
    private boolean operatorSelected = false;


    @FXML
    private void BACKBTAC() {
        String text = display.getText();
        if (text.length() > 0) {
            display.deleteText(text.length() - 1, text.length());
        } else {
            display.setText("0");
        }
    }

    @FXML
    private void CBTAC() {
        display.clear();
        display.setText("0");
    }

    @FXML
    private void DOTBTAC() {
        display.appendText(".");
    }

    @FXML
    private void XBTAC() {
        display.appendText(" x ");
    }

    @FXML
    private void PLUSBTAC() {
        display.appendText(" + ");
    }

    @FXML
    private void MINUSBTAC() {
        display.appendText(" - ");
    }

    @FXML
    private void DZIEBTAC() {
        display.appendText(" / ");
    }

    @FXML
    private void ZEROBTAC() {
        display.appendText("0");
    }

    @FXML
    private void ONEBTAC() {
        display.appendText("1");
    }

    @FXML
    private void TWOBTAC() {
        display.appendText("2");
    }

    @FXML
    private void THREEBTAC() {
        display.appendText("3");
    }

    @FXML
    private void FOURBTAC() {
        display.appendText("4");
    }

    @FXML
    private void FIVEBTAC() {
        display.appendText("5");
    }

    @FXML
    private void SIXBTAC() {
        display.appendText("6");
    }

    @FXML
    private void SEVENBTAC() {
        display.appendText("7");
    }

    @FXML
    private void EIGHTBTAC() {
        display.appendText("8");
    }

    @FXML
    private void NINEBTAC() {
        display.appendText("9");
    }

    public double calculate(double firstNumber, double secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            case '%':
                return firstNumber % secondNumber;
            case '^':
                return Math.pow(firstNumber, secondNumber);
            default:
                return secondNumber;
        }
    }

    @FXML
    private void ILEBTAC() {
        try {
            String expression = display.getText();
            String[] parts = expression.split(" ");
            if (parts.length == 3) {
                double firstNumber = Double.parseDouble(parts[0]);
                char operator = parts[1].charAt(0);
                double secondNumber = Double.parseDouble(parts[2]);

                double result = calculate(firstNumber, secondNumber, operator);
                display.setText(String.valueOf(result));
            } else {
                display.setText("Błąd");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            display.setText("Błąd");
        }
    }
}