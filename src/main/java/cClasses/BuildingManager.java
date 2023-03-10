/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class BuildingManager extends User {
    
    public BuildingManager(String id, String name, String email, String password, String role, String contactNo){
        super(id,name,email,password,role,contactNo);
    }

    public BuildingManager(){}
    
    @Override
    public ArrayList<BuildingManager> Import() {
        BufferedReader br = null;
        ArrayList<BuildingManager> buildingmanagers = new ArrayList<>();
        try {

            String file = "BuildingManager.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                buildingmanagers.add(new BuildingManager(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BuildingManager.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(BuildingManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        return buildingmanagers;
    }
    
     
    
    
}
