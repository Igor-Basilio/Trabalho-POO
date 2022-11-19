package com.mycompany.trabalho_final_poo;

import com.mycompany.trabalho_final_poo.Atividades.AtividadeInfo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadeTipo;
import com.mycompany.trabalho_final_poo.Atividades.AtividadesSingleton;
import static com.mycompany.trabalho_final_poo.Atividades.AtividadesSingleton.addAtividade_info;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.ListCell;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show(); 
        try{
           readAtividades(AtividadesSingleton.getAtividade_info_engenharia());
           readAtividades(AtividadesSingleton.getAtividade_info_ciencia());         
        }catch(IOException e){
           System.out.println(e.getMessage());
        }       
    }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    private static void readAtividades(List<AtividadeInfo> atividadesList) throws IOException{
        AtividadeTipo tipo; int ID=0,horas=0,horas_maximas=0; String filename;
        
        if(AtividadesSingleton.getAtividade_info_ciencia() == atividadesList)
           filename = AtividadesSingleton.getInstance().getCienciafile(); 
        else
           filename = AtividadesSingleton.getInstance().getEngenhariafile();  
        File file = new File(filename);
        try{
           Scanner inputstream = new Scanner(file,StandardCharsets.UTF_8); 
           inputstream.nextLine();
           while(inputstream.hasNextLine()){
               
                 AtividadeInfo atividade = new AtividadeInfo();
                 String data = inputstream.nextLine(); 
                 String values[] = data.split(",");
                 try{
                    ID = Integer.parseInt(values[0]);  
                    horas = Integer.parseInt(values[3]);
                    horas_maximas = Integer.parseInt(values[4]);            
                 }catch(NumberFormatException e){
                    System.out.println(e.getMessage()); 
                 }
                                      
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
                 
                 addAtividade_info(atividadesList,atividade);
           }
           inputstream.close();
        }catch(FileNotFoundException e){ 
           System.out.println(e.getMessage());
        }       
    }
}