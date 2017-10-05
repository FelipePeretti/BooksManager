package model;

/**
 *
 * @author - Felipe Peretti -
 */
public class ClienteBEAN {
    
    private int id_cliente;
    private String nome;
    private int cpf;
    private boolean status;

    public ClienteBEAN(int id_cliente, String nome, int cpf, boolean status) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
