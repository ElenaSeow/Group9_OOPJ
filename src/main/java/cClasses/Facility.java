/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

/**
 *
 * @author User
 */
public class Facility {
    private String id;
    private String facility;
    private int capacity;
    private String status;
    
    public Facility(String id, String facility, int capacity, String status){
        this.id=id;
        this.facility=facility;
        this.capacity=capacity;
        this.status=status;
    }
    public Facility(String id, String facility, String capacity, String status){
        int cap=Integer.parseInt(capacity);   
        this.id=id;
        this.facility=facility;
        this.capacity=cap;
        this.status=status;
    }
}
