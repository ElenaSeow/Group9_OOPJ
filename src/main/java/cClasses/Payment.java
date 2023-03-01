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
    private String status;
    
    public Payment(String invoiceId,String userId,String unitId, String fee, String outstanding, Date date, String status){
        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=date; 
        this.status=status;
    
    }
    
    public Payment(String invoiceId,String userId,String unitId, String fee, String outstanding, String date, String status) throws ParseException{
        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);

        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=tdate; 
        this.status=status;
    
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
        ArrayList<String> status = new ArrayList();
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
                payment.add(new Payment(list[0],list[1],list[2],list[3],list[4],list[5],list[6]));
                
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
                    status.add(values[6]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        
        public void PAY(String ID, String userID, String unitID, String fee, String outstanding, String date) {
            readFile();
            for (int i = 0; i < this.ID.size(); i++) {
                if (ID.equals(this.ID.get(i))) {
                    this.ID.set(i, ID);
                    this.userID.set(i, userID);
                    this.unitID.set(i, unitID);
                    this.fees.set(i, fee);
                    this.outstandingFees.set(i, outstanding);
                    this.date.set(i, date);
                }
            }
            try ( FileWriter file = new FileWriter("Payment.txt");) {
                for (int i = 0; i < this.ID.size(); i++) {
                    file.write(this.ID.get(i) + "," + 
                            this.userID.get(i) + "," + 
                            this.unitID.get(i) + "," + 
                            this.fees.get(i) + "," + 
                            this.outstandingFees.get(i) + "," + 
                            this.date.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
    }
}
    
    
    
    
    
