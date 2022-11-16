/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.trabalho_final_poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author igrob
 */
public class AlunoController implements Initializable {

    @FXML
    private TextField nomeTXT;
    @FXML
    private TextField emailTXT;
    @FXML
    private TextField matriculaTXT;
    @FXML
    private TextField cursoTXT;
    @FXML
    private TextField semestreIngreTXT;
    @FXML
    private TextField previformaTXT;
    @FXML
    private ListView<?> atividadesList;
    @FXML
    private Button inserirBtn;
    @FXML
    private Button confirmarBtn;
    @FXML
    private Button cancelarBtn;

    /**
     * Initializes the controller class.
     */
    private void switchToInsercao() throws IOException{
         App.setRoot("Janela_de_insercao");
    }
    private void switchToPrimary() throws IOException{
         App.setRoot("primary");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        inserirBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToInsercao();                 
                }catch(IOException e){         
                }
                            
            }
        });
        cancelarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToPrimary();                 
                }catch(IOException e){         
                }
                            
            }
        });
    }      
}
