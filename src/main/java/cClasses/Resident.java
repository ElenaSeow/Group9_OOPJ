/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

}






















