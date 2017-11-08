package sample;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Даги on 03.11.2017.
 */
public class Number {
    static boolean isPlus;
    static boolean isMinus;
    static boolean isDivide;
    static boolean isMultiply;

    private String number;
    private boolean isPositive;
    private boolean isAnswer;
    private boolean isInteger;

    public Number() {
        number = "";
        isPositive = true;
        isAnswer = false;
        isInteger = true;
    }

    public boolean isInteger() {
        return isInteger;
    }

    public void setInteger(boolean integer) {
        isInteger = integer;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(char number) {
        if (number == '.' && this.number.isEmpty()){
            setNumber("0");
        }
        this.number += number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public boolean isPositiveNumber() {
        return !number.contains("-");
    }

    public void setPositive() {
        if (isPositiveNumber()) {
            isPositive = false;
            number = "-" + number;
        } else {
            number = number.substring(1);
            isPositive = true;
        }
    }

    public static String calculatePercent(Number first, Number second){
        BigDecimal bd1 = new BigDecimal(first.getNumber());
        BigDecimal bd2 = new BigDecimal(second.getNumber());
        return bd1.multiply(bd2.divide(new BigDecimal("100"),2,BigDecimal.ROUND_FLOOR)).toString();
    }

    public static String calculate(Number first, Number second) {
        BigDecimal bd1 = new BigDecimal(first.getNumber());
        BigDecimal bd2 = new BigDecimal(second.getNumber());
        BigDecimal result;
        if (isMinus) {
            result = bd1.subtract(bd2);
            isMinus = false;
        } else if (isPlus) {
            result = bd1.add(bd2);
            isPlus = false;
        } else if (isDivide) {
            result = bd1.divide(bd2,30,BigDecimal.ROUND_FLOOR);
            isDivide = false;
        } else {
            result = bd1.multiply(bd2);
            isMultiply = false;
        }
        return result.toString();
       // return result.stripTrailingZeros().toString();
    }
}
