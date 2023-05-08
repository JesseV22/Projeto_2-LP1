/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;

import java.sql.*;
import br.com.projeto_2.dto.FornecedorDTO;
import java.text.SimpleDateFormat;

public class FornecedorDAO {

    /**
     * Metodo construir
     */
    public FornecedorDAO() {
    }
    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
    //Atributos do tipo resutSet utilizado para realizar consultas
    private ResultSet rs = null;
    //Manipular o banco de Dados 
    private Statement stmt = null;

    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO fornecedor (nome_for, cnpj_for, "
         + "tel_for, date_cad_for )values ("
         + "'" +fornecedorDTO.getNome_for()+ "', "
         + "'" +fornecedorDTO.getCnpj_for()+ "', "
         + "'" +fornecedorDTO.getTel_for()+ "', " 
         + "to_date('" + data_format.format(fornecedorDTO.getData_cad_for())+ "','dd/mm/yyyy')"
         +")";           
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
                    
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            
            ConexaoDAO.closeDB();
            
        }
    }
    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update fornecedor set"
         +"nome_for = '" + fornecedorDTO.getNome_for()+"',"
         +"cnpj_for = '" + fornecedorDTO.getCnpj_for()+"',"
         +"Tel_for = '" + fornecedorDTO.getTel_for()+"',"  
         +"data_cad_for = to_date('" + data_format.format(fornecedorDTO.getData_cad_for())+"', 'dd/mm/yyyy " ;
         
            
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
                    
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            
            ConexaoDAO.closeDB();
            
        }
    }
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        try {

            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select f.id_for, f.nome_for "+
                             "from fornecedor f "+
                             "where nome_for like '" + fornecedorDTO.getNome_for() + "%' "+
                             "order by f.nome_for";
                    break;
                case 2:
                    comando = "Select f.nome_for, f.cnpj_for, f.tel_for, "+
                              "to_char(f.data_cad_foor,'dd/mm/yyyy') as data_cad_for"+
                            "from fornecedor f "+
                            "where f.id_for = " + fornecedorDTO.getId_for();
                    break;
                                    
            }
            System.out.println(comando);
            rs = stmt.executeQuery(comando.toUpperCase());
                    return rs;
                    
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
}//fechar o metodo inserirFornecedor
