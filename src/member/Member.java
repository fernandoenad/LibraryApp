/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import java.io.Serializable;
/**
 *
 * @author fernandoenad
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private String dateJoined;
    private int status; // 0-archived, 1-available

    public Member(int id, String name, String email, String contactNumber, String address, String dateJoined, int status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
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
            status = "Archived";
        else 
            status = "Available";
        
        return status;
    }
}
