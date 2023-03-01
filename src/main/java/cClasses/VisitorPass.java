/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class VisitorPass {

    public static void Write(ArrayList<VisitorPass> visitorpass) {
        
    }
    
    private String userId;
    private String visitorId;
    private String name;
    private String contactNo;
    
    public VisitorPass( String visitorId,String userId, String name, String contactNo) {
        this.userId=userId;
        this.visitorId=visitorId;
        this.name=name;
        this.contactNo=contactNo;
    }
    
//    public VisitorPass(String userId, String visitorId, String name, String contactNo, String date) throws ParseException{
//        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
//
//        this.userId=userId;
//        this.visitorId=visitorId;
//        this.name=name;
//        this.contactNo=contactNo;
//    
//    }
    
    
    
    public VisitorPass() {}
    
    public String getUserId() {
        return userId;
    }
    
    public String getVisitorId() {
        return visitorId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    
//    public Date getDate() {
//        return date;
//    }
    
    public void setUserId(String userId) {
        this.userId=userId;
    }
    
    public void setVisitorId(String visitorId) {
        this.visitorId=visitorId;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo=contactNo;
    }
    
//    public void setDate(Date date) {
//        this.date=date;
//    }
    
    public static class VisitorPassInfo {
        
        ArrayList<String> ID = new ArrayList();
        ArrayList<String> visitorId = new ArrayList();
        ArrayList<String> name = new ArrayList();
        ArrayList<String> contactNo = new ArrayList();
//        ArrayList<String> date = new ArrayList();
        
    }
    
    public ArrayList<VisitorPass> Import() {
            BufferedReader br = null;
            ArrayList<VisitorPass> visitorpass = new ArrayList<>();
        try {

            String file = "VisitorPass.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(",");
                visitorpass.add(new VisitorPass(list[0],list[1],list[2],list[3]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return visitorpass;
    }
    
    public static void tabulateData(ArrayList<VisitorPass> visitorpass,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(VisitorPass u:visitorpass){
                String userID=u.getUserId();
                if(id.equals(userID)){
//                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
//                    String date = date_format.format(u.getDate());
                
                    String[] allDataRow = {u.getVisitorId(),u.getName(),u.getContactNo()};
                    model.addRow(allDataRow);
                }
                
        }
     }
    
    
    public static class FileManipulation extends VisitorPass.VisitorPassInfo {

        public void readFile() {
            //ID.clear();
            visitorId.clear();
            name.clear();
            contactNo.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("VisitorPass.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    //ID.add(values[0]);
                    visitorId.add(values[1]);
                    name.add(values[2]);
                    contactNo.add(values[3]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        public void Write(ArrayList<VisitorPass> visitorpass){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Units.txt");
            for (VisitorPass i: visitorpass){
                String id=i.getUserId();
                String name=i.getName();
                String visitorid =i.getVisitorId();
                String contactNo=i.getContactNo();
                pr.println(id+":"+name + ":" + visitorid + ":" + contactNo);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }
    
    public static ArrayList<VisitorPass>Delete(ArrayList<VisitorPass> visitorpass, String id){
            ArrayList<VisitorPass> newVisitor= new ArrayList<>();
        try {
           for(VisitorPass r:visitorpass){
               String Id = r.getUserId();
               if(id.equals(Id)){
               }else{
                  // newResidents.add(r);
               }
           }
               PrintWriter pr = new PrintWriter("VisitorPass.txt");
                for (VisitorPass i: visitorpass){
                    String userId = i.getUserId();
                    String visitorId=i.getVisitorId();
                    String name=i.getName();
                    String contactNo =i.getContactNo();
                    
                    pr.println(userId+":"+visitorId+":"+name+":"+contactNo);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Resident.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newVisitor;
     }
    
    
    
}
