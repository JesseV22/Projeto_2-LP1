/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;


import java.sql.*;

public class ConexaoDAO {
    
    public static Connection con = null;
    
    
    
    
    
    public ConexaoDAO() {       
    }
      public static void ConectDB(){
          try {
              
              String dsn = "Projeto_2";
              String user = "postgres";
              String senha = "postdba";
              DriverManager.registerDriver(new org.postgresql.Driver());
              
              String url = "jdbc:postgresql://localhost:5432/" + dsn;
              
              con = DriverManager.getConnection(url, user, senha);
              
              con.setAutoCommit(false);
              if(con == null) {
                  System.out.println("erro ao abrir  o banco ");
                  
              }
          }
              catch (SQLException e) {
              System.out.println("Problema ao abrir a base de dados!"  +
                      e.getMessage());
              
          }

      }
      
      public static void closeDB(){
          try{
              con.close();
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
      }
        
}
// fecha classe