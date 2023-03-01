package cClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jobs {
    
    public static class info{

        ArrayList<String> ID = new ArrayList();
        ArrayList<String> name = new ArrayList();
        ArrayList<String> email = new ArrayList();
        ArrayList<String> password = new ArrayList();
        ArrayList<String> role = new ArrayList();
        ArrayList<String> contact = new ArrayList();
    }
    
    public static class fileManipulation extends info {

        public void readFile() {
            ID.clear();
            name.clear();
            email.clear();
            password.clear();
            role.clear();
            contact.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("Security.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(":");
                    ID.add(values[0]);
                    name.add(values[1]);
                    email.add(values[2]);
                    password.add(values[3]);
                    role.add(values[4]);
                    contact.add(values[5]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
        
        public void editFile(String ID, String name, String email, String password, String role, String contact) {
            readFile();
            for(int i=0;i<this.ID.size();i++){
                if(ID.equals(this.ID.get(i))){
                    this.ID.set(i, ID);
                    this.name.set(i, name);
                    this.email.set(i, email);
                    this.password.set(i, password);
                    this.role.set(i, role);
                    this.contact.set(i, contact);
                }
            }
            try ( FileWriter file = new FileWriter("Security.txt");) {
                for (int i = 0; i < this.ID.size(); i++) {
                    file.write(this.ID.get(i) + ":" 
                            + this.name.get(i) + ":" 
                            + this.email.get(i) + ":" 
                            + this.password.get(i) + ":" 
                            + this.role.get(i) + ":" 
                            + this.contact.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
    
        public void addFile(String ID, String name, String email, String password, String role, String contact) {
            readFile();
            try ( FileWriter file = new FileWriter("Security.txt",true);) {
                String[] newName = name.split(" ");
                file.write(ID+":"+name+":"+email+":"+password+":"+role+":"+contact+"\n");
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
                }
            }
        
        
        
        public void deleteFile(String ID) {
            readFile();
            for(int i=0;i<this.ID.size();i++){
                if(ID.equals(this.ID.get(i))){
                    this.ID.remove(i);
                    this.name.remove(i);
                    this.email.remove(i);
                    this.password.remove(i);
                    this.role.remove(i);
                    this.contact.remove(i);
                }
            }
            try ( FileWriter file = new FileWriter("Security.txt");) {
                int n = 1;
                for(int i=0;i<this.ID.size();i++){
                    if(this.ID.get(i).contains(ID.replaceAll("[0-9]", ""))){
                        this.ID.set(i, this.ID.get(i).replaceAll("[0-9]", "")+Integer.toString(n));
                        n+=1;
                    }
                }
                for (int i = 0; i < this.ID.size(); i++) {
                    file.write(this.ID.get(i) + ":" 
                            + this.name.get(i) + ":" 
                            + this.email.get(i) + ":"  
                            + this.password.get(i) + ":" 
                            + this.role.get(i) + ":" 
                            + this.contact.get(i) + "\n");
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
            for(int i=0;i<ID.size();i++){
                if(ID.get(i).contains("SG")){
                    list.add(ID.get(i));
                }
            }
            String[] info = list.toArray(new String[list.size()]);
            return info;
        }
        
        public ArrayList<String> getUser(int index){
            readFile();
            ArrayList<String> info = new ArrayList();
            info.add(ID.get(index));
            info.add(name.get(index));
            info.add(email.get(index));
            info.add(password.get(index));
            info.add(role.get(index));
            info.add(contact.get(index));
            return info;
        }
        
        public ArrayList<String> getUser(String ID){
            readFile();
            ArrayList<String> info = new ArrayList();
            for(int i=0;i<this.ID.size();i++){
                if(ID.equals(this.ID.get(i))){
                    info.add(this.ID.get(i));
                    info.add(name.get(i));
                    info.add(email.get(i));
                    info.add(password.get(i));
                    info.add(role.get(i));
                    info.add(contact.get(i));
                }
            }
            return info;
        }
        
    }
}
