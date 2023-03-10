/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import static cClasses.Invoices.inCurrentMonth;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
    public ArrayList<Booking> Import(){
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
        } catch (ParseException ex) {
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
                i.setStatus("Ended");
            }
        }
        return bookings;
    }
    
    public boolean checkTime(ArrayList<Booking> bookings,ArrayList<Facility> facilities,JComboBox Time){
        ArrayList<String> comboValues=new ArrayList<>();
        for(int i=0;i<Time.getItemCount();i++){
            comboValues.add((String) Time.getItemAt(i));
        }
//        for(String k:comboValues){
//            System.out.println(k);
//        }
        int cap = 0;
        int count = 0;
        for(Facility f:facilities){
            if(this.facId.equals(f.getId())){
                cap=f.getCapacity();
            }
        }
       for(Booking i:bookings){
           if(i.getDate().equals(this.date)&&i.getTime().equals(this.time)
                   &&i.getStatus().equals("Booked")&& i.getFacId().equals(this.facId)){
               count+=1;
           }
       }
       boolean decision;
       if(count<cap){
           decision=true;
       }else{
           JOptionPane.showMessageDialog(null, "Time slot is full! Please select another time slot!");
           decision=false;
           
       }
       return decision;
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
    
     public static void tabulateData1(ArrayList<Booking> bookings, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Booking b:bookings){
            String status = b.getStatus();
            if(!(status.equals("Booked"))){
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
     
     public static void tabulateBooking(ArrayList<Booking> bookings, JTable table,String id){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Booking b:bookings){
            String status = b.getStatus();
            String Id = b.getUserId();
            if((status.equals("Booked"))&&(Id.equals(id))){
               DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                String date = date_format.format(b.getDate());
                ArrayList<Facility> facilities = new Facility().Import();
                String facility = null;
                for(Facility i :facilities){
                    if(b.getFacId().equals(i.getId())){
                        facility =i.getFacility();
                }
            }
            String[] allDataRow = {b.getBookId(),facility,date,b.getTime(),status};
            model.addRow(allDataRow); 
            }
            
        }
    }
     
     public static void tabulateReport(JTable table){
        ArrayList<Booking> bookings = new Booking().Import();
        ArrayList<Facility> facilities = new Facility().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          for(Booking i: bookings){
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              String facName="";
              String facid=i.getFacId();
              if(inCurrentMonth(dt)){
                  for(Facility f:facilities){
                      if(f.getId().equals(facid)){
                          facName=f.getFacility();
                      }
                  }
                  String date = df.format(dt);
                String[] allDataRow = {i.getBookId(),i.getName(),facName,i.getStatus(),date};
                model.addRow(allDataRow);
              }
          }
     }
     
     public static void tabulateReport1(JTable table){
        ArrayList<Booking> bookings = new Booking().Import();
        ArrayList<Facility> facilities = new Facility().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          for(Booking i: bookings){
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              String facName="";
              String facid=i.getFacId();
                  for(Facility f:facilities){
                      if(f.getId().equals(facid)){
                          facName=f.getFacility();
                      }
                  }
                  String date = df.format(dt);
                String[] allDataRow = {i.getBookId(),i.getName(),facName,i.getStatus(),date};
                model.addRow(allDataRow);
              
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
                   f.setStatus(this.getStatus());
                   
               }
           }   pr = new PrintWriter("Bookings.txt");
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
           Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
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
               PrintWriter pr = new PrintWriter("Boookings.txt");
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
           Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newBookings;

   }
    
    public static void Write(ArrayList<Booking> bookings){
        PrintWriter pr = null;
        try {
            pr = new PrintWriter("Bookings.txt");
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
           Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
    }
    
    public static void facilityChooser(ArrayList<Facility> facilities,JComboBox jbox){
         ArrayList<String> facNames = Facility.getFacilities(facilities);
        for(String i : facNames){
            jbox.addItem(String.valueOf(i));
        }
        jbox.setSelectedIndex(0);
    }
}
