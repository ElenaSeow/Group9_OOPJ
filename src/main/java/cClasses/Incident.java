package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Incident{
    
    private String Id;
    private String userID;
    private String Desc;
    
    public Incident(String Id, String userID, String Desc) {
        this.Id=Id;
        this.userID=userID;
        this.Desc=Desc;
}
    
    public Incident(){}
    
    

    public String getId() {
        return Id;
    }
    
    public void setId(String Id) {
        this.Id=Id;
    }
    
    public String getuserID() {
        return userID;
    }
    
    public void setuserID(String userID) {
        this.userID=userID;
    }
    
    public String getDesc() {
        return Desc;
    }
    
    public void setDesc(String Desc) {
        this.Desc=Desc;
    }
    
    public static class IncidentInfo {

        ArrayList<String> Id = new ArrayList();
        ArrayList<String> userID = new ArrayList();
        ArrayList<String> Desc = new ArrayList();
    }
    
    
    
    public ArrayList<Incident> Import() {
        BufferedReader br = null;
        ArrayList<Incident> incidents = new ArrayList<>();
        try {
            String file = "Incidents.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                incidents.add(new Incident(list[0],list[1],list[2]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Incident.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Incident.class.getName()).log(Level.SEVERE, null, ex);
            }
        return incidents;
        }
   
   public static void tabulateData(ArrayList<Incident> incidents,JTable table){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
       for(Incident s: incidents){
            String[] allDataRow = {s.getId(),s.getuserID(),s.getDesc()};
            model.addRow(allDataRow);
        }
   }
   public ArrayList<Incident> Update(ArrayList<Incident> incidents, String id){
        PrintWriter pr = null;
        ArrayList<String> data=new ArrayList<>();
    try {
        for(Incident s:incidents){
            String Id = s.getId();
            if(id.equals(Id)){
                s.setuserID(this.getuserID());
                s.setDesc(this.getDesc());

                
                data.add(s.getId()+":"+s.getuserID()+":"+s.getDesc());
            }else{
                data.add(s.getId()+":"+s.getuserID()+":"+s.getDesc());
            }
        }   pr = new PrintWriter("Incidents.txt");
        for(String i:data){
            
            pr.println(i);
            System.out.println(i);
        }   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Incident.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        pr.close();
    }
        return incidents;
    }

    public static void Write(ArrayList<Incident> incidents){
            PrintWriter pr;
        try {
            pr = new PrintWriter("Incidents.txt");
            for (Incident i: incidents){
                String id=i.getId();
                String userID=i.getuserID();
                String Desc=i.getDesc();
                pr.println(id+":"+userID+":"+Desc);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Incident.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
   
    
    public static class fileManipulation extends IncidentInfo {

        public void readFile() {
                Id.clear();
                userID.clear();
                Desc.clear();

                try ( BufferedReader file = new BufferedReader(new FileReader("Incidents.txt"))) {
                    String line;
                    file.readLine();
                    while ((line = file.readLine()) != null) {
                        String[] values = line.split(":");
                        Id.add(values[0]);
                        userID.add(values[1]);
                        Desc.add(values[2]);
                    }
                } catch (IOException e) {
                    System.out.println("Incorrect File Path");
                }
            }
    
    public void addFile(String Id, String userID, String Desc) {
        readFile();
            try ( FileWriter file = new FileWriter("Incidents.txt",true);) {
                file.write(Id+":"+userID+":"+Desc+"\n");
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
                }
        }
    }
    
    public static class getInfo extends Incident.fileManipulation {
        
        public String[] getId(){
            readFile();
            List<String> list = new ArrayList();
            for(int i=0;i<Id.size();i++){
                if(Id.get(i).contains("IC")){
                    list.add(Id.get(i));
                }
            }
            String[] info = list.toArray(new String[list.size()]);
            return info;
        }
        
        public ArrayList<String> getUser(int index){
            readFile();
            ArrayList<String> info = new ArrayList();
            info.add(Id.get(index));
            info.add(userID.get(index));
            info.add(Desc.get(index));

            return info;
        }
        
        public ArrayList<String> getUser(String Id){
            readFile();
            ArrayList<String> info = new ArrayList();
            for(int i=0;i<this.Id.size();i++){
                if(Id.equals(this.Id.get(i))){
                    info.add(this.Id.get(i));
                    info.add(userID.get(i));
                    info.add(Desc.get(i));
  
                }
            }
            return info;
        }
    }
}