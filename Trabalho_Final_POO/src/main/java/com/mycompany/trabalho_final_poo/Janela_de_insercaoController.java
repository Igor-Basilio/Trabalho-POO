/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.trabalho_final_poo;

import com.mycompany.trabalho_final_poo.Atividades.AtividadeInfo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadeTipo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadesSingleton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    private List<String> atividades = new ArrayList();
    private ObservableList<String> obsAtividades;
    
    @FXML
    private TextField linkcompTXT;
    @FXML
    private Button confirmarBtn;
    @FXML
    private Button cancelarBtn;
    @FXML
    private Label textoLabel;
    
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

        cancelarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try{
                   switchToAluno();                 
                }catch(IOException e){         
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
                       textoLabel.setText("Porfavor coloque um link valido!"); 
                    else{ 
                       
                       
                        
                       try{
                          switchToAluno();                 
                       }catch(IOException e){         
                       }                   
                    }                       
               }         
                
           }
        });
        loadAtividades();
             
    }
    
    public void loadAtividades(){           
        AtividadeTipo tipo;
        String filename = "C:\\Users\\igrob\\OneDrive\\Área de Trabalho\\Trabalho Final POO\\Trabalho_Final_POO\\src\\main\\resources\\dados\\AtividadesEngenharia.csv";
        File file = new File(filename); 
        try{
           Scanner inputstream = new Scanner(file); 
           inputstream.nextLine();
           while(inputstream.hasNextLine()){
                 AtividadeInfo atividade = new AtividadeInfo();
                 String data = inputstream.nextLine(); 
                 String values[] = data.split(",");
                 
                 int ID = Integer.parseInt(values[0]);  
                 int horas = Integer.parseInt(values[3]);
                 int horas_maximas = Integer.parseInt(values[4]);
                                
                 if(values[2].equalsIgnoreCase("Horas"))                                      
                     tipo = AtividadeTipo.Horas;
                 else if(values[2].equalsIgnoreCase("Semestre"))
                     tipo = AtividadeTipo.Semestre;
                 else
                     tipo = AtividadeTipo.Unidade;
                                             
                 atividade.setHoras(horas);
                 atividade.setNomeAtividade(values[1]); // Values[1] ( nome ) já String não precisa converter.
                 atividade.setTipo(tipo);
                 atividade.setMax_horas(horas_maximas);
                 atividade.setId_atividade(ID);
                 
                 AtividadesSingleton.getInstance().addAtividade_info(atividade);
           }
           inputstream.close();
        }catch(FileNotFoundException e){          
        }
             
        ListIterator<AtividadeInfo> iterador = AtividadesSingleton.getInstance().getAtividade_info().listIterator();
        
        while(iterador.hasNext()){
            atividades.add(iterador.next().getNomeAtividade());
        }     
        
        obsAtividades = FXCollections.observableArrayList(atividades);

        ativselecionarList.setItems(obsAtividades);
    }   
}
