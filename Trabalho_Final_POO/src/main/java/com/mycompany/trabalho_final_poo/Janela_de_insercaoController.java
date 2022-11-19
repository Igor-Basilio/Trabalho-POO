/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.trabalho_final_poo;

import com.mycompany.trabalho_final_poo.Atividades.AtividadeInfo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadesAlunoSingleton;
import com.mycompany.trabalho_final_poo.Atividades.AtividadesSingleton;
import static com.mycompany.trabalho_final_poo.Atividades.AtividadesSingleton.addAtividade_info;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author igrob
 */
public class Janela_de_insercaoController implements Initializable {

    @FXML
    private ListView<String> ativselecionarList;
    private List<String> atividades = new LinkedList();
    private ObservableList<String> obsAtividades;
    
    @FXML
    private TextField linkcompTXT;
    @FXML
    private Button confirmarBtn;
    @FXML
    private Button cancelarBtn;
    @FXML
    private Label textoLabel;
    @FXML
    private Button cienciaBtn;
    @FXML
    private Button engenhariaBtn;
    @FXML
    private Label tempotypeLabel;
    @FXML
    private TextField tempoTXT;
    
    /**
     * Initializes the controller class.
     */
    private void switchToInsercao() throws IOException{
         App.setRoot("Janela_de_insercao");
    }
    private void switchToAluno() throws IOException{
         App.setRoot("Aluno");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
           loadAtividades(AtividadesSingleton.getAtividade_info_engenharia()); // Da Load do Default value in listView com as informações da engenharia.        
        }catch(IOException e){
           System.out.println(e.getMessage());
        }  
        cancelarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToAluno();                 
                }catch(IOException e){ 
                   System.out.println(e.getMessage()); 
                }                        
            }
        });   
        confirmarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if(ativselecionarList.getSelectionModel().isEmpty()){
                    textoLabel.setText("Porfavor selecione uma atividade!");          
                }else{
                    textoLabel.setText("");
                    if(linkcompTXT.getText().isEmpty())
                       textoLabel.setText("Porfavor preencha todos os campos validos!");                                                  
                    else{                       
                       AtividadesAlunoSingleton Instance = AtividadesAlunoSingleton.getInstance(); 
                       
                       List<AtividadeInfo> M = AtividadesSingleton.getAtividade_info_engenharia();
                       
                       List<AtividadeInfo> i = AtividadesAlunoSingleton.getAtividadesAlunolist();
                       
                       ListIterator<AtividadeInfo> l = M.listIterator();
                       
                       while(l.hasNext()){
                           AtividadeInfo current = l.next();
                           if(ativselecionarList.getSelectionModel().getSelectedItem().equalsIgnoreCase(current.getNomeAtividade())){
                              AtividadeInfo A = new AtividadeInfo();
                              try{
                                  A.setComprovante_link(linkcompTXT.getText());
                                  A.setHoras(Integer.parseInt(tempoTXT.getText()));
                                  A.setId_atividade(current.getId_atividade());
                                  A.setMax_horas(current.getMax_horas());
                                  A.setNomeAtividade(current.getNomeAtividade());
                                  A.setTipo(current.getTipo());
                              }catch(NumberFormatException e){
                                  System.out.println(e.getMessage());
                              }
                                  Instance.addAtividade_info(A);                            
                           }                                                    
                       }                     
                       try{
                          switchToAluno();                 
                       }catch(IOException e){ 
                          System.out.println(e.getMessage()); 
                       }                         
                    }                    
               }                        
           }
        });
        ativselecionarList.setOnMouseClicked(new EventHandler<MouseEvent>(){
             @Override
             public void handle(MouseEvent mouseEvent) {
                  if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                      String t = ativselecionarList.getSelectionModel().getSelectedItem();
                      if(t != null){       
                         ListIterator<AtividadeInfo> iterador = AtividadesSingleton.getAtividade_info_engenharia().listIterator();
                         while(iterador.hasNext()){
                               AtividadeInfo i = iterador.next();
                               if(i.getNomeAtividade().equalsIgnoreCase(t))
                                  tempotypeLabel.setText(i.getTipo().toString());
                         }                       
                      }
                  }
             }         
        });
        
        
        
        engenhariaBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {                    
                    loadAtividades(AtividadesSingleton.getAtividade_info_engenharia());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }); 
        cienciaBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {             
                try {                    
                    loadAtividades(AtividadesSingleton.getAtividade_info_ciencia());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });            
    }
    
    public void loadAtividades(List<AtividadeInfo> atividadesList) throws IOException{
        
        atividades.clear();
        ListIterator<AtividadeInfo> iterador = atividadesList.listIterator();
        
        while(iterador.hasNext()){
            AtividadeInfo t = iterador.next();
            atividades.add(t.getId_atividade()+ "  " + t.getNomeAtividade());
        }   
        
        obsAtividades = FXCollections.observableArrayList(atividades);

        ativselecionarList.getItems().clear();
        ativselecionarList.setItems(obsAtividades);  // Actual list que aparecerá na tela.
    }   
}
