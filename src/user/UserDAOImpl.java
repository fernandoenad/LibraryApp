/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user;

import java.io.*;
import java.util.*;

/**
 *
 * @author fernandoenad
 */
public class UserDAOImpl implements UserDAO{
    private List<User> users = new ArrayList<User>();
    private File file;
    
    public UserDAOImpl(String filename) {
        file = new File(filename);
        readFromFile();
    }
    
    public boolean add(User user){
        this.users.add(user);
        
        writeToFile();
        return true;
    }
    
    public boolean updateById(int id, User user){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        User u = users.get(index);
        u.setMemberId(user.getMemberId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setStatus(user.getStatus());

        writeToFile();
        return true;
    }
        
    public User viewById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return null;
        }
        
        return this.users.get(index);
    }
    
    public List<User> viewAll(){
        return this.users;
    }
    
    public int indexOfId(int id){
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getId()== id) {
                return i;
            }
        }
        
        return -1;
    }
    
    public List<User> search(String keyword){
        String lowerKeyword = keyword.toLowerCase();

        return users.stream()
            .filter(user ->
                String.valueOf(user.getId()).contains(lowerKeyword) ||
                user.getUsername().toLowerCase().contains(lowerKeyword) ||
                user.getUsername().toLowerCase().contains(lowerKeyword)        
            )
            .toList();
    }
    
    
    private boolean readFromFile() {
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.users = (ArrayList<User>) ois.readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this.users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public User getLastRecord(){
        if (this.users == null || this.users.isEmpty()) {
            return null; 
        }
        
        return this.users.get(this.users.size() - 1);
    }
}
