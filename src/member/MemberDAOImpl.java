/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import java.io.*;
import java.util.*;
/**
 *
 * @author fernandoenad
 */
public class MemberDAOImpl implements MemberDAO {
    private List<Member> members = new ArrayList<Member>();
    private File file;
    
    public MemberDAOImpl(String filename) {
        file = new File(filename);
        readFromFile();
    }
    
    public boolean add(Member member){
        this.members.add(member);
        
        writeToFile();
        return true;
    }
    
    public boolean updateById(int id, Member member){
        int index = indexOfId(id);
        if (index == -1) {
            return false;
        }
        
        Member m = members.get(index);
        m.setName(member.getName());
        m.setEmail(member.getEmail());
        m.setContactNumber(member.getContactNumber());
        m.setAddress(member.getAddress());
        m.setDateJoined(member.getDateJoined());
        m.setStatus(member.getStatus());

        writeToFile();
        return true;
    }
    
    public boolean deleteById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return false;
        }
        
        this.members.remove(index);
        writeToFile();
        return true;
    }
    
    public Member viewById(int id){
        int index = indexOfId(id);
        
        if (index == -1) {
            return null;
        }
        
        return this.members.get(index);
        
    }
    
    public List<Member> viewAll(){
        return this.members;
    }
    
    public int indexOfId(int id){
    for (int i = 0; i < this.members.size(); i++) {
            if (this.members.get(i).getId()== id) {
                return i;
            }
        }
        return -1;
    }
    
    public List<Member> search(String keyword){
        String lowerKeyword = keyword.toLowerCase();

        return members.stream()
            .filter(member ->
                String.valueOf(member.getId()).contains(lowerKeyword) ||
                member.getName().toLowerCase().contains(lowerKeyword) ||
                member.getEmail().toLowerCase().contains(lowerKeyword) ||
                member.getContactNumber().toLowerCase().contains(lowerKeyword)
            )
            .toList();
    }
    
    
    private boolean readFromFile() {
        if (!file.exists() || file.length() == 0) {
            return false;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            this.members = (ArrayList<Member>) ois.readObject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this.members);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Member getLastRecord(){
        if (this.members == null || this.members.isEmpty()) {
            return null; 
        }
        
        return this.members.get(this.members.size() - 1);
    }
}
