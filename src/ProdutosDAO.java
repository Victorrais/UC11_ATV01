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
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    

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
    
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException{
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        var conDao=new conectaDAO();
        conn=conDao.connectDB();
        
        var query="select * from produtos";
        
        Statement stmt=conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            var p = new ProdutosDTO();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setStatus(rs.getString("status"));
            p.setValor(rs.getInt("valor"));
            listagem.add(p);
        }
        
        return listagem;
    }
    
    
    
        
}

