package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author - Felipe Peretti -
 */
public class ObraDAO {
    
    private static ObraDAO instance;
    
    private ObraDAO(){
        MySQLDAO.getConnection();
    }
    
    public static ObraDAO getInstance(){
        if (instance == null) {
            instance = new ObraDAO();
        }
        return instance;
    }
    
    public long create(ObraBEAN obra){
        String query = "INSERT INTO OBRA (id_obra, codigo, titulo, ano, situacao, Editora_id_editora, status) "
                + "VALUES (?,?,?,?,?,?,?)";
        return MySQLDAO.executeQuery(query, obra.getId_obra(), obra.getCodigo(), obra.getTitulo(),
                obra.getAno(), obra.getSituacao(), obra.getEditora_id_editora().getid_editora(), obra.isStatus());
    }
    
    public void update(ObraBEAN obra){
        String query = "UPDATE OBRA SET codigo=?, titulo=?, ano=?, situacao=?, Editora_id_editora=?"
                + "status=? WHERE id_obra = ?";
        MySQLDAO.executeQuery(query, obra.getCodigo(), obra.getTitulo(),
        obra.getAno(), obra.getSituacao(), obra.getEditora_id_editora().getid_editora(), 
        obra.isStatus(), obra.getId_obra());
    }
    
    public void delete(ObraBEAN obra){
        MySQLDAO.executeQuery("DELETE FROM OBRA WHERE id_obra = ?",obra.getId_obra());
    }
    
    public ArrayList<ObraBEAN> findAllObras(){
        return listaObras("SELECT * FROM OBRA ORDER BY Nome");
    }
    
    public ArrayList<ObraBEAN> listaObras(String query){
        ArrayList<ObraBEAN> lista = new ArrayList<ObraBEAN>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try{
            while(rs.next()){
                lista.add(new ObraBEAN(rs.getInt("id_obra"), rs.getInt("codigo"), rs.getString("titulo"),
                rs.getInt("ano"), rs.getBoolean("situacao"), null,
                rs.getBoolean("status")));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public ObraBEAN findObra(int id_obra){
        ObraBEAN result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE id_obra=?", id_obra);
        try{
            if(rs.next()){
                result = new ObraBEAN(rs.getInt("id_obra"), rs.getInt("codigo"), 
                rs.getString("titulo"), rs.getInt("ano"), rs.getBoolean("situacao"), 
                null, rs.getBoolean("status"));
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public int findId(ObraBEAN obra){
        int result = 0;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE codigo= ?", obra.getCodigo());
        try{
            if(rs.next()){
                result = rs.getInt("id_obra");
            }
            rs.close ();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Boolean isExistObra(int id_obra){
        Boolean result = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM OBRA WHERE id_obra= ?",id_obra);
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
