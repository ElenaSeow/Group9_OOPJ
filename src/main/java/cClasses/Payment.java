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
public class Payment {
    
    private String invoiceId;
    private String userId;
    private String unitId;
    private String fee;
    private String outstanding;
    private Date date;
    
    public Payment(String invoiceId,String userId,String unitId, String fee, String outstanding, Date date){
        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=date; 
    
    }
    
    public Payment(String invoiceId,String userId,String unitId, String fee, String outstanding, String date) throws ParseException{
        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);

        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=tdate; 

    }
    
    public Payment() {}
    
    
   
            
    public String getInvoiceId() {
        return invoiceId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getUnitId() {
        return unitId;
    }
    
    public String getFee() {
        return fee;
    }
    
    public String getOutstanding() {
        return outstanding;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setInvoiceId(String invoiceId) {
        this.invoiceId=invoiceId;
    }
    
    public void setUserId(String userId) {
        this.userId=userId;
    }
    
    public void setUnitId(String unitId) {
        this.unitId=unitId;
    }
    
    public void setFee(String fee) {
        this.fee=fee;
    }
    
    public void setOutstanding(String outstanding) {
        this.outstanding=outstanding;
    }
    
    public void setDate(Date date) {
        this.date=date;
    }
    
    
    
    
    public static class PaymentInfo {

        ArrayList<String> ID = new ArrayList();
        ArrayList<String> userID = new ArrayList();
        ArrayList<String> unitID = new ArrayList();
        ArrayList<String> fees = new ArrayList();
        ArrayList<String> outstandingFees = new ArrayList();
        ArrayList<String> date = new ArrayList();
    }
    
    
    
    public ArrayList<Payment> Import() {
            BufferedReader br = null;
            ArrayList<Payment> payment = new ArrayList<>();
        try {

            String file = "Payment.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(",");
                payment.add(new Payment(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payment;
    }
    
     public static void tabulateData(ArrayList<Payment> payment,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(Payment u:payment){
                String userID=u.getUserId();
                        String fee = u.getFee();

                if(id.equals(userID) && !fee.equals("0")){
                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                    String date = date_format.format(u.getDate());
                
                    String[] allDataRow = {u.getInvoiceId(),u.getFee(),u.getOutstanding(),date};
                    model.addRow(allDataRow);
                }
                
        }
     }
     
    
    public static void tabulateDataOutstanding(ArrayList<Payment> payment, JTable table, String id) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (Payment u : payment) {
        String userID = u.getUserId();
        String outstanding = u.getOutstanding();
        if (id.equals(userID) && !outstanding.equals("0")) {
            DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
            String date = date_format.format(u.getDate());

            String[] allDataRow = {u.getOutstanding(),date};
            model.addRow(allDataRow);
        }
    }
}
    
    public static void tabulateReceipt(ArrayList<Payment> payment, JTable table, String id) {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    for (Payment u : payment) {
        String userID = u.getUserId();
        String outstanding = u.getOutstanding();
        if (id.equals(userID) && !outstanding.equals("0")) {
            DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
            String date = date_format.format(u.getDate());

            String[] allDataRow = {u.getInvoiceId(),u.getUnitId(),date};
            model.addRow(allDataRow);
        }
    }  
    }
    
    public static ArrayList<Payment> PAY(ArrayList<Payment> payments,String ID, int amount) {
            PrintWriter pr = null;
        try {
            for(Payment i: payments){
                String id = i.getInvoiceId();
                if(id.equals(ID)){
                    String userid = i.getUserId();
                    String unitid = i.getUnitId();
                    String fee = i.getFee();
                    String outstanding = i.getOutstanding();
                    String idate = new SimpleDateFormat("dd-MM-yyyy").format(i.getDate());
                    int newfee = Integer.parseInt(fee) - amount;
                    int newout = Integer.parseInt(outstanding);
                    if(newfee<0){
                        newout+=newfee;
                        newfee=0;
                    }
                    fee = String.valueOf(newfee);
                    outstanding = String.valueOf(newout);
                    i.setFee(fee);
                    i.setOutstanding(outstanding);
                    
                }
            }
            pr = new PrintWriter("Payment.txt");
            pr.println("INVOICE ID,USER ID,UNIT ID,FEE,OUTSTANDING,DATE");
            for(Payment p: payments){
                String id = p.getInvoiceId();
                String userid = p.getUserId();
                String unitid = p.getUnitId();
                String fee = p.getFee();
                String outstanding = p.getOutstanding();
                String idate = new SimpleDateFormat("dd-MM-yyyy").format(p.getDate());
                pr.println(id+","+userid+","+unitid+","+fee+","+outstanding+","+idate);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pr.close();
        }
        return payments;
        }
    
  
    public static class FileManipulation extends PaymentInfo {
        public void readFile() {
            ID.clear();
            userID.clear();
            unitID.clear();
            fees.clear();
            outstandingFees.clear();
            date.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("Payment.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    ID.add(values[0]);
                    userID.add(values[1]);
                    unitID.add(values[2]);
                    fees.add(values[3]);
                    outstandingFees.add(values[4]);
                    date.add(values[5]);
                    
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        
        
    }
}
        
    

   
    
    
    
    
