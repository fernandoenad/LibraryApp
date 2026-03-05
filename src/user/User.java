/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.io.Serializable;
import member.Member;
/**
 *
 * @author fernandoenad
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int memberId;
    private String username;
    private String password;
    private int role; // 0-staff, 1-admin
    private int status; // 0-inactive, 1-active

    public User(int id, int memberId, String username, String password, int role, int status) {
        this.id = id;
        this.memberId = memberId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    public String getRoleLabel() {
        String label = "";  
        
        if(this.role == 0)        
            label = "Staff";
        else 
            label = "Admin";
        
        return label;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatusRemarks() {
        String status = "";  
        
        if(this.status == 0)        
            status = "Inactive";
        else 
            status = "Active";
        
        return status;
    }
}
