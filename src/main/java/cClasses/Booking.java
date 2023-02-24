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
 * @author User
 */
public class Booking{
    private String bookId;
    private String facId;
    private String userId;
    private String name;
    private Date date;
    private String time;
    private String status;
    
    public Booking(String bookId,String facId,String userId, String name, Date date, String time, String status){
        this.date=date;
        this.facId=facId;
        this.bookId=bookId;
        this.name=name;
        this.userId=userId;
        this.time=time; 
        this.status=status;
    }
    public Booking(String bookId,String facId, String userId, String name, String date, String time, String status ) throws ParseException{
        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        this.date=tdate;
        this.facId=facId;
        this.bookId=bookId;
        this.name=name;
        this.userId=userId;
        this.time=time;
        this.status=status;
    }
    public Booking(){}
        
    public String getBookId(){
        return bookId;
    }
    public String getFacId(){
        return facId;
    }
    public String getUserId(){
        return userId;
    }
    public String getName(){
        return name;
    }
    public Date getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getStatus(){
        return status;
    }
    public void setFacId(String facId){
        this.facId=facId;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setDate(String date) throws ParseException{
        Date tempdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        this.date=tempdate;
    }
    public void setDate(Date date){
        this.date=date;
    }
    public void setTime(String time){
        this.time=time;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public ArrayList<Booking> Import() throws ParseException{
            BufferedReader br = null;
            ArrayList<Booking> bookings = new ArrayList<>();
        try {

            String file = "Bookings.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                bookings.add(new Booking(list[0],list[1],list[2],list[3],list[4],list[5],list[6]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookings;
    }
    
    public static ArrayList<Booking> changeStatus(ArrayList<Booking> bookings){
        Date today = new Date();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        for(Booking i:bookings){
            Date date = i.getDate();
            long time_difference= date.getTime() - today.getTime();
            long days = (time_difference / (1000*60*60*24)) % 365;  
            if(days<0) {
                i.setStatus("Invalid");
            }
        }
        return bookings;
    }
    public static void tabulateData(ArrayList<Booking> bookings, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Booking b:bookings){
            String status = b.getStatus();
            if(status.equals("Booked")){
               DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String date = date_format.format(b.getDate());
                ArrayList<Facility> facilities = new Facility().Import();
                String facility = null;
                for(Facility i :facilities){
                    if(b.getFacId().equals(i.getId())){
                        facility =i.getFacility();
                }
            }
            String[] allDataRow = {b.getBookId(),b.getName(),facility,date,b.getTime(),status};
            model.addRow(allDataRow); 
            }
            
        }
    }
    
    public ArrayList<Booking> Update(ArrayList<Booking> bookings, String id){
            PrintWriter pr = null;
        try {
           for(Booking f:bookings){
               String Id = f.getBookId();
               if(id.equals(Id)){
                   f.setDate(this.getDate());
                   f.setTime(this.getTime());
                   f.setUserId(this.getUserId());
                   f.setName(this.getName());
                   
               }
           }   pr = new PrintWriter("Facilities.txt");
           for(Booking i: bookings){ 
                String Bid=i.getBookId();
                String FacId =i.getFacId();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String date = date_format.format(i.getDate());
                String userId=i.getUserId();
                String name = i.getName();
                String time = i.getTime();
                String status =i.getStatus();
                pr.println(Bid+":"+FacId+":"+userId+":"+name+":"+date+":"+time+":"+status);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return bookings;
        }
    
    public static ArrayList<Booking>Delete(ArrayList<Booking> bookings, String id){
            ArrayList<Booking> newBookings= new ArrayList<>();
        try {
           for(Booking f:bookings){
               String Id = f.getBookId();
               if(id.equals(Id)){
               }else{
                   newBookings.add(f);
               }
           }
               PrintWriter pr = new PrintWriter("Facilities.txt");
               for (Booking i: newBookings){
                String Bid=i.getBookId();
                String FacId =i.getFacId();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String date = date_format.format(i.getDate());
                String userId=i.getUserId();
                String name = i.getName();
                String time = i.getTime();
                String status =i.getStatus();
                pr.println(Bid+":"+FacId+":"+userId+":"+name+":"+date+":"+time+":"+status);
                       }
               pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newBookings;

   }
    
    public static void Write(ArrayList<Booking> bookings){
        PrintWriter pr = null;
        try {
            pr = new PrintWriter("Facilities.txt");
            for (Booking i: bookings){
                String Bid=i.getBookId();
                String FacId =i.getFacId();
                DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String date = date_format.format(i.getDate());
                String userId=i.getUserId();
                String name = i.getName();
                String time = i.getTime();
                String status =i.getStatus();
                pr.println(Bid+":"+FacId+":"+userId+":"+name+":"+date+":"+time+":"+status);
                       }
            pr.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Facility.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
    }
}
