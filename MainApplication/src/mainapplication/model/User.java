/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapplication.model;

/**
 *
 * @author SERGEN
 */
public class User {
    private int id;
    private int roleId;
    private String username;
    private String firstName;
    private String lastName;
    private int password;

    public User() {
    }

    User(String username,int password)
    {
       this.username = username;
       this.password = password;
    }
    public int getid(){
        return id;
    }
    public int getroleId(){
        return roleId;
    }
    public String getusername(){
        return username;
    }
    public String getfirstName(){
        return firstName;
    }
    public String getlastName(){
        return lastName;
    }
    public int getpassword(){
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    

}
