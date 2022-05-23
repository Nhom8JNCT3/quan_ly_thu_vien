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
import model.DSmuontra;


/**
 *
 * @author Admin
 */
public class DSmuontraDao {
    public List<DSmuontra> getAllDSmuontras(){
        List<DSmuontra> dsmuontras = new ArrayList<DSmuontra>();
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM THEODOIMUONTRA";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                DSmuontra dsmuontra = new DSmuontra();
                
                dsmuontra.setMsmuon(rs.getString("MSMUON"));
                dsmuontra.setMadocgia(rs.getString("MADOCGIA"));               
                dsmuontra.setMasach(rs.getString("MASACH"));
                dsmuontra.setNgaymuon(rs.getString("NGAYMUON"));
                dsmuontra.setNgayhethan(rs.getString("NGAYHETHAN"));
                dsmuontra.setNgaytra(rs.getString("NGAYTRA"));
                
                
                dsmuontras.add(dsmuontra);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsmuontras;
    }
    
     public DSmuontra getDSmuontraByMSmuon(String msmuon){
         Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM THEODOIMUONTRA WHERE MSMUON =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, msmuon);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                DSmuontra dsmuontra = new DSmuontra();
                
                dsmuontra.setMsmuon(rs.getString("MSMUON"));
                dsmuontra.setMadocgia(rs.getString("MADOCGIA"));
                
                dsmuontra.setMasach(rs.getString("MASACH"));
                dsmuontra.setNgaymuon(rs.getString("NGAYMUON"));
                dsmuontra.setNgayhethan(rs.getString("NGAYHETHAN"));
                dsmuontra.setNgaytra(rs.getString("NGAYTRA"));
               
                
                return dsmuontra;
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDSmuontra(DSmuontra dsmuontra){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO THEODOIMUONTRA(MSMUON, MADOCGIA, MASACH, NGAYMUON, NGAYHETHAN, NGAYTRA)"+ "VALUES(?,?,?,?,?,?) ";
       
      
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dsmuontra.getMsmuon());
            preparedStatement.setString(2, dsmuontra.getMadocgia());
            preparedStatement.setString(3, dsmuontra.getMasach());
            preparedStatement.setString(4, dsmuontra.getNgaymuon());
            preparedStatement.setString(5,dsmuontra.getNgayhethan());
            preparedStatement.setString(6, dsmuontra.getNgaytra());
            
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DSmuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateDSmuontra(DSmuontra dsmuontra){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "UPDATE THEODOIMUONTRA SET MADOCGIA = ?, MASACH = ?, NGAYMUON = ?, NGAYHETHAN = ?, NGAYTRA = ?," + "  WHERE MSMUON =?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dsmuontra.getMadocgia());
            preparedStatement.setString(2, dsmuontra.getMasach());
            preparedStatement.setString(3, dsmuontra.getNgaymuon());
            preparedStatement.setString(4,dsmuontra.getNgayhethan());
   
            preparedStatement.setString(5, dsmuontra.getNgaytra());
            preparedStatement.setString(6, dsmuontra.getMsmuon());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DSmuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public void deleteDSmuontra(String msmuon){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "delete from Theodoimuontra where msmuon = ? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,msmuon);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DSmuontraDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
}
