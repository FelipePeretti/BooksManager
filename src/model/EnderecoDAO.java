package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author - Felipe Peretti -
 */
public class EnderecoDAO {
    
    private static EnderecoDAO instance;
    
    private EnderecoDAO(){
        MySQLDAO.getConnection();
    }
    
    public static EnderecoDAO getInstance(){
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        return instance;
    }
    
    public long create(EnderecoBEAN endereco){
        String query = "INSERT INTO endereco (id_endereco, rua, bairro, numero, Cliente_id_cliente,"
                + "status) VALUES (?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, endereco.getId_endereco(), endereco.getRua(),
        endereco.getBairro(), endereco.getNumero(), endereco.getCliene_id_cliente().getId_cliente()
        , endereco.isStatus());
    }
    
    public void update(EnderecoBEAN endereco){
        String query = "UPDATE endereco SET rua=?, bairro=?, numero=?, Cliente_id_cliente=?"
                + ",status=? WHERE id_endereco = ?";
        MySQLDAO.executeQuery(query, endereco.getRua(),
        endereco.getBairro(), endereco.getNumero(), endereco.getCliene_id_cliente().getId_cliente()
        , endereco.isStatus(), endereco.getId_endereco());
    }
    
    public void delete(EnderecoBEAN endereco){
        MySQLDAO.executeQuery("DELETE FROM endereco WHERE id_endereco = ?", endereco.getId_endereco());
    }
    
    public ArrayList<EnderecoBEAN> findAllEnderecos(){
        return listaEnderecos("SELECT * FROM endereco ORDER BY Nome");
    }
    
    public ArrayList<EnderecoBEAN> listaEnderecos(String query){
        ArrayList<EnderecoBEAN> lista = new ArrayList<EnderecoBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try{
            while(rs.next()){
                lista.add(new EnderecoBEAN(rs.getInt("id_endereco"),rs.getString("rua"), 
                rs.getString("bairro"), rs.getInt("numero"), null
                , rs.getBoolean("status")));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public EnderecoBEAN findEndereco(int id_endereco){
        EnderecoBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE id_endereco=?", id_endereco);
        try{
            if(rs.next()){
                result = new EnderecoBEAN(rs.getInt("id_endereco"),rs.getString("rua"), 
                rs.getString("bairro"), rs.getInt("numero"), null
                , rs.getBoolean("status"));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int findId(EnderecoBEAN endereco){
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE Cliente_id_cliente= ?", endereco.getCliene_id_cliente().getId_cliente());
        try{
            if(rs.next()){
                result = rs.getInt("id_endereco");
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExistEndereco(int id_endereco){
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM ENDERECO WHERE id_endereco= ?",id_endereco);
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
