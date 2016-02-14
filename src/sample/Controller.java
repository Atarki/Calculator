package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private JFXTextField displayField;
    private double currentNumber;
    private String currentOperator;

    public void handleReset() {
        currentNumber = 0;
        currentOperator = null;
        displayField.setText("");
        displayField.setPromptText("");
    }

    public void handleComaAction() {
        if (displayField.getText() != null) {
            displayField.setText(displayField.getText() + ".");
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
        double newNumber = Double.parseDouble(displayField.getText());
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
        currentNumber = Double.parseDouble(displayField.getText());
        displayField.setPromptText(displayField.getText() + currentOperator);
        displayField.setText("");

    }
}
