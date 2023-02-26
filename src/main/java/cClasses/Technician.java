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
public class Technician extends Employee {
     public Technician(String id, String name, String role, String contactNo){
        super(id,name,role,contactNo);
    }
     public Technician(){}
     
     public ArrayList<Technician> Import() {
        BufferedReader br = null;
        ArrayList<Technician> technicians = new ArrayList<>();
        try {
            String file = "Technician.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                technicians.add(new Technician(list[0],list[1],list[2],list[3]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
            }
        return technicians;
        }
   
   public static void tabulateData(ArrayList<Technician> technicians,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Technician t: technicians){
            String[] allDataRow = {t.getId(),t.getName(),t.getRole(),t.getContactNo()};
            model.addRow(allDataRow);
        }
    }
   public ArrayList<Technician> Update(ArrayList<Technician> technicians, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Technician t:technicians){
            String Id = t.getId();
            if(id.equals(Id)){
                t.setName(this.getName());
                t.setRole(this.getRole());
                t.setContactNo(this.getContactNo());
                
                data.add(t.getId()+":"+t.getName()+":"+t.getRole()+":"+t.getContactNo());
            }else{
                data.add(t.getId()+":"+t.getName()+":"+t.getRole()+":"+t.getContactNo());
            }
        }   pr = new PrintWriter("Technician.txt");
        for(String i:data){
            
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return technicians;
    }
    
     public static ArrayList<Technician>Delete(ArrayList<Technician> technicians, String id){
            ArrayList<Technician> newTechnicians= new ArrayList<>();
        try {
           for(Technician t:technicians){
               String Id = t.getId();
               if(id.equals(Id)){
               }else{
                   newTechnicians.add(t);
               }
           }
               PrintWriter pr = new PrintWriter("Technician.txt");
                for (Technician i: technicians){
                    String ID = i.getId();
                    String name=i.getName();
                    String role = i.getRole();
                    String contactNo=i.getContactNo();
                    pr.println(ID+":"+name+":"+role+":"+contactNo);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newTechnicians;
     }
    
    public static void Write(ArrayList<Technician> technicians){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Security.txt");
            for (Technician i: technicians){
                String id=i.getId();
                String name=i.getName();
                String role = i.getRole();
                String contactNo=i.getContactNo();
                pr.println(id+":"+name+":"+role+":"+contactNo);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Technician.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
