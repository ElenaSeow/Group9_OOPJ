/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            
//            try (BufferedReader file = new BufferedReader(new FileReader(""))){
//                
//            }
        }
    }
    
}
