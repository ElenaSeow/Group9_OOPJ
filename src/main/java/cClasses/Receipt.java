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
public class Receipt {
    private String id;
    private String userId;
    private String amount;
    private String date;
    
    public Receipt(String id, String userId, String amount, String date){
        this.id=id;
        this.userId=userId;
        this.amount=amount;
        this.date=date;
    }
    public Receipt(){}
    
    public String getId(){
        return id;
    }
    public String getUserId(){
        return userId;
    }
    public String getAmount(){
        return amount;
    }
    public String getDate(){
        return date;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public void setAmount(String amount){
        this.amount=amount;
    }
    public void setAmount(int amount){
        String amt = String.valueOf(amount);
        this.amount=amt;
    }
    public void setDate(String date){
        this.date=date;
    }
    
    
    public ArrayList<Receipt> Import() {
            BufferedReader br = null;
            ArrayList<Receipt> receipts = new ArrayList<>();
        try {

            String file = "Receipt.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                receipts.add(new Receipt(list[0],list[1],list[2],list[3]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return receipts;
    }
    
     public static void tabulateData(ArrayList<Receipt> receipts,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(Receipt u:receipts){
                String userID=u.getUserId();
                if(id.equals(userID)){
                    String[] allDataRow = {u.getId(),u.getAmount(),u.getDate()};
                    model.addRow(allDataRow);
                }
                
        }
     }
     public static void Write(ArrayList<Receipt> receipts){
         PrintWriter pr = null;
        try { 
            pr = new PrintWriter("Receipt.txt");
            for(Receipt i: receipts){
                String rid=i.getId();
                String userId =i.getUserId();
                String amount = i.getAmount();
                String date =i.getDate();
                pr.println(rid+":"+userId+":"+amount+":"+date);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Receipt.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pr.close();
        }
     }
     
     public ArrayList<Receipt> newReceipt(ArrayList<Receipt> receipts, String userid, int amount){
         
         String id = Functions.IdGenerate("Receipt.txt");
         String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
         String amt = String.valueOf(amount);
         receipts.add(new Receipt(id,userid,amt,date));
         Receipt.Write(receipts);
         return null;
     }
}
