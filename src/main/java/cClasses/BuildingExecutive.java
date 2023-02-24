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

public class BuildingExecutive extends User {
    
    
    public BuildingExecutive(String id, String name, String email, String password,String role,String contactNo){
       super(id, name, email, password, role, contactNo);

   }
    public BuildingExecutive(){}
   
   public void setName(String name){
       super.setName(name);
   }
   
   public ArrayList<BuildingExecutive> Import(){
       BufferedReader br = null;
    ArrayList<BuildingExecutive> buildingexecutives = new ArrayList<>();
        try {

            String file = "BuildingExecutive.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                buildingexecutives.add(new BuildingExecutive(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuildingExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(BuildingExecutive.class.getName()).log(Level.SEVERE, null, ex);
            }
        return buildingexecutives;
        }
   
   public static void tabulateData(ArrayList<BuildingExecutive> buildingexecutives,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(BuildingExecutive b:buildingexecutives){
            String[] allDataRow = {b.getId(),b.getName(),b.getEmail(),b.getPassword(),b.getRole(),b.getContactNo()};
            model.addRow(allDataRow);
            
        }
    } 
   
   public ArrayList<BuildingExecutive> Update(ArrayList<BuildingExecutive> buildingexecutives,String id){
       PrintWriter pr = null;
       try {
           for(BuildingExecutive b:buildingexecutives){
               String Id = b.getId();
               if(id.equals(Id)){
                   b.setEmail(this.getEmail());
                   b.setPassword(this.getPassword());
                   b.setContactNo(this.getContactNo());
               }
           }   pr = new PrintWriter("BuildingExecutive.txt");
           for(BuildingExecutive a:buildingexecutives){ 
               pr.println(a);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(BuildingExecutive.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return buildingexecutives;
   }
   
   public ArrayList<BuildingExecutive> Delete(ArrayList<BuildingExecutive> buildingexecutives, String id){
       ArrayList<BuildingExecutive> newBuildingExecutives=null;
       try {
           for(BuildingExecutive b:buildingexecutives){
               String Id = b.getId();
               if(id.equals(Id)){
               }else{
                   newBuildingExecutives.add(b);
               }
           }
               PrintWriter pr = new PrintWriter("BuildingExecutive.txt");
               for (BuildingExecutive i: newBuildingExecutives){
                   pr.println(i);
               }
               pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newBuildingExecutives;

   }
}


