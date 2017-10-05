package model;

/**
 *
 * @author - Felipe Peretti -
 */
public class EnderecoBEAN {
    
    private int id_endereco;
    private String rua; 
    private String bairro;
    private int numero;
    private ClienteBEAN Cliene_id_cliente;
    private boolean status;

    public EnderecoBEAN(int id_endereco, String rua, String bairro, int numero, ClienteBEAN Cliene_id_cliente, boolean status) {
        this.id_endereco = id_endereco;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.Cliene_id_cliente = Cliene_id_cliente;
        this.status = status;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ClienteBEAN getCliene_id_cliente() {
        return Cliene_id_cliente;
    }

    public void setCliene_id_cliente(ClienteBEAN Cliene_id_cliente) {
        this.Cliene_id_cliente = Cliene_id_cliente;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
