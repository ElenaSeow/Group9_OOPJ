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
public class Cleaner extends Employee {
     public Cleaner(String id, String name, String role, String contactNo){
        super(id,name,role,contactNo);
    }
     public Cleaner(){}
     
     public ArrayList<Cleaner> Import() {
        BufferedReader br = null;
        ArrayList<Cleaner> cleaners = new ArrayList<>();
        try {
            String file = "Cleaner.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                cleaners.add(new Cleaner(list[0],list[1],list[2],list[3]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, ex);
            }
        return cleaners;
        }
   
   public static void tabulateData(ArrayList<Cleaner> cleaners,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Cleaner t: cleaners){
            String[] allDataRow = {t.getId(),t.getName(),t.getRole(),t.getContactNo()};
            model.addRow(allDataRow);
        }
    }
   public ArrayList<Cleaner> Update(ArrayList<Cleaner> cleaners, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Cleaner c:cleaners){
            String Id = c.getId();
            if(id.equals(Id)){
                c.setName(this.getName());
                c.setRole(this.getRole());
                c.setContactNo(this.getContactNo());
                
                data.add(c.getId()+":"+c.getName()+":"+c.getRole()+":"+c.getContactNo());
            }else{
                data.add(c.getId()+":"+c.getName()+":"+c.getRole()+":"+c.getContactNo());
            }
        }   pr = new PrintWriter("Cleaner.txt");
        for(String i:data){
            
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return cleaners;
    }
    
     public static ArrayList<Cleaner>Delete(ArrayList<Cleaner> cleaners, String id){
            ArrayList<Cleaner> newCleaners= new ArrayList<>();
        try {
           for(Cleaner t:cleaners){
               String Id = t.getId();
               if(id.equals(Id)){
               }else{
                   newCleaners.add(t);
               }
           }
               PrintWriter pr = new PrintWriter("Cleaner.txt");
                for (Cleaner i: cleaners){
                    String ID = i.getId();
                    String name=i.getName();
                    String role = i.getRole();
                    String contactNo=i.getContactNo();
                    pr.println(ID+":"+name+":"+role+":"+contactNo);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newCleaners;
     }
    
    public static void Write(ArrayList<Cleaner> cleaners){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Security.txt");
            for (Cleaner i: cleaners){
                String id=i.getId();
                String name=i.getName();
                String role = i.getRole();
                String contactNo=i.getContactNo();
                pr.println(id+":"+name+":"+role+":"+contactNo);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Cleaner.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
