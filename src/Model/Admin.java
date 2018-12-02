package Model;


import Model.User;
import Model.Simpanan;
import Model.Person;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Admin extends User {

    public Admin(String username, String pass) {
        super(username, pass);
    }
    
    public void applySimpan(Person app, int uang){
    }
    
    public void setReqPinjam(List reqPinjam) {
    }

    public void setApplysimpan(Simpanan applysimpan) {
    }

    @Override
    String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
