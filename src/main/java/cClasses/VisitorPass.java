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

    
    
    private String userId;
    private String visitorId;
    private String name;
    private String contactNo;
    private String plateNo;
    private String status;
    
    public VisitorPass( String visitorId,String userId, String name, String contactNo,String plateNo,String status) {
        this.userId=userId;
        this.visitorId=visitorId;
        this.name=name;
        this.contactNo=contactNo;
        this.plateNo=plateNo;
        this.status=status;
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
    public String getPlateNo(){
        return plateNo;
    }
    public String getStatus(){
        return status;
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
    
    public void setPlateNo(String plateNo){
        this.plateNo=plateNo;
    }
    public void setStatus(String status){
        this.status=status;
    }
    
//    public void setDate(Date date) {
//        this.date=date;
//    }
    
    public static class VisitorPassInfo {
        
        ArrayList<String> ID = new ArrayList();
        ArrayList<String> visitorId = new ArrayList();
        ArrayList<String> name = new ArrayList();
        ArrayList<String> contactNo = new ArrayList();
        ArrayList<String> plateNo = new ArrayList();
        ArrayList<String> status = new ArrayList();
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
                visitorpass.add(new VisitorPass(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return visitorpass;
    }
    
    public ArrayList<VisitorPass> Update(ArrayList<VisitorPass> visitorpass, String id){
            PrintWriter pr = null;
        try {
           for(VisitorPass f:visitorpass){
               String Id = f.getVisitorId();
               if(id.equals(Id)){
                   f.setName(this.getName());
                   f.setContactNo(this.getContactNo());
                   f.setPlateNo(this.getPlateNo());
                   f.setStatus(this.getStatus());
               }
           }    pr = new PrintWriter("VisitorPass.txt");
                pr.println("VISITOR ID,USER ID,NAME,CONTACT NO,PLATE NO,STATUS");
           for(VisitorPass i: visitorpass){ 
                String vid=i.getVisitorId();
                String userId=i.getUserId();
                String name =i.getName();
                String telno =i.getContactNo();
                String plateNo =i.getPlateNo();
                String status = i.getStatus();
                pr.println(vid+","+userId+","+name+","+telno+","+plateNo+","+status);
                       }
           pr.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return visitorpass;
        }
    
    
    public static void Write(ArrayList<VisitorPass> visitorpass) {
        PrintWriter pr = null;
        try {
            pr = new PrintWriter("VisitorPass.txt");
            pr.println("VISITOR ID,USER ID,NAME,CONTACT NO,PLATE NO,STATUS");
            for (VisitorPass i: visitorpass){
                String id=i.getUserId();
                String name=i.getName();
                String visitorid =i.getVisitorId();
                String contactNo=i.getContactNo();
                String plateno = i.getPlateNo();
                String status = i.getStatus();
                pr.println(visitorid+","+id + "," + name + "," + contactNo+","+plateno+","+status);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void tabulateData(ArrayList<VisitorPass> visitorpass,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(VisitorPass u:visitorpass){
                String userID=u.getUserId();
                if(id.equals(userID)){
//                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
//                    String date = date_format.format(u.getDate());
                
                    String[] allDataRow = {u.getVisitorId(),u.getName(),u.getContactNo(),u.getPlateNo(),u.getStatus()};
                    model.addRow(allDataRow);
                }
                
        }
     }
    public static void tabulateReport(JTable table){
        ArrayList<Resident> residents = new Resident().Import();
        ArrayList<VisitorPass> visitorpass = new VisitorPass().Import();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
            for(VisitorPass u:visitorpass){
                String userID = u.getUserId();
                String username= "";
                for(Resident i : residents){
                    if(userID.equals(i.getId())){
                        username = i.getName();
                    }
                }
                String[] allDataRow = {u.getVisitorId(),username,u.getName(),u.getContactNo(),u.getPlateNo(),u.getStatus()};
                model.addRow(allDataRow);
                
        }
    }
    
    public static void ViewVisitorPass(ArrayList<VisitorPass> visitorpass,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(VisitorPass u:visitorpass){
            String status = u.getStatus();
                if(status.equals("Approved")) {
                    String[] allDataRow = {u.getVisitorId(),u.getUserId(),u.getName(),u.getContactNo(),u.getPlateNo(),u.getStatus()};
                    model.addRow(allDataRow);
                }
     
                
        }
     }
    
    public static void ViewVisitorPassforSG(ArrayList<VisitorPass> visitorpass,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(VisitorPass u:visitorpass){

                
                    String[] allDataRow = {u.getVisitorId(),u.getUserId(),u.getName(),u.getContactNo(),u.getPlateNo(),u.getStatus()};
                    model.addRow(allDataRow);
                
     
                
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
                    plateNo.add(values[4]);
                    status.add(values[5]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        public void Write(ArrayList<VisitorPass> visitorpass){
            PrintWriter pr = null;
        try {
            pr = new PrintWriter("VisitorPass.txt");
            for (VisitorPass i: visitorpass){
                String id=i.getUserId();
                String name=i.getName();
                String visitorid =i.getVisitorId();
                String contactNo=i.getContactNo();
                String plateno = i.getPlateNo();
                String status = i.getStatus();
                pr.println(visitorid+","+id + "," + name + "," + contactNo+","+plateno+","+status);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);
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
                    String plateno = i.getPlateNo();
                    String status = i.getStatus();
                    
                    pr.println(userId+","+visitorId+","+name+","+contactNo+","+plateno+","+status);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(VisitorPass.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newVisitor;
     }
    
    
    
}
