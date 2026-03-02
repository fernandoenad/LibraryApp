/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.io.Serializable;

/**
 *
 * @author fernandoenad
 */
public class Transaction implements Serializable {
     private static final long serialVersionUID = 1L;
     
     private int id;
     private int member_id; // borrower id
     private int book_id;
     private String dateBorrowed;
     private String dateDue;
     private int status; // 0-Loaned, 1-Returned

    public Transaction(int id, int member_id, int book_id, String dateBorrowed, String dateDue, int status) {
        this.id = id;
        this.member_id = member_id;
        this.book_id = book_id;
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(String dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public String getDateDue() {
        return dateDue;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
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
            status = "Loaned";
        else 
            status = "Returned";
        
        return status;
    }
}
