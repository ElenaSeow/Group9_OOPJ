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

public class Patrolling {
    
    public static class info{

        ArrayList<String> checkid = new ArrayList();
        ArrayList<String> secid = new ArrayList();
        ArrayList<String> date = new ArrayList();
        ArrayList<String> time = new ArrayList();
        ArrayList<String> status = new ArrayList();
    }
    
    public static class fileManipulation extends info {

        public void readFile() {
            checkid.clear();
            secid.clear();
            date.clear();
            time.clear();
            status.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("Patrols.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    checkid.add(values[0]);
                    secid.add(values[1]);
                    date.add(values[2]);
                    time.add(values[3]);
                    status.add(values[4]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        public void editFile(String checkid, String secid, String date, String time, String status) {
            readFile();
            for(int i=0;i<this.checkid.size();i++){
                if(checkid.equals(this.checkid.get(i))){
                    this.checkid.set(i, checkid);
                    this.secid.set(i, secid);
                    this.date.set(i, date);
                    this.time.set(i, time);
                    this.status.set(i, status);
                }
            }
            try ( FileWriter file = new FileWriter("Patrols.txt");) {
                for (int i = 0; i < this.checkid.size(); i++) {
                    file.write(this.checkid.get(i) + "," 
                            + this.secid.get(i) + "," 
                            + this.date.get(i) + "," 
                            + this.time.get(i)+ ","
                            + this.status.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        
        
       
    
        public void addFile(String checkid, String secid, String date, String time, String status) {
            readFile();
            try ( FileWriter file = new FileWriter("Patrols.txt",true);) {
                file.write(checkid+","+secid+","+date+","+time+","+status+ "\n");
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
                }
            }
        
        
        
        public void deleteFile(String ID) {
            readFile();
            for(int i=0;i<this.checkid.size();i++){
                if(ID.equals(this.checkid.get(i))){
                    this.checkid.remove(i);
                    this.secid.remove(i);
                    this.date.remove(i);
                    this.time.remove(i);
                    this.status.remove(i);
                }
            }
            try ( FileWriter file = new FileWriter("Patrols.txt");) {
                int n = 1;
                for(int i=0;i<this.checkid.size();i++){
                    if(this.checkid.get(i).contains(ID.replaceAll("[0-9]", ""))){
                        this.checkid.set(i, this.checkid.get(i).replaceAll("[0-9]", "")+Integer.toString(n));
                        n+=1;
                    }
                }
                for (int i = 0; i < this.checkid.size(); i++) {
                    file.write(this.checkid.get(i) + "," 
                            + this.secid.get(i) + "," 
                            + this.date.get(i) + ","  
                            + this.time.get(i)+ ","
                            + this.status.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
    }
    
    public static class getInfo extends fileManipulation {
        
        public String[] getSecID(){
            readFile();
            List<String> list = new ArrayList();
            for(int i=0;i<checkid.size();i++){
                if(checkid.get(i).contains("SG")){
                    list.add(checkid.get(i));
                }
            }
            String[] info = list.toArray(new String[list.size()]);
            return info;
        }
        
        public ArrayList<String> getUser(int index){
            readFile();
            ArrayList<String> info = new ArrayList();
            info.add(checkid.get(index));
            info.add(secid.get(index));
            info.add(date.get(index));
            info.add(time.get(index));
            info.add(status.get(index));
            return info;
        }
        
        public ArrayList<String> getUser(String ID){
            readFile();
            ArrayList<String> info = new ArrayList();
            for(int i=0;i<this.checkid.size();i++){
                if(ID.equals(this.checkid.get(i))){
                    info.add(this.checkid.get(i));
                    info.add(secid.get(i));
                    info.add(date.get(i));
                    info.add(time.get(i));
                    info.add(status.get(i));
                }
            }
            return info;
        }
        
    }
}
