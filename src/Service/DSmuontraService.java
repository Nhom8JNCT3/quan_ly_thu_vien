/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.DSmuontraDao;
import java.util.List;
import model.DSmuontra;


/**
 *
 * @author Admin
 */
public class DSmuontraService {
    private DSmuontraDao dsmuontraDao;
    public DSmuontraService(){
        dsmuontraDao = new DSmuontraDao();
    }
     public List<DSmuontra> getAllDSmuontras(){
        return dsmuontraDao.getAllDSmuontras();
     }
    public void addSach(DSmuontra dsmuontra){
        dsmuontraDao.addDSmuontra(dsmuontra);
    }
    public void deleteDSmuontra(String msmuon){
        dsmuontraDao.deleteDSmuontra(msmuon);
    }
    public DSmuontra getDSmuontraByMSmuon(String msmuon){
        return dsmuontraDao.getDSmuontraByMSmuon(msmuon);
    }
    public void updateDSmuontra(DSmuontra dsmuontra){
        dsmuontraDao.updateDSmuontra(dsmuontra);
    }
}
