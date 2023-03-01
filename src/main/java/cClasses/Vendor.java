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
 * @author HP
 */
public class Vendor extends User {
    private String unitId;
    
    public Vendor(String id, String name, String email, String password, String role, String contactNo, String unitId) {
        super(id, name, email, password, role, contactNo);
        this.unitId=unitId;
        
    }
    public Vendor(){}
    
    public void setName(String name) {
        super.setName(name);
    }
    public void setUnitId(String unitId){
        this.unitId=unitId;
    }
    public String getUnitId(){
        return unitId;
    }
    
    
    @Override
    public ArrayList<Vendor> Import(){
        BufferedReader br = null;
        ArrayList<Vendor> vendors = new ArrayList<>();
        try {

            String file = "Vendor.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                vendors.add(new Vendor(list[0],list[1],list[2],list[3],list[4],list[5],list[6]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
            }
        return vendors;
        }
    
    public static void tabulateData(ArrayList<Vendor> vendors,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Vendor r:vendors){
            String unitId = r.getUnitId();
            ArrayList<Unit> units = Unit.Import();
            String UnitNo = null;
            for(Unit u:units){
                if(unitId.equals(u.getUnitId())){
                    UnitNo = u.getUnitNo();
                }
            }
            String[] allDataRow = {r.getId(),r.getName(),r.getEmail(),r.getContactNo(),UnitNo};
            model.addRow(allDataRow);
            
        }
    } 
    
    public ArrayList<Vendor> Update(ArrayList<Vendor> vendors, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Vendor r:vendors){
            String Id = r.getId();
            if(id.equals(Id)){
                r.setName(this.getName());
                r.setEmail(this.getEmail());
                r.setRole(this.getRole());
                r.setPassword(this.getPassword());
                r.setContactNo(this.getContactNo());
                
                data.add(r.getId()+":"+r.getName()+":"+r.getEmail()+":"+r.getPassword()+":"+r.getRole()+":"+r.getContactNo()+":"+r.getUnitId());
            }else{
                data.add(r.getId()+":"+r.getName()+":"+r.getEmail()+":"+r.getPassword()+":"+r.getRole()+":"+r.getContactNo()+":"+r.getUnitId());
            }
        }   pr = new PrintWriter("Vendor.txt");
        for(String i:data){
            
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return vendors;
    }
    
     public static ArrayList<Vendor>Delete(ArrayList<Vendor> vendors, String id){
            ArrayList<Vendor> newVendors= new ArrayList<>();
        try {
           for(Vendor r:vendors){
               String Id = r.getId();
               if(id.equals(Id)){
               }else{
                   newVendors.add(r);
               }
           }
               PrintWriter pr = new PrintWriter("Vendor.txt");
                for (Vendor i: vendors){
                    String ID = i.getId();
                    String name=i.getName();
                    String email=i.getEmail();
                    String password =i.getPassword();
                    String role = i.getRole();
                    String contactNo=i.getContactNo();
                    String unitId=i.getUnitId();
                    pr.println(ID+":"+name+":"+email+":"+password+":"+role+":"+contactNo+":"+unitId);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newVendors;
     }
    
    public static void Write(ArrayList<Vendor> vendors){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Units.txt");
            for (Vendor i: vendors){
                String id=i.getId();
                String name=i.getName();
                String email=i.getEmail();
                String password =i.getPassword();
                String role = i.getRole();
                String contactNo=i.getContactNo();
                String unitId=i.getUnitId();
                pr.println(id+":"+name+":"+email+":"+password+":"+role+":"+contactNo+":"+unitId);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vendor.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

}
