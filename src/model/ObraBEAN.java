package model;

import java.time.Year;

/**
 *
 * @author - Felipe Peretti -
 */
public class ObraBEAN {
    
    private int id_obra;
    private int codigo;
    private String titulo;
    private int ano;
    private Boolean situacao;
    private EditoraBEAN Editora_id_editora;
    private boolean status;

    public ObraBEAN(int id_obra, int codigo, String titulo, int ano, boolean situacao, EditoraBEAN Editora_id_editora, boolean status) {
        this.id_obra = id_obra;
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.situacao = situacao;
        this.Editora_id_editora = Editora_id_editora;
        this.status = status;
    }

    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public EditoraBEAN getEditora_id_editora() {
        return Editora_id_editora;
    }

    public void setEditora_id_editora(EditoraBEAN Editora_id_editora) {
        this.Editora_id_editora = Editora_id_editora;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
   
}
