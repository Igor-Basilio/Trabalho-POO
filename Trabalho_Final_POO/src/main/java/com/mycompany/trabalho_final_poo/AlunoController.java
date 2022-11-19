/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.trabalho_final_poo;

import com.mycompany.trabalho_final_poo.Atividades.AtividadeInfo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadesAlunoSingleton;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> atividadesAlunoList;
    private List<String> atividades = new LinkedList();
    private ObservableList<String> obsAtividades;
    
    
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
        try {
            AtividadesAlunoSingleton.getInstance();
            loadAtividades(AtividadesAlunoSingleton.getAtividadesAlunolist());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        inserirBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToInsercao();                 
                }catch(IOException e){
                   System.out.println(e.getMessage());
                }
                            
            }
        });
        cancelarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToPrimary();                 
                }catch(IOException e){     
                   System.out.println(e.getMessage()); 
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

        atividadesAlunoList.getItems().clear();
        atividadesAlunoList.setItems(obsAtividades);  // Actual list que aparecerá na tela.
    }  
}
