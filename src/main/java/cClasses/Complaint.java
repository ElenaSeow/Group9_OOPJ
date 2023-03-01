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
public class Complaint {
    private String complaintId;
    private String desc;
    private String status;
    private String userId;
    private Date updateDate;
    private Date complaintDate;
    
    public Complaint(String complaintId,String userId,String desc, String status, Date complaintDate, Date updateDate){
        this.complaintId=complaintId;
        this.userId=userId;
        this.desc=desc;
        this.status=status;
        this.updateDate=updateDate;
        this.complaintDate=complaintDate;
    }
        public Complaint(String complaintId, String userId, String desc, String status, String complaintDate, String updateDate){
        try {
            Date cdate = new SimpleDateFormat("dd-MM-yyyy").parse(complaintDate);
            Date udate = new SimpleDateFormat("dd-MM-yyyy").parse(updateDate);
            this.complaintId=complaintId;
            this.userId=userId;
            this.desc=desc;
            this.status=status;
            this.updateDate=udate;
            this.complaintDate=cdate;
        } catch (ParseException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public Complaint(){}
    
    
    public String getComplaintId(){
        return complaintId;
    }
    public String getDesc(){
        return desc;
    }
    public String getStatus(){
        return status;
    }
    public String getUserId(){
        return userId;
    }
    public Date getUpdateDate(){
        return updateDate;
    }
    public Date getComplaintDate(){
        return complaintDate;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public void setUpdateDate(Date updateDate){
        this.updateDate=updateDate;
    }
    public void setUpdateDate(String updateDate){
        try {
            Date tempdate = new SimpleDateFormat("dd-MM-yyyy").parse(updateDate);
            this.updateDate=tempdate;
        } catch (ParseException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    public void setComplaintDate(Date complaintDate){
        this.complaintDate=complaintDate;
    }
    public void setComplaintDate(String complaintDate){
        try {
            Date tempdate = new SimpleDateFormat("dd-MM-yyyy").parse(complaintDate);
            this.complaintDate=tempdate;
        } catch (ParseException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public ArrayList<Complaint> Import(){
            BufferedReader br = null;
            ArrayList<Complaint> complaints = new ArrayList<>();
        try {

            String file = "complaints.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                complaints.add(new Complaint(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
        }
        return complaints;
    }
   public static void tabulateData(ArrayList<Complaint> complaints, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Complaint c:complaints){
            String status = c.getStatus();
            if(status.equals("Pending")){
               DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String cdate = date_format.format(c.getComplaintDate());
                String udate = date_format.format(c.getUpdateDate());
            String[] allDataRow = {c.getComplaintId(),c.getDesc(),cdate,udate,status};
            model.addRow(allDataRow); 
            }
            
        }
    }
   public static void tabulateData1(ArrayList<Complaint> complaints, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Complaint c:complaints){
            String status = c.getStatus();
            if(status.equals("Reviewed")){
               DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String cdate = date_format.format(c.getComplaintDate());
                String udate = date_format.format(c.getUpdateDate());
            String[] allDataRow = {c.getComplaintId(),c.getDesc(),cdate,udate,status};
            model.addRow(allDataRow); 
            }
            
        }
    }
   
    public ArrayList<Complaint> Update(ArrayList<Complaint> complaints, String id){
            PrintWriter pr = null;
        try {
           for(Complaint f:complaints){
               String Id = f.getComplaintId();
               if(id.equals(Id)){
                   f.setDesc(this.getDesc());
                   f.setStatus(this.getStatus());
                   f.setUpdateDate(this.getUpdateDate());
                   
               }
           }   pr = new PrintWriter("complaints.txt");
           for(Complaint i: complaints){ 
                String Id =i.getComplaintId();
                String userID = i.getUserId();
                String desc = i.getDesc();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String cdate = date_format.format(i.getComplaintDate());
                String udate = date_format.format(i.getUpdateDate());
                String status =i.getStatus();
                pr.println(Id+":"+userID+":"+desc+":"+status+":"+cdate+":"+udate);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return complaints;
        }
    
     public static ArrayList<Complaint>Delete(ArrayList<Complaint> complaints, String id){
            ArrayList<Complaint> newComplaints= new ArrayList<>();
        try {
           for(Complaint f:complaints){
               String Id = f.getComplaintId();
               if(id.equals(Id)){
               }else{
                   newComplaints.add(f);
               }
           }
               PrintWriter pr = new PrintWriter("complaints.txt");
               for (Complaint i: newComplaints){
                String Id=i.getComplaintId();
                String userID = i.getUserId();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String cdate = date_format.format(i.getComplaintDate());
                String udate = date_format.format(i.getUpdateDate());
                String desc=i.getDesc();
                String status =i.getStatus();
                pr.println(Id+":"+userID+":"+desc+":"+cdate+":"+udate+":"+status);
                       }
               pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newComplaints;

   }
     public static void Write(ArrayList<Complaint> complaints){
        PrintWriter pr = null;
        try {
            pr = new PrintWriter("complaints.txt");
            for (Complaint i: complaints){
                String Id=i.getComplaintId();
                String UserID =i.getUserId();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String cdate = date_format.format(i.getComplaintDate());
                String udate = date_format.format(i.getUpdateDate());
                String desc=i.getDesc();
                String status =i.getStatus();
                pr.println(Id+":"+UserID+":"+desc+":"+cdate+":"+udate+":"+status);
                       }
            pr.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
    }
     
     public static class info {

        ArrayList<String> cID = new ArrayList();
        ArrayList<String> uID = new ArrayList();
        ArrayList<String> description = new ArrayList();
        ArrayList<String> date = new ArrayList();
        ArrayList<String> status = new ArrayList();
    }
     public static class fileManipulation extends info {
     public void readFile() {
            cID.clear();
            uID.clear();
            description.clear();
            date.clear();
            status.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("complaints.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(":");
                    cID.add(values[0]);
                    uID.add(values[1]);
                    description.add(values[2]);
                    date.add(values[3]);
                    status.add(values[4]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
     
     public void editFile(String cID, String uID, String description, String date, String status) {
            readFile();
            for (int i = 0; i < this.cID.size(); i++) {
                if (cID.equals(this.cID.get(i))) {
                    this.cID.set(i, cID);
                    this.uID.set(i, uID);
                    this.description.set(i, description);
                    this.date.set(i, date);
                    this.status.set(i, status);
                }
            }
            try ( FileWriter file = new FileWriter("complaints.txt");) {
                for (int i = 0; i < this.cID.size(); i++) {
                    file.write(this.cID.get(i) + ":" + 
                            this.uID.get(i) + ":" + 
                            this.description.get(i) + ":" + 
                            this.date.get(i) + ":" + 
                            this.status.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
    }
}

