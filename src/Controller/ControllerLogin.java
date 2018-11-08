/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseUser;
import View.Login;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author ASUS
 */
public class ControllerLogin {
    private View.Login vLogin;
    private Model.Person mPerson;
    private final DatabaseUser akun= new DatabaseUser();
    public ControllerLogin(){
        this.vLogin=new View.Login();
        this.vLogin.addListener(new LoginListener());
        this.vLogin.setVisible(true);
    }
    class LoginListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Object x = e.getSource();
            if (x.equals(vLogin.getbtnLogin())){
//                ControllerPerusahaan cpr = new ControllerPerusahaan(app);
                if(akun.login(vLogin.getUsername(),vLogin.getPassword())==1){
                    vLogin.dispose();
                    System.out.println("SUCCESS");
                }else{
                    System.out.println("GAGAL");
                }
            } else if (x.equals(vLogin.getbtnExit())){
//                ControllerPelamar cpl = new ControllerPelamar(app);
                vLogin.dispose();
            }else if (x.equals((MouseListener) vLogin.getlabelDaftar())){
                vLogin.dispose();
                System.out.println("DAFTAR");
            }
            else{
                System.out.println("GAGAL");
            }
        }
    }

    
}
