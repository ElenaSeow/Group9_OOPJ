/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class Functions {
    
    
        public static void Search(String str, JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)" + str));       
    }
        
        public static ArrayList<String> Read(String file){
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            
            while((line=br.readLine())!=null){
                data.add(line);
            }
        br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return data; 
    }
         public static ArrayList<String> SkipRead(String file){
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            
            while((line=br.readLine())!=null){
                data.add(line);
            }
        br.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return data; 
    }
        
        public static String IdGenerate(String file){
        ArrayList<String> filedata;
        filedata =Functions.Read(file);
        String newId="";
        if(filedata.equals(null)){
            if(file.equals("AccountExecutive.txt")){
                newId = "AE001";
            }else if(filedata.equals("BackupResident.txt")){
                newId = "RE001";
            }else if(filedata.equals("BackupVendor.txt")){
                newId = "VE001";
            }else if(filedata.equals("BuildingManager")){
                newId = "BM001";
            }else if(filedata.equals("Bookings.txt")){
                newId = "BK001";
            }else if(filedata.equals("BuildingExecutive.txt")){
                newId = "BE001";
            }else if(filedata.equals("Cleaner.txt")){
                newId = "CL001";
            }else if(filedata.equals("Facilities.txt")){
                newId = "FA001";
            }else if(filedata.equals("BackupResident.txt")){
                newId = "RE001";
            }else if(filedata.equals("Patrols.txt")){
                newId = "CP001";
            }else if(filedata.equals("Security.txt")){
                newId = "SG001";
            }else if(filedata.equals("Technician.txt")){
                newId = "TE001";
            }else if(filedata.equals("Units.txt")){
                newId = "UN001";
            }else if(filedata.equals("complaints.txt")){
                newId = "CM001";
            }else if(filedata.equals("Receipt.txt")){
                newId = "RP001";
            }
        
        }else{
            ArrayList<String> Ids = new ArrayList<>();
            for(String str:filedata){
                String[] list = str.split(":");
                Ids.add(list[0]);
            }
            int len = Ids.size();
            String lastID = Ids.get(len-1);
            String code = lastID.substring(0,2);
            int digit = Integer.parseInt(lastID.substring(2));
            digit += 1;
            String pattern ="000";
            DecimalFormat myFormatter = new DecimalFormat(pattern);
            String newDigit = myFormatter.format(digit);
            newId= code+newDigit;
        }
        return newId;
        
    }
        
         public static String IdGenerate2(String file){
        ArrayList<String> filedata;
        filedata =Functions.SkipRead(file);
        String newId="";
        if(filedata.equals(null)){
            if(file.equals("Patrols.txt")){
                newId = "CP001";
            }else if(filedata.equals("VisitorPass.txt")){
                newId = "VP001";
            }else if(filedata.equals("BackupVendor.txt")){
                newId = "VE001";
            }
        }else{
        
        ArrayList<String> Ids = new ArrayList<>();
        for(String str:filedata){
            String[] list = str.split(",");
            Ids.add(list[0]);
        }
        int len = Ids.size();
        String lastID = Ids.get(len-1);
        String code = lastID.substring(0,2);
        int digit = Integer.parseInt(lastID.substring(2));
        digit += 1;
        String pattern ="000";
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String newDigit = myFormatter.format(digit);
        newId= code+newDigit;
        }
        return newId;
    }
        public static String date(){
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date(); 
            String strDate = formatter.format(date);
            return strDate;
        }
        
        public static String getFile(String id){
            String code = id.substring(0,2);
            String file = null;
            if(code.equals("BM")){
                file = "BuildingManager.txt";
            }else if(code.equals("AD")){
                file = "AdminExecutive.txt";
            }else if(code.equals("AE")){
                file = "AccountExecutive.txt";
            }else if(code.equals("BE")){
                file = "BuildingExecutive.txt";
            }else if(code.equals("RE")){
                file = "BackupResident.txt";
            }else if(code.equals("SG")){
                file = "Security.txt";
            }else if(code.equals("VE")){
                file = "Vendor.txt";
            }
            return file;
            
        }
        public static String getCount(JTable table){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int count = model.getRowCount();
            String cnt = String.valueOf(count);
            return cnt;
        }
}
