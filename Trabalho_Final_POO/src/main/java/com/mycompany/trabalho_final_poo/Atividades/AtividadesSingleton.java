/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final_poo.Atividades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igrob
 */

public class AtividadesSingleton{
   
    private ArrayList<AtividadeInfo> atividade_info = null;
    
    private static AtividadesSingleton atividades;
    
    private AtividadesSingleton(){}
    
    public static AtividadesSingleton getInstance(){
        if(atividades == null)
           atividades = new AtividadesSingleton();
        return atividades;
    }
    public ArrayList<AtividadeInfo> getAtividade_info() {
        if(atividade_info == null)
           this.atividade_info = new ArrayList();      
        return this.atividade_info;
    }
    public void addAtividade_info(AtividadeInfo atividade){
        this.atividade_info.add(atividade);   
    }
}
