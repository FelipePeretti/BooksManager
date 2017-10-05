package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author - Felipe Peretti -
 */
public class EditoraDAO {
    
    private static EditoraDAO instance;
    
    private EditoraDAO(){
        MySQLDAO.getConnection();
    }
    
    public static EditoraDAO getInstance(){
        if (instance == null) {
            instance = new EditoraDAO();
        }
        return instance;
    }
    
    public long create(EditoraBEAN editora){
        String query = "INSERT INTO editora (razao_social, endereco, "
                + "telefone, status) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, editora.getRazao_social()
                , editora.getEndereco(), editora.getTelefone(),editora.getStatus());
    }
    
    public void update(EditoraBEAN editora){
        String query = "UPDATE EDITORA SET razao_social=?, endereco=?,"
                + "telefone=?, status=? WHERE id_editora=?";
        MySQLDAO.executeQuery(query, editora.getRazao_social(), editora.getEndereco(), 
                editora.getTelefone(),editora.getStatus(),editora.getid_editora());
    }
    
    public void delete(EditoraBEAN editora){
        MySQLDAO.executeQuery("DELETE FROM EDITORA WHERE id_editora = ?",editora.getid_editora());
    }
    
    public ArrayList<EditoraBEAN> findAllEditora(){
        return listaEditoras("SELECT * FROM EDITORA ORDER BY razao_social");
    }
    
    public ArrayList<EditoraBEAN> findLikeNameEditora(String razao_social){
        return listaEditoras("SELECT * FROM EDITORA WHERE razao_social LIKE '%"+razao_social+"%'");
    }
    
    public ArrayList<EditoraBEAN> listaEditoras(String query){
        ArrayList<EditoraBEAN> lista = new ArrayList<EditoraBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try{
            while(rs.next()){
                lista.add(new EditoraBEAN(rs.getInt("id_editora"),rs.getString("razao_social")
                ,rs.getString("endereco"),rs.getInt("telefone"),rs.getBoolean("status")));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public EditoraBEAN findEditora(int id_editora){
        EditoraBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE id_editora=?", id_editora);
        try{
            if(rs.next()){
                result = new EditoraBEAN(rs.getInt("id_editora"),rs.getString("razao_social")
                ,rs.getString("endereco"),rs.getInt("telefone"),rs.getBoolean("status"));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int findId(EditoraBEAN editora){
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE razao_social= ?and endereco = ?"
                + "and telefone=?",editora.getRazao_social(),editora.getEndereco(),editora.getTelefone());
        try{
            if(rs.next()){
                result = rs.getInt("id_editora");
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExistEditora(int id_editora){
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM EDITORA WHERE id_editora= ?",id_editora);
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
