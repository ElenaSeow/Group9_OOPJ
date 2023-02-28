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
        
        public static String IdGenerate(String file){
        ArrayList<String> filedata;
        filedata =Functions.Read(file);
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
        String newId= code+newDigit;
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
}
