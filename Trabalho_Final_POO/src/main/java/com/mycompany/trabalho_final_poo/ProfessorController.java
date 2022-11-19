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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author igrob
 */
public class ProfessorController implements Initializable {

    @FXML
    private TextField nomeTXT;
    @FXML
    private TextField siapeTXT;
    @FXML
    private Button confirmarBtn;
    @FXML
    private Button voltarMBtn;
    @FXML
    private Button listagemBtn;
    @FXML
    private Button contabilizacaoBtn;

    /**
     * Initializes the controller class.
     */
    private void switchToPrimary() throws IOException{
         App.setRoot("primary");
    }
    private void switchToListagem() throws IOException{
         App.setRoot("ListagemAlunos");
    }
    private void switchToContabilizacao() throws IOException{
         App.setRoot("ContabilizacaoAlunos");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        voltarMBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToPrimary();                 
                }catch(IOException e){
                   System.out.println(e.getMessage()); 
                }
                            
            }
        });
        listagemBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToListagem();                 
                }catch(IOException e){
                   System.out.println(e.getMessage()); 
                }
                            
            }
        });
        contabilizacaoBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToContabilizacao();                 
                }catch(IOException e){
                   System.out.println(e.getMessage()); 
                }
                            
            }
        });
    }    
    
}
