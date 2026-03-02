/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package user;

import java.util.*;
import user.User;

/**
 *
 * @author fernandoenad
 */
public interface UserDAO {
    public boolean add(User user);
    public boolean updateById(int id, User user);
    public  User viewById(int id);
    public List<User> viewAll();
    public  int indexOfId(int id);
    public List<User> search(String keyword);
}
