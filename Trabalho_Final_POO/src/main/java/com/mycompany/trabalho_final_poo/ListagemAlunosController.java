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

/**
 * FXML Controller class
 *
 * @author igrob
 */
public class ListagemAlunosController implements Initializable {

    @FXML
    private ListView<?> alunosList;
    @FXML
    private Button voltarBtn;

    /**
     * Initializes the controller class.
     */
    private void switchToProfessor() throws IOException{
         App.setRoot("Professor");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        voltarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToProfessor();                 
                }catch(IOException e){
                   System.out.println(e.getMessage());
                }
                            
            }
        });
    }    
    
}
