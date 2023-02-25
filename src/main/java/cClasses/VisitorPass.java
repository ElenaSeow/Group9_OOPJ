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
    private Date date;
    private String contactNo;
    
    public VisitorPass(String userId, String visitorId, String name, Date date, String contactNo) {
        this.userId=userId;
        this.visitorId=visitorId;
        this.name=name;
        this.date=date;
        this.contactNo=contactNo;
    }
    
    public VisitorPass(String userId, String visitorId, String name, String date, String contactNo) throws ParseException {
        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        
        this.userId=userId;
        this.visitorId=visitorId;
        this.name=name;
        this.date=tdate;
        this.contactNo=contactNo;
        
    }
    
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
    
    public Date getDate() {
        return date;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    
    public void setUserId(String userId) {
        this.userId=userId;
    }
    
    public void setVisitorId(String visitorId) {
        this.visitorId=visitorId;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setDate(Date date) {
        this.date=date;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo=contactNo;
    }
    
    public static class VisitorPassInfo {
        
        //ArrayList<String> ID = new ArrayList();
        ArrayList<String> visitorId = new ArrayList();
        ArrayList<String> name = new ArrayList();
        ArrayList<String> date = new ArrayList();
        ArrayList<String> contactNo = new ArrayList();
        
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
            for(VisitorPass a:visitorpass){
                String userID=a.getUserId();
                if(id.equals(userID)){
                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                    String date = date_format.format(a.getDate());
                
                    String[] allDataRow = {a.getVisitorId(), a.getName(), date, a.getContactNo()};
                    model.addRow(allDataRow);
                }
                
        }
     }
    
    public static class FileManipulation extends VisitorPass.VisitorPassInfo {

        public void readFile() {
            //ID.clear();
            visitorId.clear();
            name.clear();
            date.clear();
            contactNo.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("VisitorPass.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    //ID.add(values[0]);
                    visitorId.add(values[1]);
                    name.add(values[2]);
                    date.add(values[3]);
                    contactNo.add(values[4]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        
    }
    
    
    
    
    
}
