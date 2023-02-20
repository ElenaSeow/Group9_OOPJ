/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminExecutive;


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
public class Admin {
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String contactNo;
    
   public Admin(String id, String name, String email, String password,String role,String contactNo){
       this.id=id;
       this.name=name;
       this.email=email;
       this.password=password;
       this.role=role;
       this.contactNo=contactNo;
   }
   
   public void setName(String name){
       this.name=name;
   }
   public String getName(){
       return name;
   }
//   public void setId(String id){
//       this.id = id;  
//   }
   public String getId(){
       return id;
   }
   public void setEmail(String email){
       this.email=email;
   }
   public String getEmail(){
       return email;
   }
   public void setPassword(String password){
       this.password=password;
   }
   public String getPassword(){
       return password;
   }
   public String getRole(){
       return role;
   }
  public void setContactNo(String contactNo){
      this.contactNo=contactNo;
  }
  public String getContactNo(){
      return contactNo;
  }
   public static void AdminImport() throws IOException{
       BufferedReader br = null;
        try {
            ArrayList<Admin> admins = new ArrayList<Admin>();
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
        }
   
   public static void AddDataToTable(ArrayList<Admin> admins,DefaultTableModel model){
       for(Admin a:admins){
            String[] allDataRow = {a.getId(),a.getName(),a.getEmail(),a.getPassword(),a.getRole(),a.getContactNo()};
            model.addRow(allDataRow);
            
   }
   } 
}
