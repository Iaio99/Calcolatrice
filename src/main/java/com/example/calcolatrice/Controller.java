package com.example.calcolatrice;

public class Controller {
    private static double addition(double a, double b) {
        return a + b;
    }

    private static double subtraction(double a, double b) {
        return a - b;
    }

    private static double multiplication(double a, double b) {
        return a * b;
    }

    private static double division(double a, double b) {
        return a / b;
    }

    private static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public Operation doOperation(double a, double b, String operator) {
        Operation operation = new Operation(a, b);
        switch (operator) {
            case "+":
                operation.setResult(addition(operation.getOperand1(), operation.getOperand2()));
                break;
            case "-":
                operation.setResult(subtraction(operation.getOperand1(), operation.getOperand2()));
                break;
            case "*":
                operation.setResult(multiplication(operation.getOperand1(), operation.getOperand2()));
                break;
            case "/":
                operation.setResult(division(operation.getOperand1(), operation.getOperand2()));
                break;
            case "^":
                operation.setResult(power(operation.getOperand1(), operation.getOperand2()));
                break;
            default:
                break;
        }
        return operation;
    }
}
