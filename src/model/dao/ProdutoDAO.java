
package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.produto;

public class ProdutoDAO {
    
    public void create(produto p){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("Insert INTO clientes (nome_cliente, logradouro, CC, CPF, numero_logra)VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getNome_cliente());
            stmt.setString(2, p.getLogradouro());
            stmt.setFloat(3, p.getCC());
            stmt.setFloat(4, p.getCPF());
            stmt.setInt(5, p.getNumero_logra());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar");
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<produto> read(){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<produto> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                produto Produto = new produto();
                
                Produto.setId(rs.getInt("id"));
                Produto.setNome_cliente(rs.getString("nome_cliente"));
                Produto.setLogradouro(rs.getString("logradouro"));
                Produto.setNumero_Logra(rs.getInt("numero_logra"));
                Produto.setCC(rs.getFloat("CC"));
                Produto.setCPF(rs.getFloat("CPF"));
                clientes.add(Produto);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
    
    public void update(produto p){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome_cliente = ?, logradouro = ?, CC = ?, CPF = ?, numero_logra = ? WHERE id = ?");
            stmt.setString(1, p.getNome_cliente());
            stmt.setString(2, p.getLogradouro());
            stmt.setFloat(3, p.getCC());
            stmt.setFloat(4, p.getCPF());
            stmt.setInt(5, p.getNumero_logra());
            stmt.setInt(6, p.getId());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(produto p) {

        Connection con = connectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            connectionFactory.closeConnection(con, stmt);
        }

    }
}
