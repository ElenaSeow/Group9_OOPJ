/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

/**
 *
 * @author User
 */
public class Employee {
    private String id;
    private String name;
    private String role;
    private String contactNo;
    
    public Employee(String id, String name, String role, String contactNo){
        this.id=id;
        this.name=name;
        this.role=role;
        this.contactNo=contactNo;
    }
    public Employee(){}
    
    public void setID(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setRole(String role){
        this.role=role;
    }
    public void setContactNo(String contactNo){
        this.contactNo=contactNo;
    }
    public String getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }
    public String getContactNo(){
        return contactNo;
    }
    
    
}
