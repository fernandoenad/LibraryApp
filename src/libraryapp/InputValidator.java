/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryapp;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author fernandoenad
 */
public class InputValidator {
    
    public Boolean validateInteger(String str){        
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    public Boolean validateDouble(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public Boolean validateString(String str, int size){
        if (str.length() == 0 || str.length() <= size) {
            return false;
        }

        return true;
    }
    
    public boolean validatePhoneNumber(String str) {
        String phoneRegex = "^[0-9]{7,11}$";
        
        return str.matches(phoneRegex);
    }
    
    public boolean validateDate(String str) {
        try {
            LocalDate.parse(str); 
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public boolean validateEmail(String str) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        
        return str.matches(emailRegex);
    }
}
