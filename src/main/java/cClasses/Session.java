/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Session extends User{
    public Session(String id){
        super(id);
    }
    public String getId(){
        return super.getId();
    }

    @Override
    public ArrayList<?> Import() {
        return null;
    }
    
}
