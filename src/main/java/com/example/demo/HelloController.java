package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.ProgressBarSkin;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class HelloController {

    @FXML
    private BorderPane BorderPane;

    @FXML
    private Text FileText;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem MenuSave;

    @FXML
    private MenuItem New;

    @FXML
    private MenuItem Open;

    @FXML
    private ProgressBar ProgBar;

    @FXML
    public static TextArea textArea;

    @FXML
    void MenuBarOpen(ActionEvent event) {
        try{
            Path firstPath = FileSystems.getDefault().getPath(".");
            firstPath = FileSystems.getDefault().getPath("c:/");
            Stage stageFileOpen = new Stage();
            FileChooser fileChooser = new FileChooser();
            ProgBar.setProgress(0);
            fileChooser.setTitle("Choose file:");
            if (firstPath != null) {
                File path = new File(firstPath.toString());
                fileChooser.initialDirectoryProperty().set(path);
            }
            ProgBar.setProgress(0.5);
            File chooseFile=fileChooser.showOpenDialog(stageFileOpen);
            String fileName=chooseFile.getAbsolutePath();
            // Read
            ArrayList<String> Text =  FileManager.Read(fileName);
            for (String s: Text) {
                textArea.appendText(s);
                textArea.appendText("\n");
            }
            ProgBar.setProgress(0.75);
            FileText.setText(fileName);
            ProgBar.setProgress(1);
        } catch (Exception exception) {
            System.out.println("HelloController.MenuBarOpen ERROR!");
        }
    }

    @FXML
    void MenuBarSave(ActionEvent event) {
        try {
            ProgBar.setProgress(0);
            Path firstPath = FileSystems.getDefault().getPath(".");
            firstPath = FileSystems.getDefault().getPath("c:/");
            Stage stageFileOpen = new Stage();
            FileChooser fileChooser = new FileChooser();
            ProgBar.setProgress(0.25);
            fileChooser.setTitle("Choose file:");
            if (firstPath != null) {
                File path = new File(firstPath.toString());
                fileChooser.initialDirectoryProperty().set(path);
            }
            ProgBar.setProgress(0.75);
            File chooseFile=fileChooser.showSaveDialog(stageFileOpen);
            String fileName=chooseFile.getAbsolutePath();
            FileText.setText(fileName);
            // Write
            FileManager.Write(fileName, textArea.getText());
            ProgBar.setProgress(1);
        } catch (Exception exception) {
            System.out.println("HelloController.MenuBarSave ERROR!");
        }
    }

    @FXML
    void MenuBarNew(ActionEvent event) {
        try{
            FileText.setText("New file");
            textArea.setText("");
        } catch (Exception exception) {
            System.out.println("HelloController.MenuBarNew ERROR!");
        }
    }

    private static Stage ReplaceStage;
    @FXML
    void MenuBarReplace(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("replace-window.fxml"));
            ReplaceStage = new Stage();
            ReplaceStage.setScene(new Scene(fxmlLoader.load()));
            ReplaceStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReplaceStageControl(String action) {
        switch (action.toLowerCase()) {
            case ("close") -> {
                ReplaceStage.close();
            }
        }
    }
}