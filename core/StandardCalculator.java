package core;

public class StandardCalculator {

    private double firstNumber;
    private String operator;

    public void setFirstNumber(double num) {
        this.firstNumber = num;
    }

    public void setOperator(String op) {
        this.operator = op;
    }

    public double calculate(double secondNumber) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Divide by zero");
                }
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}
