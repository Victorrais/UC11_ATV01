/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto (ProdutosDTO produto)throws SQLException{
        var conDao=new conectaDAO();
        conn=conDao.connectDB();

        var query="insert into produtos(nome, valor, status) values(?,?,?)";

            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setString(1,produto.getNome());
            pstmt.setInt(2,produto.getValor());
            pstmt.setString(3,produto.getStatus());

            pstmt.executeUpdate();


    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

