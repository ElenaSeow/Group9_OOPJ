/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.util.ArrayList;

/**
 *
 * @author HP
 */

 abstract public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String contactNo;
    
 
    
    
    public User(String id, String name, String email, String password, String role, String contactNo){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        this.role=role;
        this.contactNo=contactNo;
    }
    public User(){}
    
    public User(String id){
        this.id=id;
    }
    
    public void setName(String name){
       this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setId(String id){
        this.id = id;  
    }
    public String getId(){
        return this.id;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }
   public void setContactNo(String contactNo){
       this.contactNo=contactNo;
   }
   public String getContactNo(){
       return contactNo;
   }
   public abstract ArrayList<?> Import();
   
 }

