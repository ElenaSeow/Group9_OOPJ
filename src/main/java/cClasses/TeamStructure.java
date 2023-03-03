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
public class TeamStructure {
    private String tsid;
    private String employeetype;
    private String OpId;
    private int amount;
    private String remarks;
    
    public TeamStructure(String tsid, String OpId, String employeetype, int amount, String remarks){
        this.tsid = tsid;
        this.employeetype = employeetype;
        this.OpId = OpId;
        this.amount = amount;
        this.remarks = remarks;
    }
    
    public TeamStructure(String tsid,String OpId, String employeetype, String amount, String remarks){
        this.tsid = tsid;
        this.employeetype = employeetype;
        this.OpId = OpId;
        this.amount = Integer.parseInt(amount);
        this.remarks = remarks;
    }
    
    
    public String getTsid(){
        return tsid;
    }
    
    public void setTsid(String tsid){
        this.tsid = tsid;
    }
    
    public String getEmployeetype(){
        return employeetype;
    }
    
    public void setEmployeetype(String employeetype){
        this.employeetype = employeetype;
    }
    
    public String getOpId(){
        return OpId;
    }
    
    public void setOpId(String OpId){
        this.OpId = OpId;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public void setAmount(Integer amount){
        this.amount = amount;
    }
    public void setAmount(String amount){
        this.amount = Integer.parseInt(amount);
    }
    
    public String getRemarks(){
        return remarks;
    }
    
    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
    
    
    
    //arraylist for Table
    public static ArrayList<TeamStructure> Import(){
        BufferedReader br = null;
        ArrayList<TeamStructure> ts = new ArrayList<TeamStructure>();
    try {
        
        String file = "TeamStructure.txt";
        ArrayList<String> data = new ArrayList<>();
        br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            data.add(line);
        }
        for(String str:data){
            String[] list = str.split(":");
            ts.add(new TeamStructure(list[0],list[1],list[2],list[3],list[4]));
            
            br.close();
            
            
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(TeamStructure.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
            Logger.getLogger(TeamStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ts;    
    }
    public static void tabulateData(ArrayList<TeamStructure> ts,JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(TeamStructure t:ts){
            String am = String.valueOf(t.getAmount());
            String[] allDataRow = {t.getTsid(),t.getOpId(),t.getEmployeetype(),am,t.getRemarks()};
            model.addRow(allDataRow);
        }
    }
    
    //update or modify FUNCTION
    public ArrayList<TeamStructure> Update(ArrayList<TeamStructure> ts, String Tsid){
        PrintWriter pr = null;
    try {
        for (TeamStructure t:ts){
            String Id = t.getTsid();
            if(Tsid.equals(Id)){
                t.setTsid(this.getTsid());
                t.setEmployeetype(this.getEmployeetype());
                t.setOpId(this.getOpId());
                t.setAmount(this.getAmount());
                t.setRemarks(this.getRemarks());
            }
        }   pr = new PrintWriter("TeamStructure.txt");
        for(TeamStructure t:ts){
            String Id=t.getTsid();
            String employeetype=t.getEmployeetype();
            String OpId=t.getOpId();
            String amount=String.valueOf(t.getAmount());
            String remarks=t.getRemarks();
            pr.println(Id+":"+OpId+":"+employeetype+":"+amount+":"+remarks);
                }
    } catch (FileNotFoundException ex){
            Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        pr.close();
    }
    return ts;
     }
    
    //write or add FUNCTION
    public static void Write(ArrayList<TeamStructure> ts){
        PrintWriter pr = null;
    try {
        pr = new PrintWriter("TeamStructure.txt");
        for (TeamStructure t:ts){
            String Id=t.getTsid();
            String employeetype=t.getEmployeetype();
            String OpId=t.getOpId();
            String amount=String.valueOf(t.getAmount());
            String remarks=t.getRemarks();
            pr.println(Id+":"+OpId+":"+employeetype+":"+amount+":"+remarks);
        }
        pr.close();    
    } catch (FileNotFoundException ex){
        Logger.getLogger(TeamStructure.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
//    delete FUNCTION
//    public static ArrayList<AccountExecutive>Delete(ArrayList<AccountExecutive> ae, String id){
//        ArrayList<AccountExecutive> newAe= new ArrayList<>();
//    try {
//        for(AccountExecutive a:ae){
//            String Id = a.getid();
//            if(id.equals(Id)){
//            }else{
//                newAe.add(a);
//            }   
//        }
//            PrintWriter pr = new PrintWriter("accountexecutive.txt");
//            for (AccountExecutive i: newAe){
//                String Id=i.getid();
//                String name=i.getname();
//                String email=i.getemail();
//                String password=i.getpassword();
//                String role=i.getrole();
//                String number=i.getnumber();
//                String unitid=i.getunitid();
//                pr.println(Id+":"+name+":"+email+":"+password+":"+role+":"+number+":"+unitid);
//            }
//            pr.close();
//    } catch (FileNotFoundException ex) {
//        Logger.getLogger(AccountExecutive.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    return newAe;
//    }
    
}
