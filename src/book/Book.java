/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import java.io.Serializable;

/**
 *
 * @author fernandoenad
 */
public class Book implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
    private int status; // 0-archived, 1-available

    public Book(int id, int isbn, String title, String author, String publisher, int yearPublished, String category, int status) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getStatusRemarks() {
        String status = "";  
        
        if(this.status == 0) {       
            status = "Archived";
        } else {
            status = "Available";
        }
        
        return status;
    }
    
    @Override
    public String toString() {
        return this.title;
    }
}
