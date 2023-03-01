/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

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
    public void setUSerId(String userId){
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
    
    
    
}
