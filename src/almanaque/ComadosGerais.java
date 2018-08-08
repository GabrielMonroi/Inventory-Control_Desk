/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almanaque;

import SQL.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Biel
 */
public class ComadosGerais {
    

    public void create(Produto p) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO material (nome,categoria,quantidade)VALUES(?,?,?)");
            stmt.setString(1, p.getDescricao());
            
            stmt.setString(2, p.getCat());
            stmt.setInt(3, p.getQtd());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     public void createSainda(Cliente c) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO saida (cliente,produto,quantidade)VALUES(?,?,?)");
            stmt.setString(1, c.getCliente());
            stmt.setString(2, c.getDesc());     
            stmt.setInt(3, c.getQtd());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM material");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("nome"));
                
                produto.setCat(rs.getString("categoria"));
                produto.setQtd(rs.getInt("quantidade"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComadosGerais.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    public List<Produto> readForDesc(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM material WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("nome"));  
                produto.setCat(rs.getString("categoria"));
                produto.setQtd(rs.getInt("quantidade"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComadosGerais.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
        public List<Cliente> read2() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> cliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM saida");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setCliente(rs.getString("cliente"));
                c.setDesc(rs.getString("produto"));
                c.setQtd(rs.getInt("quantidade"));
                c.setData(rs.getString("Data"));
                cliente.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComadosGerais.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;

    }
    public List<Cliente> readForDesc2(String desc) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> cliente = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM saida WHERE cliente LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

             Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setCliente(rs.getString("cliente"));
                c.setDesc(rs.getString("produto"));
                c.setQtd(rs.getInt("quantidade"));
                c.setData(rs.getString("Data"));
                cliente.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ComadosGerais.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return cliente;

    }


    public void update(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE material SET nome = ? ,categoria = ?,quantidade = ? WHERE id = ?");
            stmt.setString(1, p.getDescricao());       
            stmt.setString(2, p.getCat());
            stmt.setInt(3, p.getQtd());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     public void updateSaida(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        

        try {
            
            
            
            stmt = con.prepareStatement("UPDATE material SET quantidade = ? WHERE id = ?");
            
            stmt.setInt(1, p.getQtdnova());
            stmt.setInt(2, p.getId());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Saida feita com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
     
    public void delete(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM material WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
