package com.mycompany.trabalho_final_poo.Atividades;

/**
 *
 * @author igrob
 */
public class AtividadeInfo {
    
    private int id_atividade;
    private String nomeAtividade;
    private AtividadeTipo tipo;
    private int horas;
    private int max_horas;
    private String comprovante_link;
    
    public AtividadeInfo(){}

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public AtividadeTipo getTipo() {
        return tipo;
    }

    public void setTipo(AtividadeTipo tipo) {
        this.tipo = tipo;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMax_horas() {
        return max_horas;
    }

    public void setMax_horas(int max_horas) {
        this.max_horas = max_horas;
    }

    public String getComprovante_link() {
        return comprovante_link;
    }

    public void setComprovante_link(String comprovante_link) {
        this.comprovante_link = comprovante_link;
    }

  
}
