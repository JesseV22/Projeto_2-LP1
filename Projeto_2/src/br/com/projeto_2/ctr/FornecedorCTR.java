
package br.com.projeto_2.ctr;
import br.com.projeto_2.dao.ConexaoDAO;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dao.FornecedorDAO;


public class FornecedorCTR {
    //Nesta classe iremos criar métodos que irão fazer a  ligacao da classe VIEW 
    //com a classse DAO.Vamos instanciar
    FornecedorDAO clienteDAO = new FornecedorDAO() ;
    
    public FornecedorCTR() {}
        
    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            if(clienteDAO.inserirFornecedor(fornecedorDTO)){
                return "Fornecedor Cadastrado com sucesso!!!" ;
            }else{
                return"Fornecedor NÂO Cadastrado!!!";                    
            }
        }
        catch (Exception e ){
            System.out.print(e.getMessage());
            return "Fornecedor NÂO Cadastrado";
        }
    }
       
    
 public ResultSet consultarFornecedor(FornecedorDTO  fornecedorDTO, int opcao ) {
        
        ResultSet rs = null;
        
        
        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
        
    }
    
    /**
     * Metodo utilizado para fechar o banco de dados 
     */
   public void CloseDB() {
       ConexaoDAO.closeDB();
   } //Fechar Metodo CloseDB

    public Object excluirFornecedor(FornecedorDTO fornecedorDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}