package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author - Felipe Peretti -
 */
public class ClienteDAO {
    
    
    private static ClienteDAO instance;
    
    private ClienteDAO(){
        MySQLDAO.getConnection();
    }
    
    public static ClienteDAO getInstance(){
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }
    
    public long create(ClienteBEAN cliente){
        String query = "INSERT INTO CLIENTE (nome, cpf, status) VALUES (?,?,?)";
        return MySQLDAO.executeQuery(query, cliente.getNome(), cliente.getCpf(), cliente.isStatus());
    }
    
    public void update(ClienteBEAN cliente){
        String query = "UPDATE CLIENTE SET nome=?, cpf=?, status=? WHERE id_cliente = ?";
        MySQLDAO.executeQuery(query, cliente.getNome(), cliente.getCpf(), cliente.isStatus(),
                cliente.getId_cliente());
    }
    
    public void delete(ClienteBEAN cliente){
        MySQLDAO.executeQuery("DELETE FROM CLIENTE WHERE id_cliente = ?",cliente.getId_cliente());
    }
    
    public ArrayList<ClienteBEAN> findAllClientes(){
        return listaClientes("SELECT * FROM CLIENTE ORDER BY Nome");
    }
    
    public ArrayList<ClienteBEAN> listaClientes(String query){
        ArrayList<ClienteBEAN> lista = new ArrayList<ClienteBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try{
            while(rs.next()){
                lista.add(new ClienteBEAN(rs.getInt("id_cliente"),rs.getString("nome"), 
                        rs.getInt("cpf") ,rs.getBoolean("status")));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public ClienteBEAN findCliente(int id_cliente){
        ClienteBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE id_cliente=?", id_cliente);
        try{
            if(rs.next()){
                result = new ClienteBEAN(rs.getInt("id_cliente"),rs.getString("nome"), 
                        rs.getInt("cpf") ,rs.getBoolean("status"));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int findId(ClienteBEAN cliente){
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE cpf= ?", cliente.getCpf());
        try{
            if(rs.next()){
                result = rs.getInt("id_cliente");
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExistCliente(int id_cliente){
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM CLIENTE WHERE id_cliente= ?",id_cliente);
        try{
            if( rs.next()){
                result = true;
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
}
