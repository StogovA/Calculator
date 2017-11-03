package sample;

import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
    @FXML
    public Button butNegativePositive;
    @FXML
    private Button butAC;
    @FXML
    private Button butDot;
    @FXML
    private Button butRoot;
    @FXML
    private Button butPercent;
    @FXML
    private TextArea textArea;
    @FXML
    private Button but1;
    @FXML
    private Button but2;
    @FXML
    private Button but3;
    @FXML
    private Button but4;
    @FXML
    private Button but5;
    @FXML
    private Button but6;
    @FXML
    private Button but7;
    @FXML
    private Button but8;
    @FXML
    private Button but9;
    @FXML
    private Button but0;
    @FXML
    private Button butPlus;
    @FXML
    private Button butMinus;
    @FXML
    private Button butMultiply;
    @FXML
    private Button butDivide;
    @FXML
    private Button butAnswer;

    private String first = "";
    private String second = "";
    private String operation = "";
    private boolean isFirst = true;
    private boolean isPlus;
    private boolean isMinus;
    private boolean isDivide;
    private boolean isMultiply;
    private boolean isOperation;
    private boolean isFirstPositive = true;
    private boolean isSecondPositive = true;


    public void pressBut(ActionEvent actionEvent) {
        EventTarget target = actionEvent.getTarget();
        if (target.equals(but1)) {
            addNumber("1");
        } else if (target.equals(but2)) {
            addNumber("2");
        } else if (target.equals(but3)) {
            addNumber("3");
        } else if (target.equals(but4)) {
            addNumber("4");
        } else if (target.equals(but5)) {
            addNumber("5");
        } else if (target.equals(but6)) {
            addNumber("6");
        } else if (target.equals(but7)) {
            addNumber("7");
        } else if (target.equals(but8)) {
            addNumber("8");
        } else if (target.equals(but9)) {
            addNumber("9");
        } else if (target.equals(but0)) {
            addNumber("0");
        } else if (target.equals(butPlus)) {
            butOperationProcess("+");
            isPlus = true;
        } else if (target.equals(butMinus)) {
            butOperationProcess("-");
            isMinus = true;
        } else if (target.equals(butMultiply)) {
            butOperationProcess("*");
            isMultiply = true;
        } else if (target.equals(butDivide)) {
            butOperationProcess("/");
            isDivide = true;
        } else if (target.equals(butAnswer)) {
            getAnswer();
        } else if (target.equals(butAC)) {
            first = "";
            second = "";
            operation = "";
            isOperation = false;
            isFirst = true;
            isDivide = false;
            isPlus = false;
            isMultiply = false;
            isMinus = false;
            textArea.setText("0");
        } else if (target.equals(butDot)) {
            addNumber(".");
        } else if (target.equals(butRoot)) {
            if (isFirst && !isOperation) {
                first = Double.toString(Math.sqrt(Float.valueOf(first)));
                textArea.setText(first);
            } else {
                second = Double.toString(Math.sqrt(Float.valueOf(second)));
                textArea.setText(first + " " + operation + " " + second);
            }
        } else if (target.equals(butPercent)) {
            if (!isFirst) {
                second = String.valueOf((Double.valueOf(first) / 100 * Double.valueOf(second)));
                getAnswer();
            }
        } else  if (target.equals(butNegativePositive)){
           
        }
    }

    private void butOperationProcess(String op) {
        if (!first.isEmpty()) {
            getAnswer();
            operation = op;
            isFirst = false;
            isOperation = true;
            textArea.setText(first + " " + operation);
        }
    }

    private void addNumber(String n) {
        if (isFirst) {
            first += n;
        } else {
            second += n;
        }
        isOperation = false;
        textArea.setText(first + " " + operation + " " + second);
    }

    private void getAnswer() {
        if (!isFirst && !isOperation) {
            if (isDivide) {
                first = Double.toString(Double.valueOf(first) / Double.valueOf(second));
                isDivide = false;
            } else if (isMinus) {
                first = Double.toString(Double.valueOf(first) - Double.valueOf(second));
                isMinus = false;
            } else if (isMultiply) {
                first = Double.toString(Double.valueOf(first) * Double.valueOf(second));
                isMultiply = false;
            } else if (isPlus) {
                first = Double.toString(Double.valueOf(first) + Double.valueOf(second));
                isPlus = false;
            }
            isFirst = true;
            second = "";
            if (isInteger(first)) {
                first = Integer.toString(Double.valueOf(first).intValue());
            }
            textArea.setText(first);
        }
    }

    private boolean isInteger(String numb) {
        double d = Double.valueOf(numb);
        return d % 1 == 0;
    }
}
