/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cClasses;

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
    private String status;
    private String residentId;
    
    public Unit(String unitId, String unitNo, String block, int bedroom, int bathroom, String status, String residentId){
        this.unitId=unitId;
        this.unitNo=unitNo;
        this.block=block;
        this.bedroom=bedroom;
        this.bathroom=bathroom;
        this.status=status;
        this.residentId=residentId;
    }
    
        public Unit(String unitId, String unitNo, String block, String bedroom, String bathroom, String status, String residentId){
        int Ibedroom = Integer.parseInt(bedroom);
        int Ibathroom = Integer.parseInt(bathroom);
            
        this.unitId=unitId;
        this.unitNo=unitNo;
        this.block=block;
        this.bedroom=Ibedroom;
        this.bathroom=Ibathroom;
        this.status=status;
        this.residentId=residentId;
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
        public String getStatus(){
            return status;
        }
        public String getResidentId(){
            return residentId;
        }
        
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
        public void setStatus(String status){
            this.status=status;
        }
        public void setResidentId(String residentId){
            this.residentId=residentId;
        }
}
