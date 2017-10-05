package controller;

import java.util.ArrayList;
import model.AutorBEAN;
import model.AutorDAO;
import model.ClienteBEAN;
import model.ClienteDAO;
import model.EditoraBEAN;
import model.EditoraDAO;
import model.EnderecoBEAN;
import model.EnderecoDAO;
import model.ObraBEAN;
import model.ObraDAO;

/**
 *
 * @author - Felipe Peretti -
 */
public class Controle {
    
    
    public Controle(){
    }
    
    //*************** AUTOR *************************
    
    public void addAutor(AutorBEAN autor){
        AutorDAO.getInstance().create(autor);
    }
    public void updateAutor(AutorBEAN autor){
        AutorDAO.getInstance().update(autor);
    }
    public void deleteAutor(AutorBEAN autor){
        AutorDAO.getInstance().delete(autor);
    }

    public AutorBEAN findAutor(int id){
        return AutorDAO.getInstance().findAutor(id);
    }
    public int findIdAutor(AutorBEAN autor){
        return AutorDAO.getInstance().findId(autor);
    }

    public Boolean isExistAutor(int id){
        return AutorDAO.getInstance().isExistAutor(id);
    }

    public ArrayList<AutorBEAN> listaAutores(){
        return AutorDAO.getInstance().findAllAutores();
    } 
    
    //**********************************************************
    
    //*************** EDITORA *************************
    
    public void addEditora(EditoraBEAN editora){
        EditoraDAO.getInstance().create(editora);
    }
    public void updateEditora(EditoraBEAN editora){
        EditoraDAO.getInstance().update(editora);
    }
    public void deleteEditora(EditoraBEAN editora){
        EditoraDAO.getInstance().delete(editora);
    }

    public EditoraBEAN findEditora(int id){
        return EditoraDAO.getInstance().findEditora(id);
    }
    public int findIdEditora(EditoraBEAN editora){
        return EditoraDAO.getInstance().findId(editora);
    }

    public Boolean isExistEditora(int id){
        return EditoraDAO.getInstance().isExistEditora(id);
    }

    public ArrayList<EditoraBEAN> listaEditoras(){
        return EditoraDAO.getInstance().findAllEditora();
    } 
    
    public ArrayList<EditoraBEAN> listaLikeNameEditora(String razao_social){
        return EditoraDAO.getInstance().findLikeNameEditora(razao_social);
    }
    
    //**********************************************************
    
    //*************** OBRA *************************
    
    public void addObra(ObraBEAN obra){
        ObraDAO.getInstance().create(obra);
    }
    public void updateObra(ObraBEAN obra){
        ObraDAO.getInstance().update(obra);
    }
    public void deleteObra(ObraBEAN obra){
        ObraDAO.getInstance().delete(obra);
    }

    public ObraBEAN findObra(int id){
        return ObraDAO.getInstance().findObra(id);
    }
    public int findIdObra(ObraBEAN obra){
        return ObraDAO.getInstance().findId(obra);
    }

    public Boolean isExistObra(int id){
        return ObraDAO.getInstance().isExistObra(id);
    }

    public ArrayList<ObraBEAN> listaObras(){
        return ObraDAO.getInstance().findAllObras();
    } 
    
    //**********************************************************
    
    //*************** ENDEREÇO *************************
    
    public void addEndereco(EnderecoBEAN endereco){
        EnderecoDAO.getInstance().create(endereco);
    }
    public void updateEndereco(EnderecoBEAN endereco){
        EnderecoDAO.getInstance().update(endereco);
    }
    public void deleteEndereco(EnderecoBEAN endereco){
        EnderecoDAO.getInstance().delete(endereco);
    }

    public EnderecoBEAN findEndereco(int id){
        return EnderecoDAO.getInstance().findEndereco(id);
    }
    public int findIdEndereco(EnderecoBEAN endereco){
        return EnderecoDAO.getInstance().findId(endereco);
    }

    public Boolean isExistEndereco(int id){
        return EnderecoDAO.getInstance().isExistEndereco(id);
    }

    public ArrayList<EnderecoBEAN> listaEnderecos(){
        return EnderecoDAO.getInstance().findAllEnderecos();
    } 
    
    //**********************************************************
    
    //*************** CLIENTE *************************
    
    public void addCliente(ClienteBEAN cliente){
        ClienteDAO.getInstance().create(cliente);
    }
    public void updateCliente(ClienteBEAN cliente){
        ClienteDAO.getInstance().update(cliente);
    }
    public void deleteCliente(ClienteBEAN cliente){
        ClienteDAO.getInstance().delete(cliente);
    }

    public ClienteBEAN findCliente(int id){
        return ClienteDAO.getInstance().findCliente(id);
    }
    public int findIdCliente(ClienteBEAN cliente){
        return ClienteDAO.getInstance().findId(cliente);
    }

    public Boolean isExistCliente(int id){
        return ClienteDAO.getInstance().isExistCliente(id);
    }

    public ArrayList<ClienteBEAN> listaClientes(){
        return ClienteDAO.getInstance().findAllClientes();
    } 
    
    //**********************************************************
    
}
