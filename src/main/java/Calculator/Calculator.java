package Calculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Calculator {

    private static final List<String> SUPPORTED_OPERATIONS = List.of("+", "-", "*", "/", "%");

    public String calculate(double first, double second, String operation){

        Locale currentLocale = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
        otherSymbols.setDecimalSeparator('.');

        if (SUPPORTED_OPERATIONS.contains(operation))
        {
            double result = calculationStep(first, second, operation);
            return new DecimalFormat("0.00", otherSymbols).format(result);
        }
        else
        {
            throw new IllegalStateException(String.format("Operation '%s' is not supported", operation));
        }
    }

    public double calculationStep(double first, double second, String operation)

    {
        return performOperation(first, second, operation);
    }

    private double performOperation(double firstNumber, double secondNumber, String operation) {

        double result;

        switch (operation){
            case "+":
                result = plus(firstNumber, secondNumber);
                break;
            case "-":
                result = minus(firstNumber, secondNumber);
                break;
            case "*":
                result = multiply(firstNumber, secondNumber);
                break;
            case "/":
                result = divide(firstNumber, secondNumber);
                break;
            case "%":
                result = percentage(firstNumber, secondNumber);
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }

    private double plus(double numberOne, double numberTwo){
        return numberOne + numberTwo;}

    private double minus(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;}

    private double multiply(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;}

    private double divide(double numberOne, double numberTwo){
        if (numberTwo == 0) {
            throw new IllegalArgumentException("I can not divide by 0.");
        }
        return numberOne / numberTwo;}

    private double percentage(double firstNumber, double secondNumber){
        return (firstNumber * secondNumber/100);}

}
