package com.example.calcolatrice;

public class Controller {
    private static double Addition(double a, double b) {
        return a + b;
    }

    private static double Subtraction(double a, double b) {
        return a - b;
    }

    private static double Multiplication(double a, double b) {
        return a * b;
    }

    private static double Division(double a, double b) {
        return a / b;
    }

    private static double Power(double a, double b) {
        return Math.pow(a, b);
    }

    public Operation doOperation(double a, double b, String operator) {
        Operation operation = new Operation(a, b);
        switch (operator) {
            case "+":
                operation.setResult(Addition(operation.getOperand1(), operation.getOperand2()));
                break;
            case "-":
                operation.setResult(Subtraction(operation.getOperand1(), operation.getOperand2()));
                break;
            case "*":
                operation.setResult(Multiplication(operation.getOperand1(), operation.getOperand2()));
                break;
            case "/":
                operation.setResult(Division(operation.getOperand1(), operation.getOperand2()));
                break;
            case "^":
                operation.setResult(Power(operation.getOperand1(), operation.getOperand2()));
                break;

        }
        return operation;
    }
}
