/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                if(id.equals(userID)){
                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                    String date = date_format.format(u.getDate());
                
                    String[] allDataRow = {u.getFee(),date};
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
     
    
    
    
    
    
}
