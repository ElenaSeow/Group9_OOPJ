/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Complaint {
    ArrayList<Complaint> complaints = new ArrayList<Complaint>();
    String complaintId;
    String desc;
    String status;
    String userID;
    Date updateDate;
    Date complaintDate;
    
    public Complaint(String complaintId, String desc, String status, Date complaintDate, Date updateDate){
        this.complaintId=complaintId;
        this.desc=desc;
        this.status=status;
        this.updateDate=updateDate;
        this.complaintDate=complaintDate;
    }
    
   
}

