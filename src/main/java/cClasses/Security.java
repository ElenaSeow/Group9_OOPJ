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

public class Security extends User {
    
    public Security(String id, String name, String email, String password, String role, String contactNo) {
        super(id, name, email, password, role, contactNo);
        
    }
    public Security(){}
    
    @Override
    public ArrayList<Security> Import() {
        BufferedReader br = null;
        ArrayList<Security> securities = new ArrayList<>();
        try {
            String file = "Security.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                securities.add(new Security(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
            }
        return securities;
        }
   
   public static void tabulateData(ArrayList<Security> securities,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Security s: securities){
            String[] allDataRow = {s.getName(),s.getId(),s.getRole(),s.getEmail(),s.getPassword(),s.getContactNo()};
            model.addRow(allDataRow);
        }
    }
   public ArrayList<Security> Update(ArrayList<Security> securities, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Security s:securities){
            String Id = s.getId();
            if(id.equals(Id)){
                s.setName(this.getName());
                s.setEmail(this.getEmail());
                s.setRole(this.getRole());
                s.setPassword(this.getPassword());
                s.setContactNo(this.getContactNo());
                
                data.add(s.getId()+":"+s.getName()+":"+s.getEmail()+":"+s.getPassword()+":"+s.getRole()+":"+s.getContactNo());
            }else{
                data.add(s.getId()+":"+s.getName()+":"+s.getEmail()+":"+s.getPassword()+":"+s.getRole()+":"+s.getContactNo());
            }
        }   pr = new PrintWriter("Security.txt");
        for(String i:data){
            
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return securities;
    }
    
     public static ArrayList<Security> delete(ArrayList<Security> securities, String id, int rowIndex) {
        ArrayList<Security> newSecurities = new ArrayList<>();
        try {
            for (Security s : securities) {
                if (!s.getId().equals(id)) {
                    newSecurities.add(s);
                }
            }

            PrintWriter pr = new PrintWriter("Security.txt");
            for (Security i : newSecurities) {
                String ID = i.getId();
                String name = i.getName();
                String email = i.getEmail();
                String password = i.getPassword();
                String role = i.getRole();
                String contactNo = i.getContactNo();
                pr.println(ID + ":" + name + ":" + email + ":" + password + ":" + role + ":" + contactNo);
            }
            pr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newSecurities;
}

    public static void Write(ArrayList<Security> securities){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Security.txt");
            for (Security i: securities){
                String id=i.getId();
                String name=i.getName();
                String email=i.getEmail();
                String password =i.getPassword();
                String role = i.getRole();
                String contactNo=i.getContactNo();
                pr.println(id+":"+name+":"+email+":"+password+":"+role+":"+contactNo);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
   
}
