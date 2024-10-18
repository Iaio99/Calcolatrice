package com.example.calcolatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class View {
    private final Controller controller = new Controller();
    @FXML
    private TextField display;
    private double firstOperand = 0;
    private String operator = "";

    @FXML
    private void handleButtonPress(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();

        if (buttonText.equals("C")) {
            display.clear();
            firstOperand = 0;
            operator = "";
        } else if (buttonText.equals("=")) {
            double secondOperand = Double.parseDouble(display.getText());
            Operation op = controller.doOperation(firstOperand, secondOperand, operator);
            display.setText(String.valueOf(op.getResult()));
            operator = ""; // Reset operator
        } else {
            if (isOperator(buttonText)) {
                firstOperand = Double.parseDouble(display.getText());
                operator = buttonText;
                display.clear();
            } else {
                display.appendText(buttonText);
            }
        }
    }

    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }
}