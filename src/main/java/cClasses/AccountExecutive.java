/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AccountExecutive extends User{
    
    public AccountExecutive(String id, String name, String email, String password, String role, String contactNo){
        super(id,name,email,password,role,contactNo);
    }
    public AccountExecutive(){}
    
    //arraylist for Table
    @Override
    public ArrayList<AccountExecutive> Import(){
        BufferedReader br = null;
        ArrayList<AccountExecutive> ae = new ArrayList<>();
    try {
        
        String file = "AccountExecutive.txt";
        ArrayList<String> data = new ArrayList<>();
        br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            data.add(line);
        }
        for(String str:data){
            String[] list = str.split(":");
            ae.add(new AccountExecutive(list[0],list[1],list[2],list[3],list[4],list[5]));
            
            br.close();
            
            
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
            Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ae;    
    }
    public static void tabulateData(ArrayList<AccountExecutive> ae,JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(AccountExecutive a:ae){
            String[] allDataRow = {a.getId(),a.getName(),a.getEmail(),a.getContactNo()};
            model.addRow(allDataRow);
        }
    }
    
    //update or modify FUNCTION
    public ArrayList<AccountExecutive> Update(ArrayList<AccountExecutive> ae, String id){
        PrintWriter pr = null;
    try {
        for (AccountExecutive a:ae){
            String Id = a.getId();
            if(id.equals(Id)){
                a.setName(this.getName());
                a.setEmail(this.getEmail());
                a.setPassword(this.getPassword());
                a.setRole(this.getRole());
                a.setContactNo(this.getContactNo());
            }
        }   pr = new PrintWriter("AccountEecutive.txt");
        for(AccountExecutive a:ae){
            String Id=a.getId();
            String name=a.getName();
            String email=a.getEmail();
            String password=a.getPassword();
            String role=a.getRole();
            String number=a.getContactNo();
            pr.println(Id+":"+name+":"+email+":"+password+":"+role+":"+number);
                }
    } catch (FileNotFoundException ex){
            Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        pr.close();
    }
    return ae;
     }
    
//    delete FUNCTION
    public static ArrayList<AccountExecutive>Delete(ArrayList<AccountExecutive> ae, String id){
        ArrayList<AccountExecutive> newAe= new ArrayList<>();
    try {
        for(AccountExecutive a:ae){
            String Id = a.getId();
            if(id.equals(Id)){
            }else{
                newAe.add(a);
            }   
        }
            PrintWriter pr = new PrintWriter("AccountExecutive.txt");
            for (AccountExecutive i: newAe){
                String Id=i.getId();
                String name=i.getName();
                String email=i.getEmail();
                String password=i.getPassword();
                String role=i.getRole();
                String number=i.getContactNo();
                pr.println(Id+":"+name+":"+email+":"+password+":"+role+":"+number);
            }
            pr.close();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
    }
    return newAe;
    }
    
    //write or add data FUNCTION
    public static void Write(ArrayList<AccountExecutive> ae){
        PrintWriter pr = null;
    try {
        pr = new PrintWriter("AccountExecutive.txt");
        for (AccountExecutive a:ae){
            String Id=a.getId();
            String name=a.getName();
            String email=a.getEmail();
            String password=a.getPassword();
            String role=a.getRole();
            String number=a.getContactNo();
            pr.println(Id+":"+name+":"+email+":"+password+":"+role+":"+number);
        }
        pr.close();    
    } catch (FileNotFoundException ex){
        Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    
    //add data
//    public static void write() {
//        try {
//            File file = new File("accountexecutive.txt");
//            FileWriter fw= new FileWriter(file, true);
//            try (PrintWriter buffer = new PrintWriter(new BufferedWriter(fw))) {
//                for(int i=0; i<accountexecutive.size();i++){
//                    buffer.write(accountexecutive.get(i).getid() + "," + accountexecutive.get(i).getname().toUpperCase() + "," +
//                            accountexecutive.get(i).getpassword() + "," + accountexecutive.get(i).getemail() + "," + accountexecutive.get(i).getnumber() + "," +
//                            accountexecutive.get(i).getrole() + "," + accountexecutive.get(i).getunitid()) ;
//                    break;
//                }
//                accountexecutive.removeAll(accountexecutive);
//                buffer.write("\n");   
//            }   
//        }catch (IOException ex) {
//            Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    

}
