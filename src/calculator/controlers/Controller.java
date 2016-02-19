package calculator.controlers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private JFXTextField displayField;
    private double currentNumber;
    private String currentOperator = "=";

    public void handleReset() {
        currentNumber = 0;
        currentOperator = null;
        displayField.setText("");
        displayField.setPromptText("");
    }

    public void handleComaAction() {
        String number = displayField.getText();
        if (displayField.getText() != null) {
            if (!number.contains(".")) {
                displayField.setText(displayField.getText() + ".");
            }
        } else {
            displayField.setText(".");
        }
    }

    public void handleDigitAction(ActionEvent event) {
        String jfxButton = ((JFXButton) event.getSource()).getText();
        if (displayField.getText() != null) {
            displayField.setText(displayField.getText() + jfxButton);
        } else {
            displayField.setText(jfxButton);
        }
    }

    public void handleResult() {
        String number = displayField.getText();
        double newNumber = 0;
        if (!number.isEmpty() && !number.equals(".")) {
            newNumber = Double.parseDouble(number);
        }
        switch (currentOperator) {
            case "+":
                currentNumber = currentNumber + newNumber;
                break;
            case "-":
                currentNumber = currentNumber - newNumber;
                break;
            case "/":
                currentNumber = currentNumber / newNumber;
                break;
            case "*":
                currentNumber = currentNumber * newNumber;
                break;
        }
        displayField.setText((String.format("%.5f", currentNumber)).replace(",", "."));

    }

    public void handleOperation(ActionEvent event) {
        currentOperator = ((JFXButton) event.getSource()).getText();
        String number = displayField.getText();
        if (!number.isEmpty() && !number.equals(".")) {
            currentNumber = Double.parseDouble(number);
        }
        displayField.setText("");
        displayField.setPromptText(displayField.getText() + currentOperator);

    }
}
