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

//    private String first = "";
//    private String second = "";
//    private String operation = "";
//    private boolean isFirst = true;
//    private boolean isPlus;
//    private boolean isMinus;
//    private boolean isDivide;
//    private boolean isMultiply;
//    private boolean isOperation;
//    private boolean isFirstPositive = true;
//    private boolean isSecondPositive = true;

    Number number1 = new Number();
    Number number2 = new Number();
    Number workNumber = number1;
    String oper = "";

    public void pressBut(ActionEvent actionEvent) {
        EventTarget target = actionEvent.getTarget();
        if (target.equals(but1)) {
            enterNumber('1');
        } else if (target.equals(but2)) {
            enterNumber('2');
        } else if (target.equals(but3)) {
            enterNumber('3');
        } else if (target.equals(but4)) {
            enterNumber('4');
        } else if (target.equals(but5)) {
            enterNumber('5');
        } else if (target.equals(but6)) {
            enterNumber('6');
        } else if (target.equals(but7)) {
            enterNumber('7');
        } else if (target.equals(but8)) {
            enterNumber('8');
        } else if (target.equals(but9)) {
            enterNumber('9');
        } else if (target.equals(but0)) {
            enterNumber('0');
        } else if (target.equals(butPlus)) {
            buttonOperationProcess(" + ");
            Number.isPlus = true;
        } else if (target.equals(butMinus)) {
            buttonOperationProcess(" - ");
            Number.isMinus = true;
        } else if (target.equals(butMultiply)) {
            buttonOperationProcess(" * ");
            Number.isMultiply = true;
        } else if (target.equals(butDivide)) {
            buttonOperationProcess(" / ");
            Number.isDivide = true;
        } else if (target.equals(butAnswer)) {
            if (workNumber == number2) {
                getAnswer();
            }
        } else if (target.equals(butAC)) {
            clear();
            textArea.setText("0");
        } else if (target.equals(butDot)) {
            if (workNumber.isInteger()) {
                workNumber.setNumber('.');
                workNumber.setInteger(false);
                show();
            }
        } else if (target.equals(butRoot)) {
            if (!workNumber.getNumber().isEmpty()) {
                workNumber.setNumber(String.valueOf(Math.sqrt(Double.valueOf(workNumber.getNumber()))));
                show();
            }
        } else if (target.equals(butNegativePositive)) {
            workNumber.setPositive();
            show();
        } else if (target.equals(butPercent)) {
            if (workNumber == number2 && !workNumber.getNumber().isEmpty()) {
                number2.setNumber(Number.calculatePercent(number1, number2));
                getAnswer();
            }
        }
    }

    private void getAnswer() {
        number1.setNumber(Number.calculate(number1, number2));
        workNumber = number1;
        workNumber.setAnswer(true);
        number2 = new Number();
        oper = "";
        show();
    }

    private void enterNumber(char n) {
        if (workNumber.isAnswer()) {
            clear();
        }
        workNumber.setNumber(n);
        show();
    }

    private void clear() {
        clearOperation();
        number1 = new Number();
        number2 = new Number();
        workNumber = number1;
    }

    private void clearOperation() {
        Number.isDivide = false;
        Number.isMultiply = false;
        Number.isMinus = false;
        Number.isPlus = false;
        oper = "";
    }

    private void buttonOperationProcess(String strOper) {
        if (!number1.getNumber().isEmpty()) {
            if (!oper.isEmpty() && workNumber.getNumber().isEmpty()) {
                clearOperation();
            } else if (workNumber == number1) {
                workNumber = number2;
            } else {
                number1.setNumber(Number.calculate(number1, number2));
                number2 = new Number();
                workNumber = number2;
            }
            oper = strOper;
            show();
        } else {
            clearOperation();
        }
    }

    private void show() {
        textArea.setText(number1.getNumber() + oper + number2.getNumber());
    }
}
