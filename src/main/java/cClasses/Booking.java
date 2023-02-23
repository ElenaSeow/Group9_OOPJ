/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Booking extends Facility{
    private String bookId;
    private String userId;
    private String name;
    private Date date;
    private String time;
    
    public Booking(String bookId,String id, String facility, int capacity, String status, String userId, String name, Date date, String time ){
        super(id,facility,capacity,status);
        this.date=date;
        this.bookId=bookId;
        this.name=name;
        this.userId=userId;
        this.time=time;    
    }
        public Booking(String bookId,String id, String facility, String capacity, String status, String userId, String name, String date, String time ) throws ParseException{
        super(id,facility,capacity,status);
        Date tdate = new SimpleDateFormat("dd/MM//yyyy").parse(date);
        this.date=tdate;
        this.bookId=bookId;
        this.name=name;
        this.userId=userId;
        this.time=time;    
    }
    public String getBookId(){
        return bookId;
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
    public String time(){
        return time;
    }
    
}
