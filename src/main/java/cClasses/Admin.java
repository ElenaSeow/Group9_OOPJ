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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Admin extends User{

    
   public Admin(String id, String name, String email, String password,String role,String contactNo){
       super(id);

   }
   
   public void setName(String name){
       super.setName(name);
   }
   
  
   public static ArrayList<Admin> AdminImport() throws IOException{
       BufferedReader br = null;
    ArrayList<Admin> admins = new ArrayList<Admin>();
        try {

            String file = "AdminExecutive.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                admins.add(new Admin(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        return admins;
        }
   
   public static void tabulateData(ArrayList<Admin> admins,DefaultTableModel model){
       for(Admin a:admins){
            String[] allDataRow = {a.getId(),a.getName(),a.getEmail(),a.getPassword(),a.getRole(),a.getContactNo()};
            model.addRow(allDataRow);
            
        }
    } 
   public void adminUpdate(ArrayList<Admin> admins,String id){
       for(Admin a:admins){
           String Id = a.getId();
           if(id.equals(Id)){
               a.setEmail(this.getEmail());
               a.setPassword(this.getPassword());
               a.setContactNo(this.getContactNo());
           }
       }
   }

    @Override
    void addFile() {
        
    }
   
}
