package model;

/**
 *
 * @author - Felipe Peretti -
 */
public class AutorBEAN {
    
    private int id_autor;
    private String nome;
    private boolean status;

    public AutorBEAN(int id_autor, String nome, boolean status) {
        this.id_autor = id_autor;
        this.nome = nome;
        this.status = status;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
       
}
