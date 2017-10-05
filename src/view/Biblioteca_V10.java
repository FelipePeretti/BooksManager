package view;

import controller.Controle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.EditoraBEAN;

public class Biblioteca_V10 {
    
    static Controle controle = new Controle();
    static ArrayList<EditoraBEAN> lista = new ArrayList<EditoraBEAN>();
    
    private static void inserirEditora(){
        String razao_social,endereço,telefone;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Entre com o nome da Editora: ");
        razao_social = teclado.nextLine();
        System.out.println("Entre com o endereço: ");
        endereço = teclado.nextLine();
        System.out.println("Entre com o telefone: ");
        telefone = teclado.nextLine();
        
        EditoraBEAN editora = new EditoraBEAN(0, razao_social, endereço, Integer.parseInt(telefone), true);
        

        controle.addEditora(editora);
    }
    
    
    private static void listarEditora(){
        List<EditoraBEAN> listaEditora = controle.listaEditoras();

        for (EditoraBEAN editora : listaEditora) {
            System.out.print("RAZAO SOCIAL: ");
            System.out.println(editora.getRazao_social());
            System.out.print("Endereço: ");
            System.out.println(editora.getEndereco());
            System.out.print("Telefone: ");
            System.out.println(editora.getTelefone());
        }
    }
    
    private static void alterar(){
        Integer id;
        String razao_social, endereco, telefone, opcao;
        boolean status;
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Entre com Id da Editora: ");
        id = teclado.nextInt();

        if (controle.isExistEditora(id)) {
            //TODO – A fazer
        }else {System.out.println("Contato não Existe !");}     
    }

    public static void main(String[] args) {
        
        int opcao = 1;
        Scanner numerico = new Scanner(System.in);
        while (opcao != 0){
            System.out.println("1 - Inserir | 2 - Alterar | 3 - Exluir | 4 - Consultar | 5 - Listar | 0 - Sair");
            opcao = numerico.nextInt();
            switch(opcao){
                case 1:
                    inserirEditora();
                break;
                case 2:
                    //alterar();
                break;
                case 5:
                    listarEditora();
                    //new Table();
                break;
            }
        }
        
        
    }
    
}
