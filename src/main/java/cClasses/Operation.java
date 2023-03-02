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
public class Operation {
    private String id;
    private String name;
    private String type;
    private String budget;
    private String startdate;
    private String enddate;
    
    
    public Operation(String id, String name, String type, String budget, String startdate, String enddate){
        this.id = id;
        this.name = name;
        this.type = type;
        this.budget = budget;
        this.startdate = startdate;
        this.enddate = enddate;
    }
    public Operation(String id, String name, String type, String budget, Date startdate, Date enddate){
        DateFormat dateFormat =new SimpleDateFormat("dd-MM-yyyy");
        String sdate = dateFormat.format(startdate);
        String edate =dateFormat.format((enddate));
        this.id = id;
        this.name = name;
        this.type = type;
        this.budget = budget;
        this.startdate = sdate;
        this.enddate = edate;
    }

    public Operation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String oid){
        this.id = id;
    }
    
    public String getName(){
        return name; 
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    public String getBudget(){
        return budget;
    }
    
    public void setBudget(String budget){
        this.budget=budget;
    }
    
    public String getStartdate(){
        return startdate;
    }
    
    public void setStartdate(String startdate){
        this.startdate=startdate;
    }
    
    public String getEnddate(){
        return enddate;
    }
    
    public void setEnddate(String enddate){
        this.enddate=enddate;
    }
    

    //arraylist for Table
    public static ArrayList<Operation> Import(){
        BufferedReader br = null;
        ArrayList<Operation> op = new ArrayList<Operation>();
    try {
        
        String file = "Budget.txt";
        ArrayList<String> data = new ArrayList<>();
        br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            data.add(line);
        }
        for(String str:data){
            String[] list = str.split(":");
            op.add(new Operation(list[0],list[1],list[2],list[3],list[4],list[5]));
            
            br.close();
            
            
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return op;    
    }
    public static void tabulateData1(ArrayList<Operation> op,JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Operation o:op){
            if(o.getType().equals("Maintenance")){
                String[] allDataRow = {o.getId(),o.getName()};
                model.addRow(allDataRow);
            }
           
        }
    }
    
     public static void tabulateData2(ArrayList<Operation> op,JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(Operation o:op){
            if(o.getType().equals("Project")){
                String[] allDataRow = {o.getId(),o.getName()};
                model.addRow(allDataRow);
            }
           
        }
    }
    
    //write or add data FUNCTION
    public static void Write(ArrayList<Operation> op){
        PrintWriter pr = null;
    try {
        pr = new PrintWriter("Budget.txt");
        for (Operation o:op){
            String Id=o.getId();
            String name=o.getName();
            String type=o.getType();
            String budget=o.getBudget();
            String startdate=o.getStartdate();
            String enddate=o.getEnddate();
            pr.println(Id+":"+name+":"+type+":"+budget+":"+startdate+":"+enddate);
        }
        pr.close();    
    } catch (FileNotFoundException ex){
        Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
      
}
