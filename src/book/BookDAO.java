/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package book;

import java.util.List;

/**
 *
 * @author fernandoenad
 */
public interface BookDAO {
    public boolean add(Book book);
    public boolean updateById(int id, Book book);
    public boolean deleteById(int id);
    public  Book viewById(int id);
    public List<Book> viewAll();
    public  int indexOfId(int id);
    public List<Book> search(String keyword);
}
