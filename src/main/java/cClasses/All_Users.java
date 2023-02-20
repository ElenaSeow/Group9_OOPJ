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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class All_Users {
    
    public static class info {
        ArrayList<String> id = new ArrayList();
        ArrayList<String> name = new ArrayList();
        ArrayList<String> email = new ArrayList();
        ArrayList<String> password = new ArrayList();
        ArrayList<String> roles = new ArrayList();
        ArrayList<String> telno = new ArrayList();
        
    }
    
    public static class fileManipulation extends info {
        
        public void readFile() {
            id.clear();
            name.clear();
            email.clear();
            password.clear();
            roles.clear();
            telno.clear();
            
            try (BufferedReader file = new BufferedReader(new FileReader("All_Users.txt"))){
                String line;
                file.read();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(":");
                    id.add(values[0]);
                    name.add(values[1]);
                    email.add(values[2]);
                    password.add(values[3]);
                    roles.add(values[4]);
                    telno.add(values[5]);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(All_Users.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(All_Users.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void editFile(String id, String name, String email, String password, String roles, String telno) {
            readFile();
            
        }
    }
    
}
