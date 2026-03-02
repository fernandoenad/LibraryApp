/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaction;

import java.io.*;
import java.util.*;
import transaction.*;

/**
 *
 * @author fernandoenad
 */
public class TransactionDAOImpl implements TransactionDAO{
    
    private List<Transaction> transactions = new ArrayList<Transaction>();
    private File file;
    
    public TransactionDAOImpl(String filename) {
        file = new File(filename);
        readFromFile();
    }
    
    public boolean add(Transaction transaction){
        this.transactions.add(transaction);
        
        writeToFile();
        return true;
    }
    
    public boolean updateById(int id, Transaction transaction){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        Transaction t = transactions.get(index);
        t.setBook_id(transaction.getBook_id());
        t.setDateDue(transaction.getDateDue());
        t.setStatus(transaction.getStatus());

        writeToFile();
        return true;
    }
    
    public boolean deleteById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        this.transactions.remove(index);
        writeToFile();
        return true;
    }
    
    public Transaction viewById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return null;
        }
        
        return this.transactions.get(index);
    }
    
    public List<Transaction> viewAll(){
        return this.transactions;
    }
    
    public int indexOfId(int id){
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId()== id) {
                return i;
            }
        }
        
        return -1;
    }
    
    public List<Transaction> search(String keyword){
        String lowerKeyword = keyword.toLowerCase();

        return transactions.stream()
            .filter(member ->
                String.valueOf(member.getId()).contains(lowerKeyword)  
            )
            .toList();
    }
    
    
    private boolean readFromFile() {
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.transactions = (ArrayList<Transaction>) ois.readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this.transactions);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Transaction getLastRecord(){
        if (this.transactions == null || this.transactions.isEmpty()) {
            return null; 
        }
        
        return this.transactions.get(this.transactions.size() - 1);
    }
    
    public List<Transaction> viewAllSorted() {
        this.transactions.sort(Comparator.comparing(Transaction::getDateDue));
        
        return this.transactions;
    }
}
