package model;

/**
 *
 * @author - Felipe Peretti -
 */
public class EditoraBEAN {
    
    private int id_editora;
    private String razao_social;
    private String endereco;
    private int telefone;
    private boolean status;

    public EditoraBEAN(){
        
    }
    
    public EditoraBEAN(int id_editora, String razao_social, String endereco, int telefone, boolean status) {
        this.id_editora = id_editora;
        this.razao_social = razao_social;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
    }
    
    public EditoraBEAN(String razao_social, String endereco, int telefone, boolean status) {
        this.razao_social = razao_social;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
    }

    public int getid_editora() {
        return id_editora;
    }

    public void setid_editora(int id_autor) {
        this.id_editora = id_autor;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
  
}
