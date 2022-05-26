/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Muontra;

/**
 *
 * @author Admin
 */
public class MuontraDao {
    public List<Muontra> getAllMuontras(){
        List<Muontra> muontras = new ArrayList<Muontra>();
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM MUONTRA";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Muontra muontra = new Muontra();
                
                muontra.setMamuon(rs.getString("MAMUON"));
                muontra.setMadg(rs.getString("MADG"));
                muontra.setMasach(rs.getString("MASACH"));
                muontra.setNgaymuon(rs.getString("NGAYMUON"));
                muontra.setNgayhentra(rs.getString("NGAYHENTRA"));
                muontra.setNgaytra(rs.getString("NGAYTRA"));  
                
                muontras.add(muontra);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return muontras;
    }
     
     public Muontra getMuontraByMamuon(String mamuon){
         Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM MUONTRA WHERE MAMUON =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mamuon);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Muontra muontra = new Muontra();
                
                muontra.setMamuon(rs.getString("MAMUON"));
                muontra.setMadg(rs.getString("MADG"));
                muontra.setMasach(rs.getString("MASACH"));
                muontra.setNgaymuon(rs.getString("NGAYMUON"));
                muontra.setNgayhentra(rs.getString("NGAYHENTRA"));
                muontra.setNgaytra(rs.getString("NGAYTRA"));  
                               
                return muontra;
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMuontra(Muontra muontra){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO MUONTRA(MAMUON, MADG, MASACH, NGAYMUON, NGAYHENTRA, NGAYTRA )"+ "VALUES(?,?,?,?,?,?) ";
       
      
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, muontra.getMamuon());
            preparedStatement.setString(2, muontra.getMadg());
            preparedStatement.setString(3, muontra.getMasach());
            preparedStatement.setString(4, muontra.getNgaymuon());
            preparedStatement.setString(5,muontra.getNgayhentra());
            preparedStatement.setString(6, muontra.getNgaytra());          
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(MuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateMuontra(Muontra muontra){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "UPDATE Docgia SET MADG = ?, MASACH = ?, NGAYMUON = ?, NGAYHENTRA = ? ,"+"NGAYTRA=?  WHERE MAMUON =?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, muontra.getMadg());
            preparedStatement.setString(2, muontra.getMasach());
            preparedStatement.setString(3, muontra.getNgaymuon());
            preparedStatement.setString(4,muontra.getNgayhentra());
   
            preparedStatement.setString(5, muontra.getNgaytra());
            preparedStatement.setString(6, muontra.getMamuon());           
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(MuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public void deleteMuontra(String mamuon){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "delete from Muontra where mamuon = ? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,mamuon);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(MuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
}
