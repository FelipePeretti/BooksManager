package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author - Felipe Peretti -
 */
public class AutorDAO {
    
    
    private static AutorDAO instance;
    
    private AutorDAO(){
        MySQLDAO.getConnection();
    }
    
    public static AutorDAO getInstance(){
        if (instance == null) {
            instance = new AutorDAO();
        }
        return instance;
    }
    
    public long create(AutorBEAN autor){
        String query = "INSERT INTO editora (nome, status) VALUES (?,?)";
        return MySQLDAO.executeQuery(query, autor.getNome(), autor.isStatus());
    }
    
    public void update(AutorBEAN autor){
        String query = "UPDATE AUTOR SET nome=?, status=? WHERE id_autor = ?";
        MySQLDAO.executeQuery(query, autor.getNome(), autor.isStatus(),autor.getId_autor());
    }
    
    public void delete(AutorBEAN autor){
        MySQLDAO.executeQuery("DELETE FROM AUTOR WHERE id_autor = ?",autor.getId_autor());
    }
    
    public ArrayList<AutorBEAN> findAllAutores(){
        return listaAutores("SELECT * FROM AUTOR ORDER BY Nome");
    }
    
    public ArrayList<AutorBEAN> listaAutores(String query){
        ArrayList<AutorBEAN> lista = new ArrayList<AutorBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try{
            while(rs.next()){
                lista.add(new AutorBEAN(rs.getInt("id_autor"),rs.getString("nome"), rs.getBoolean("status")));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public AutorBEAN findAutor(int id_autor){
        AutorBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE id_autor=?", id_autor);
        try{
            if(rs.next()){
                result = new AutorBEAN(rs.getInt("id_editora"),rs.getString("nome"),rs.getBoolean("status"));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int findId(AutorBEAN autor){
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE nome= ?", autor.getNome());
        try{
            if(rs.next()){
                result = rs.getInt("id_autor");
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExistAutor(int id_autor){
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM AUTOR WHERE id_autor= ?",id_autor);
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
