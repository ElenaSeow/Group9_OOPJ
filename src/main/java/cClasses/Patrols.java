package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Patrols extends PatrolUser {
    private String checkid;
    
    public Patrols(String checkid, String secid, String date, String time, String status) {
        super(checkid, secid, date, time, status);
        
    }
    public Patrols(){}
    
    @Override
    public ArrayList<Patrols> Import() {
        BufferedReader br = null;
        ArrayList<Patrols> patrols = new ArrayList<>();
        try {
            String file = "Patrols.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(",");
                patrols.add(new Patrols(list[0],list[1],list[2],list[3],list[4]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Patrols.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Patrols.class.getName()).log(Level.SEVERE, null, ex);
            }
        return patrols;
        }
   
   public static void tabulateData(ArrayList<Patrols> patrols,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Patrols s: patrols){
            String[] allDataRow = {s.getcheckid(),s.getsecid(),s.getdate(),s.gettime(),s.getstatus() };
            model.addRow(allDataRow);
        }
    }
   public ArrayList<Patrols> Update(ArrayList<Patrols> patrols, String checkid){
//        
//        ArrayList<String> data=new ArrayList<>();
//    try {
//        for(Patrols s:patrols){
//            String Id = s.getcheckid();
//            if(checkid.equals(Id)){
//                s.setsecid(this.getsecid());
//                s.setdate(this.getdate());
//                s.settime(this.gettime());
//                s.setstatus(this.getstatus());
//                
//                data.add(s.getcheckid()+","+s.getsecid()+","+s.getdate()+","+s.gettime()+","+s.getstatus());
//            }else{
//                data.add(s.getcheckid()+","+s.getsecid()+","+s.getdate()+","+s.gettime()+","+s.getstatus());
//            }
//        }   PrintWriter pr = new PrintWriter("Patrols.txt");
//        for(String i:data){
//            
//            pr.println(i);
//            System.out.println(i);
//        }   
//    } catch (FileNotFoundException ex) {
//        Logger.getLogger(Patrols.class.getName()).log(Level.SEVERE, null, ex);
//    }finally{
//        
//    }
//        return patrols;

        PrintWriter pr = null;
        try {
           for(Patrols s:patrols){
               String Id = s.getcheckid();
               if(checkid.equals(Id)){
                   s.setsecid(this.getsecid());
                   s.setdate(this.getdate());
                   s.settime(this.gettime());
                   s.setstatus(this.getstatus());
                   
               }
           }   pr = new PrintWriter("Patrols.txt");
           for(Patrols i: patrols){ 
                String Id =i.getcheckid();
                String secid = i.getsecid();
                String date = i.getdate();
                String time = i.gettime();
                String status = i.getstatus();
                pr.println(Id+","+secid+","+date+","+time+","+status);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Complaint.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return patrols;
    }
    
     public static ArrayList<Patrols>Delete(ArrayList<Patrols> patrols, String checkid){
            ArrayList<Patrols> newPatrols= new ArrayList<>();
        try {
           for(Patrols p:patrols){
               String Id = p.getcheckid();
               if(checkid.equals(Id)){
               }else{
                   newPatrols.add(p);
               }
           }
               PrintWriter pr = new PrintWriter("Patrols.txt");
                for (Patrols i: newPatrols){
                    String id = i.getcheckid();
                    String secid=i.getsecid();
                    String date=i.getdate();
                    String time =i.gettime();
                    String status =i.getstatus();
                    pr.println(id+","+secid+","+date+","+time+","+status);
            }
            pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Patrols.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newPatrols;
     }
    
    public static void Write(ArrayList<Patrols> patrols){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Patrols.txt");
            for (Patrols i: patrols){
                    String id = i.getcheckid();
                    String secid=i.getsecid();
                    String date=i.getdate();
                    String time =i.gettime();
                    String status=i.getstatus();
                    pr.println(id+","+secid+","+date+","+time+","+status);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Patrols.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
   
}
