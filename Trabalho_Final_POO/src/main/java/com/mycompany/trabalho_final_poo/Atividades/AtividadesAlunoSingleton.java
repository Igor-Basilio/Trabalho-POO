/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final_poo.Atividades;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author igrob
 */
public class AtividadesAlunoSingleton {
    
    private static List<AtividadeInfo> atividadesAlunolist;
    
    private static AtividadesAlunoSingleton atividadesAluno;
     
    private AtividadesAlunoSingleton(){}        
    
    public static AtividadesAlunoSingleton getInstance(){
        if(atividadesAluno == null)
           atividadesAluno = new AtividadesAlunoSingleton(); 
        return atividadesAluno;
    }
    public static List<AtividadeInfo> getAtividadesAlunolist(){
        if(atividadesAlunolist == null)
           atividadesAlunolist = new LinkedList(); 
        return atividadesAlunolist;       
    }  
    public static void addAtividade_info(AtividadeInfo atividade){
        atividadesAlunolist.add(atividade);       
    } 
    
}
