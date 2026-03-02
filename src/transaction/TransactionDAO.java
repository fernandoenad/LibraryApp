/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package transaction;

import java.util.*;
import transaction.*;

/**
 *
 * @author fernandoenad
 */
public interface TransactionDAO {
    public boolean add(Transaction transaction);
    public boolean updateById(int id, Transaction transaction);
    public boolean deleteById(int id);
    public  Transaction viewById(int id);
    public List<Transaction> viewAll();
    public  int indexOfId(int id);
    public List<Transaction> search(String keyword);
}
