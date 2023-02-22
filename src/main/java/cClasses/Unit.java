/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Unit {
    private String unitId;
    private String unitNo;
    private String block;
    private int bedroom;
    private int bathroom;
    private int sqrft;
    private String status;
//    private String residentId;
    
//    public Unit(String unitId, String unitNo, String block, int bedroom, int bathroom,int sqrft, String status, String residentId){
//        this.unitId=unitId;
//        this.unitNo=unitNo;
//        this.block=block;
//        this.bedroom=bedroom;
//        this.bathroom=bathroom;
//        this.sqrft=sqrft;
//        this.status=status;
//        this.residentId=residentId;
//    }
    public Unit(String unitId, String unitNo, String block, int bedroom, int bathroom,int sqrft, String status){
        this.unitId=unitId;
        this.unitNo=unitNo;
        this.block=block;
        this.bedroom=bedroom;
        this.bathroom=bathroom;
        this.sqrft=sqrft;
        this.status=status;

    }
    
//        public Unit(String unitId, String unitNo, String block, String bedroom, String bathroom,String sqrft, String status, String residentId){
//            int Ibedroom = Integer.parseInt(bedroom);
//            int Ibathroom = Integer.parseInt(bathroom);
//            int Isqrft = Integer.parseInt(sqrft);
//
//            this.unitId=unitId;
//            this.unitNo=unitNo;
//            this.block=block;
//            this.bedroom=Ibedroom;
//            this.bathroom=Ibathroom;
//            this.sqrft=Isqrft;
//            this.status=status;
//            this.residentId=residentId;
//    }
        public Unit(String unitId, String unitNo, String block, String bedroom, String bathroom,String sqrft, String status){
            int Ibedroom = Integer.parseInt(bedroom);
            int Ibathroom = Integer.parseInt(bathroom);
            int Isqrft = Integer.parseInt(sqrft);

            this.unitId=unitId;
            this.unitNo=unitNo;
            this.block=block;
            this.bedroom=Ibedroom;
            this.bathroom=Ibathroom;
            this.sqrft=Isqrft;
            this.status=status;

    }
        public String getUnitId(){
            return unitId;
        }
        public String getUnitNo(){
            return unitNo;
        }
        public String getBlock(){
            return block;
        }
        public int getBedroom(){
            return bedroom;
        }
        public int getBathroom(){
            return bathroom;
        }
        public int getSqrft(){
            return sqrft;
        }
        public String getStatus(){
            return status;
        }
//        public String getResidentId(){
//            return residentId;
//        }
        
        public void setUnitNo(String unitNo){
            this.unitNo=unitNo;
        }
        public void setBlock(String block){
            this.block=block;
        }
        public void setBedroom(String bedroom){
            int bed = Integer.parseInt(bedroom);
            this.bedroom=bed;
        }
        public void setBedroom(int bedroom){
            this.bedroom=bedroom;
        }
        public void setBathroom(String bathroom){
            int bath = Integer.parseInt(bathroom);
            this.bathroom=bath;
        }
        public void setBathroom(int bathroom){
            this.bathroom=bathroom;
        }
        public void setSqrft(String sqrft){
            int sqr = Integer.parseInt(sqrft);
            this.sqrft=sqr;
        }
        public void setSqrft(int sqrft){
            this.sqrft=sqrft;
        }
        public void setStatus(String status){
            this.status=status;
        }
//        public void setResidentId(String residentId){
//            this.residentId=residentId;
//        }
        public static ArrayList<Unit> Import(){
            BufferedReader br = null;
            ArrayList<Unit> units = new ArrayList<Unit>();
        try {

            String file = "Units.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(":");
                units.add(new Unit(list[0],list[1],list[2],list[3],list[4],list[5],list[6]));
                
                br.close();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
                Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
            }
        return units;
        }
        public static void tabulateData(ArrayList<Unit> units,JTable table){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(Unit u:units){
                String bed = String.valueOf(u.getBedroom());
                String bath = String.valueOf(u.getBathroom());
                String sqr = String.valueOf(u.getSqrft());
                String[] allDataRow = {u.getUnitId(),u.getUnitNo(),u.getBlock(),bed,bath,sqr,u.getStatus()};
                model.addRow(allDataRow);
        }
    } 
        
        public ArrayList<Unit> Update(ArrayList<Unit> units, String id){
            PrintWriter pr = null;
        try {
           for(Unit u:units){
               String Id = u.getUnitId();
               if(id.equals(Id)){
                   u.setUnitNo(this.getUnitNo());
                   u.setBlock(this.getBlock());
                   u.setBedroom(this.getBedroom());
                   u.setBathroom(this.getBathroom());
                   u.setStatus(this.getStatus());
//                   u.setResidentId(this.getResidentId());
               }
           }   pr = new PrintWriter("Units.txt");
           for(Unit u: units){ 
                String unitid=u.getUnitId();
                   String unitno=u.getUnitNo();
                   String block=u.getBlock();
                   String bedrooms=String.valueOf(u.getBedroom());
                   String bathrooms=String.valueOf(u.getBathroom());
                   String sqrft=String.valueOf(u.getSqrft());
                   String status=u.getStatus();
//                   String residentid=u.getResidentId();
                   pr.println(unitid+":"+unitno+":"+block+":"+bedrooms+":"+bathrooms+":"+sqrft+":"+status);
                       }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
       } finally {
           pr.close();
       }
       return units;
        }
        
        public static ArrayList<Unit>Delete(ArrayList<Unit> units, String id){
            ArrayList<Unit> newUnits= new ArrayList<>();
        try {
           for(Unit u:units){
               String Id = u.getUnitId();
               if(id.equals(Id)){
               }else{
                   newUnits.add(u);
               }
           }
               PrintWriter pr = new PrintWriter("Units.txt");
               for (Unit i: newUnits){
                   String unitid=i.getUnitId();
                   String unitno=i.getUnitNo();
                   String block=i.getBlock();
                   String bedrooms=String.valueOf(i.getBedroom());
                   String bathrooms=String.valueOf(i.getBathroom());
                   String sqrft=String.valueOf(i.getSqrft());
                   String status=i.getStatus();
                   pr.println(unitid+":"+unitno+":"+block+":"+bedrooms+":"+bathrooms+":"+sqrft+":"+status);
               }
               pr.close();
               
        } catch (FileNotFoundException ex) {
           Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);         
       }
       return newUnits;

   }
        public static void Write(ArrayList<Unit> units){
            PrintWriter pr = null;
        try {
            pr = new PrintWriter("Units.txt");
            for (Unit i: units){
                String unitid=i.getUnitId();
                String unitno=i.getUnitNo();
                String block=i.getBlock();
                String bedrooms=String.valueOf(i.getBedroom());
                String bathrooms=String.valueOf(i.getBathroom());
                String sqrft=String.valueOf(i.getSqrft());
                String status=i.getStatus();
                pr.println(unitid+":"+unitno+":"+block+":"+bedrooms+":"+bathrooms+":"+sqrft+":"+status);
            }
            pr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Unit.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
