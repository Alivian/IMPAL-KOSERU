package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public abstract class User {
        protected String username;
    protected String pass;

    public User(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    abstract String getUsername();

    abstract String getPassword();

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
