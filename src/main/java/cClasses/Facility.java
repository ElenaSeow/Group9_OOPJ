/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    public Facility(){}
    
    public String getId(){
        return id;
    }
    public String getFacility(){
        return facility;
    }
    public int getCapacity(){
        return capacity;
    }
    public String getStatus(){
        return status;
    }
    public void setFacility(String facility){
        this.facility=facility;
    }
    public void setCapacity(int capacity){
        this.capacity=capacity;
    }
    public void setCapacity(String capacity){
       int cap = Integer.parseInt(capacity);
       this.capacity=cap;
    }
    public void setStatus(String status){
        this.status=status;
    }
    
    public static ArrayList<Facility> Import(){
            BufferedReader br = null;
            ArrayList<Facility> facilities = new ArrayList<>();
        try {

            String file = "Facilities.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                facilities.add(new Facility(list[0],list[1],list[2],list[3]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facilities;
    }
    
    public static void tabulateData(ArrayList<Facility> facilities, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Facility f:facilities){
            String cap = String.valueOf(f.getCapacity());
            String[] allDataRow = {f.getId(),f.getFacility(),cap,f.getStatus()};
            model.addRow(allDataRow);
        }
    }
    public ArrayList<Facility> Update(ArrayList<Facility> facilities, String id){
            PrintWriter pr = null;
        try {
           for(Facility f:facilities){
               String Id = f.getId();
               if(id.equals(Id)){
                   f.setFacility(this.getFacility());
                   f.setStatus(this.getStatus());
                   f.setCapacity(this.getCapacity());
               }
           }   pr = new PrintWriter("Facilities.txt");
           for(Facility i: facilities){ 
                String fid=i.getId();
                String facility =i.getFacility();
                String capacity =String.valueOf(i.getCapacity());
                String status =i.getStatus();
                pr.println(fid+":"+facility+":"+capacity+":"+status);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return facilities;
        }
    public static ArrayList<Facility>Delete(ArrayList<Facility> facilities, String id){
            ArrayList<Facility> newFacilities= new ArrayList<>();
        try {
           for(Facility f:facilities){
               String Id = f.getId();
               if(id.equals(Id)){
               }else{
                   newFacilities.add(f);
               }
           }
               PrintWriter pr = new PrintWriter("Facilities.txt");
               for (Facility i: newFacilities){
                String fid=i.getId();
                String facility =i.getFacility();
                String capacity =String.valueOf(i.getCapacity());
                String status =i.getStatus();
                pr.println(fid+":"+facility+":"+capacity+":"+status);
                       }
               pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newFacilities;

   }
    public static void Write(ArrayList<Facility> facilities){
        PrintWriter pr = null;
        try {
           pr = new PrintWriter("Facilities.txt");
           for(Facility i: facilities){ 
                String fid=i.getId();
                String facility =i.getFacility();
                String capacity =String.valueOf(i.getCapacity());
                String status =i.getStatus();
                pr.println(fid+":"+facility+":"+capacity+":"+status);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
    }
}