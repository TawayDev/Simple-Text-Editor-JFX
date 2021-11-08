package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ReplaceController {
    // ReplaceWindow xml:
    @FXML
    private TextField ReplaceWith;

    @FXML
    private TextField ReplaceWord;

    @FXML
    void ReplaceButtonConfirm(ActionEvent event) {
        HelloController.ReplaceStageControl("close");
//        BorderPane.setCursor(Cursor.WAIT);
        String TextAreaText = HelloController.textArea.getText();
        System.out.println(TextAreaText);
        String[] TA = TextAreaText.split("\s");
        for (int i = 0; i < TA.length; i++ ) {
            if (TA[i].equals(ReplaceWord)) {
                TA[i] = ReplaceWith.getText();
            }
        }

        HelloController.textArea.clear();
        for (String s : TA) {
            HelloController.textArea.appendText(s + " ");
        }
//        BorderPane.setCursor(Cursor.DEFAULT);
    }
}
