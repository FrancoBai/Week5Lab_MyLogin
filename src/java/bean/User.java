/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author 829942
 */
public class User {
    private String username;
    private String password;
    
    public User(){
        
    }
    public User(String username){
        this.username = username;
        this.password = null;
    }
}
