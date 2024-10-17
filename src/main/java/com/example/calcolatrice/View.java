package com.example.calcolatrice;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class View {
    private final Controller controller = new Controller();
    @FXML
    private TextField display;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;
    private Button btnClear;
    private Button btnPower;
    private Button btnSqrt;
    private double firstOperand = 0;
    private String operator = "";

    public void initialize() {
        // Imposta gli eventi dei bottoni
        btn0.setOnAction(e -> appendToDisplay("0"));
        btn1.setOnAction(e -> appendToDisplay("1"));
        btn2.setOnAction(e -> appendToDisplay("2"));
        btn3.setOnAction(e -> appendToDisplay("3"));
        btn4.setOnAction(e -> appendToDisplay("4"));
        btn5.setOnAction(e -> appendToDisplay("5"));
        btn6.setOnAction(e -> appendToDisplay("6"));
        btn7.setOnAction(e -> appendToDisplay("7"));
        btn8.setOnAction(e -> appendToDisplay("8"));
        btn9.setOnAction(e -> appendToDisplay("9"));

        btnAdd.setOnAction(e -> setOperator("+"));
        btnSubtract.setOnAction(e -> setOperator("-"));
        btnMultiply.setOnAction(e -> setOperator("*"));
        btnDivide.setOnAction(e -> setOperator("/"));

        btnPower.setOnAction(e -> setOperator("^"));

        btnEquals.setOnAction(e -> calculate());
        btnClear.setOnAction(e -> clearDisplay());
    }

    private void appendToDisplay(String value) {
        display.setText(display.getText() + value);
    }

    private void setOperator(String op) {
        firstOperand = Double.parseDouble(display.getText());
        operator = op;
        display.clear();
    }

    @FXML
    protected void calculate() {
        double secondOperand = Double.parseDouble(display.getText());
        Operation operation = controller.doOperation(firstOperand, secondOperand, operator);
        double result = operation.getResult();
        display.setText(String.valueOf(result));
    }

    private void clearDisplay() {
        display.clear();
        operator = "";
    }
}