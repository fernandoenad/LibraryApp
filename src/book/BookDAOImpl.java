/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book;

import java.io.*;
import java.util.*;
/**
 *
 * @author fernandoenad
 */
public class BookDAOImpl implements BookDAO {
    private List<Book> books = new ArrayList<Book>();
    private File file;
    
    public BookDAOImpl(String filename) {
        file = new File(filename);
        readFromFile();
    }
    
    public boolean add(Book book){
        this.books.add(book);
        
        writeToFile();
        return true;
    }
    
    public boolean updateById(int id, Book book){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        Book b = books.get(index);
        b.setIsbn(book.getIsbn());
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPublisher(book.getPublisher());
        b.setYearPublished(book.getYearPublished());
        b.setCategory(book.getCategory());
        b.setStatus(book.getStatus());

        writeToFile();
        return true;
    }
    
    public boolean deleteById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        this.books.remove(index);
        writeToFile();
        return true;
    }
    
    public Book viewById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return null;
        }
        
        return this.books.get(index);
        
    }
    
    public List<Book> viewAll(){
        return this.books;
    }
    
    public int indexOfId(int id){
    for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getId()== id) {
                return i;
            }
        }
        return -1;
    }
    
    public List<Book> search(String str){
        String lowerStr = str.toLowerCase();

        return books.stream()
            .filter(book ->
                String.valueOf(book.getId()).contains(lowerStr) ||
                String.valueOf(book.getIsbn()).contains(lowerStr) ||
                book.getTitle().toLowerCase().contains(lowerStr) ||
                book.getAuthor().toLowerCase().contains(lowerStr) ||
                book.getCategory().toLowerCase().contains(lowerStr)
            )
            .toList();
    }
    
    
    private boolean readFromFile() {
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.books = (ArrayList<Book>) ois.readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this.books);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Book getLastRecord(){
        if (this.books == null || this.books.isEmpty()) {
            return null; 
        }
        
        return this.books.get(this.books.size() - 1);
    }
    
    public List<Book> viewAllSorted() {
        this.books.sort(Comparator.comparing(Book::getTitle));
        
        return this.books;
    }
}
