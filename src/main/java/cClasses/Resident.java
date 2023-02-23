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
public class Resident extends User{
    private String unitId;
    
    public Resident(String id, String name, String email, String password, String role, String contactNo, String unitId) {
        super(id, name, email, password, role, contactNo);
        this.unitId=unitId;
        
    }
    
    public void setName(String name) {
        super.setName(name);
    }
    public void setUnitId(String unitId){
        this.unitId=unitId;
    }
    public String getUnitId(){
        return unitId;
    }
    
    
    public static ArrayList<Resident> Import(){
        BufferedReader br = null;
        ArrayList<Resident> residents = new ArrayList<>();
        try {

            String file = "BackupResident.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                residents.add(new Resident(list[0],list[1],list[2],list[3],list[4],list[5],list[6]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
            }
        return residents;
        }
    
    public static void tabulateData(ArrayList<Resident> residents,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Resident r:residents){
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
    public ArrayList<Resident> Update(ArrayList<Resident> residents, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Resident r:residents){
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
        }   pr = new PrintWriter("BackupResident.txt");
        for(String i:data){
//            String Id = r.getId();
//            String Name = r.getName();
//            String Email = r.getEmail();
//            String Password = r.getPassword();
//            String Role = r.getRole();
//            String ContactNo = r.getContactNo();
//            String UnitId=r.getUnitId();
//            pr.println(Id+":"+Name+":"+Email+":"+Password+":"+Role+":"+ContactNo+":"+UnitId);
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return residents;
    }
    
     public static ArrayList<Resident>Delete(ArrayList<Resident> residents, String id){
            ArrayList<Resident> newResidents= new ArrayList<>();
        try {
           for(Resident r:residents){
               String Id = r.getId();
               if(id.equals(Id)){
               }else{
                   newResidents.add(r);
               }
           }
               PrintWriter pr = new PrintWriter("BackupResident.txt");
                for (Resident i: residents){
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
           Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newResidents;
     }
    
    public static void Write(ArrayList<Resident> residents){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Units.txt");
            for (Resident i: residents){
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
            Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}






















