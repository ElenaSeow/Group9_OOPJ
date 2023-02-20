/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

/**
 *
 * @author HP
 */
public class Vendor extends User {
    
    public Vendor(String id, String name, String email, String password, String role, String contactNo) {
        super(id, name, email, password, role, contactNo);
        
    }
    
    public void setName(String name) {
        super.setName(name);
    }
}
