package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private BorderPane BorderPane;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem Open;

    @FXML
    private MenuItem MenuSave;

    @FXML
    private TextArea TextArea;

    @FXML
    void MenuBarOpen(ActionEvent event) {
        try{
            // Cesta do aktuálního adresáře
            Path firstPath = FileSystems.getDefault().getPath(".");
            // Cesta do určeného adresáře
            firstPath = FileSystems.getDefault().getPath("c:/");
            Stage stageFileOpen = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Vyber soubor:");
            if (firstPath != null) {
                File path = new File(firstPath.toString());
                fileChooser.initialDirectoryProperty().set(path);
            }
            File chooseFile=fileChooser.showOpenDialog(stageFileOpen);
            String fileName=chooseFile.getAbsolutePath();
            // Read
            ArrayList<String> Text =  FileManager.Read(fileName);
            for (String s: Text) {
                TextArea.appendText(s);
                TextArea.appendText("\n");
            }
        } catch (Exception exception) {
            System.out.println("tak to nene");
        }
    }

    @FXML
    void MenuBarSave(ActionEvent event) {
        try {
            System.out.println("test");
            // Cesta do aktuálního adresáře
            Path firstPath = FileSystems.getDefault().getPath(".");
            // Cesta do určeného adresáře
            firstPath = FileSystems.getDefault().getPath("c:/");
            Stage stageFileOpen = new Stage();
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Vyber soubor:");
            if (firstPath != null) {
                File path = new File(firstPath.toString());
                fileChooser.initialDirectoryProperty().set(path);
            }
            File chooseFile=fileChooser.showSaveDialog(stageFileOpen);
            String fileName=chooseFile.getAbsolutePath();
            // Write
            FileManager.Write(fileName, TextArea.getText());
        } catch (Exception exception) {
            System.out.println("tak to nene");
        }
    }
}