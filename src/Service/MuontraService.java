/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.MuontraDao;
import Dao.SachDao;
import java.util.List;
import model.Muontra;
import model.Sach;

/**
 *
 * @author Admin
 */
public class MuontraService {
    private MuontraDao muontraDao;
    public MuontraService(){
        muontraDao = new MuontraDao();
    }
     public List<Muontra> getAllMuontras(){
        return muontraDao.getAllMuontras();
     }
    public void addMuontra(Muontra muontra){
        muontraDao.addMuontra(muontra);
    }
    public void deleteMuontra(String mamuon){
        muontraDao.deleteMuontra(mamuon);
    }
    public Muontra getSachByMamuon(String mamuon){
        return muontraDao.getMuontraByMamuon(mamuon);
    }
    public void updateMuontra(Muontra muontra){
        muontraDao.updateMuontra(muontra);
    }
}
