/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package member;

import java.util.List;

/**
 *
 * @author fernandoenad
 */
public interface MemberDAO {
    public boolean add(Member member);
    public boolean updateById(int id, Member member);
    public boolean deleteById(int id);
    public  Member viewById(int id);
    public List<Member> viewAll();
    public  int indexOfId(int id);
    public List<Member> search(String keyword);
}
