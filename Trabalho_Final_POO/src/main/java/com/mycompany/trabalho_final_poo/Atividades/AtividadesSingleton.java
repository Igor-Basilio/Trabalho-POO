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

public class AtividadesSingleton{
    
    private static List<AtividadeInfo> atividade_info_ciencia;
    private String cienciafile = "C:\\Users\\igrob\\OneDrive\\Área de Trabalho\\Trabalho Final POO\\Trabalho_Final_POO\\src\\main\\resources\\dados\\AtividadesCiencia.csv";
    private static List<AtividadeInfo> atividade_info_engenharia;
    private String engenhariafile = "C:\\Users\\igrob\\OneDrive\\Área de Trabalho\\Trabalho Final POO\\Trabalho_Final_POO\\src\\main\\resources\\dados\\AtividadesEngenharia.csv";
    private static AtividadesSingleton atividades;
    
    private AtividadesSingleton(){}

    public String getCienciafile() {
        return cienciafile;
    }

    public void setCienciafile(String cienciafile) {
        this.cienciafile = cienciafile;
    }

    public String getEngenhariafile() {
        return engenhariafile;
    }

    public void setEngenhariafile(String engenhariafile) {
        this.engenhariafile = engenhariafile;
    }
    public static AtividadesSingleton getInstance(){
        if(atividades == null)
           atividades = new AtividadesSingleton();
        return atividades;
    }
    public static void addAtividade_info(List<AtividadeInfo> atividadeList , AtividadeInfo atividade ){
        atividadeList.add(atividade);    
    }
    public static List<AtividadeInfo> getAtividade_info_ciencia() {
        if(atividade_info_ciencia == null)
           atividade_info_ciencia = new LinkedList();      
        return atividade_info_ciencia;
    }
    public static void addAtividade_info_ciencia(AtividadeInfo atividade){
        atividade_info_ciencia.add(atividade);   
    }
    
    public static List<AtividadeInfo> getAtividade_info_engenharia() {
        if(atividade_info_engenharia == null)
           atividade_info_engenharia = new LinkedList();      
        return atividade_info_engenharia;
    }
    public static void addAtividade_info_engenharia(AtividadeInfo atividade){
        atividade_info_engenharia.add(atividade);   
    }
}
