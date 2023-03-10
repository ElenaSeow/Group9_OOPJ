package cClasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Invoices {
    private String invoiceId;
    private String userId;
    private String unitId;
    private String fee;
    private String outstanding;
    private Date date;
    
    public Invoices(String invoiceId,String userId,String unitId, String fee, String outstanding, Date date){
        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=date; 
    
    }
    
    public Invoices(String invoiceId,String userId,String unitId, String fee, String outstanding, String date) throws ParseException{
        Date tdate = new SimpleDateFormat("dd-MM-yyyy").parse(date);

        this.invoiceId=invoiceId;
        this.userId=userId;
        this.unitId=unitId;
        this.fee=fee;
        this.outstanding=outstanding;
        this.date=tdate; 
    
    }
    
    public Invoices() {}
    
    
   
            
    public String getInvoiceId() {
        return invoiceId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getUnitId() {
        return unitId;
    }
    
    public String getFee() {
        return fee;
    }
    
    public String getOutstanding() {
        return outstanding;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setInvoiceId(String invoiceId) {
        this.invoiceId=invoiceId;
    }
    
    public void setUserId(String userId) {
        this.userId=userId;
    }
    
    public void setUnitId(String unitId) {
        this.unitId=unitId;
    }
    
    public void setFee(String fee) {
        this.fee=fee;
    }
    
    public void setOutstanding(String outstanding) {
        this.outstanding=outstanding;
    }
    
    public void setDate(Date date) {
        this.date=date;
    }
    
    
    
    
    public static class InvoiceInfo {

        ArrayList<String> ID = new ArrayList();
        ArrayList<String> userID = new ArrayList();
        ArrayList<String> unitID = new ArrayList();
        ArrayList<String> fees = new ArrayList();
        ArrayList<String> outstandingFees = new ArrayList();
        ArrayList<String> date = new ArrayList();
    }
    
    
    
    public ArrayList<Invoices> Import() {
            BufferedReader br = null;
            ArrayList<Invoices> invoices = new ArrayList<>();
        try {

            String file = "Payment.txt";
            ArrayList<String> data = new ArrayList<>();
            br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while((line=br.readLine())!=null){
                data.add(line);
                
            }
            for(String str:data){
                String[] list = str.split(",");
                invoices.add(new Invoices(list[0],list[1],list[2],list[3],list[4],list[5]));
                
                br.close();
            }   
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Invoices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoices;
    }
    
     public static void tabulateData(ArrayList<Invoices> invoices,JTable table,String id){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for(Invoices u:invoices){
                String userID=u.getUserId();
                String fee = u.getFee();
                if(id.equals(userID)&& !fee.equals("0")){
                    DateFormat date_format = new SimpleDateFormat("dd-MM-yyyy");
                    String date = date_format.format(u.getDate());
                
                    String[] allDataRow = {u.getInvoiceId(),u.getUnitId(),u.getFee(),date};
                    model.addRow(allDataRow);
                }
                
        }
     }
     
     public static void tabulateReport1(JTable table){
            ArrayList<Invoices> invoices = new Invoices().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          ArrayList<Unit> units = Unit.Import();
          for(Invoices i: invoices){
              String userID = i.getUserId();
              String unitID=i.getUnitId();
              String uname = "";
              String uno = "";
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              if( !(i.getFee().equals("0"))){
                String fee = i.getFee();
                String date = df.format(dt);
                String file =Functions.getFile(userID);
                ArrayList<String> userdata = Functions.Read(file);
                for(String str: userdata){
                    String[] l  = str.split(":");
                    if(userID.equals(l[0])){
                        uname = l[1];
                    }
                }
                for(Unit u: units){
                    if(u.getUnitId().equals(unitID)){
                        uno=u.getUnitNo();
                    }
                }
              String[] allDataRow = {i.getInvoiceId(),uno,uname,i.getFee(),date};
              model.addRow(allDataRow);
            }
          }
     }
     
     public static void tabulateReportOut1(JTable table){
            ArrayList<Invoices> invoices = new Invoices().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          ArrayList<Unit> units = Unit.Import();
          for(Invoices i: invoices){
              String userID = i.getUserId();
              String unitID=i.getUnitId();
              String uname = "";
              String uno = "";
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              if(!(i.getFee().equals("0"))){
                String fee = i.getFee();
                String date = df.format(dt);
                String file =Functions.getFile(userID);
                ArrayList<String> userdata = Functions.Read(file);
                for(String str: userdata){
                    String[] l  = str.split(":");
                    if(userID.equals(l[0])){
                        uname = l[1];
                    }
                }
                for(Unit u: units){
                    if(u.getUnitId().equals(unitID)){
                        uno=u.getUnitNo();
                    }
                }
              String[] allDataRow = {i.getInvoiceId(),uno,uname,i.getFee(),date};
              model.addRow(allDataRow);
              }
          }
     }
     
     public static void tabulateReport(JTable table){
            ArrayList<Invoices> invoices = new Invoices().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          ArrayList<Unit> units = Unit.Import();
          for(Invoices i: invoices){
              String userID = i.getUserId();
              String unitID=i.getUnitId();
              String uname = "";
              String uno = "";
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              if(inCurrentMonth(dt)&& !(i.getFee().equals("0"))){
                  String fee = i.getFee();
                  String date = df.format(dt);
                  String file =Functions.getFile(userID);
                  ArrayList<String> userdata = Functions.Read(file);
                  for(String str: userdata){
                      String[] l  = str.split(":");
                      if(userID.equals(l[0])){
                          uname = l[1];
                      }
                  }
                  for(Unit u: units){
                      if(u.getUnitId().equals(unitID)){
                          uno=u.getUnitNo();
                      }
                  }
                String[] allDataRow = {i.getInvoiceId(),uno,uname,i.getFee(),date};
                model.addRow(allDataRow);
              }
          }
     }
     public static void tabulateReportOut(JTable table){
            ArrayList<Invoices> invoices = new Invoices().Import();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
          model.setRowCount(0);
          ArrayList<Unit> units = Unit.Import();
          for(Invoices i: invoices){
              String userID = i.getUserId();
              String unitID=i.getUnitId();
              String uname = "";
              String uno = "";
              SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
              Date dt = i.getDate();
              if(inCurrentMonth(dt)&&!(i.getFee().equals("0"))){
                  String out = i.getOutstanding();
                  String date = df.format(dt);
                  String file =Functions.getFile(userID);
                  ArrayList<String> userdata = Functions.Read(file);
                  for(String str: userdata){
                      String[] l  = str.split(":");
                      if(userID.equals(l[0])){
                          uname = l[1];
                      }
                  }
                  for(Unit u: units){
                      if(u.getUnitId().equals(unitID)){
                          uno=u.getUnitNo();
                      }
                  }
                String[] allDataRow = {i.getInvoiceId(),uno,uname,i.getOutstanding(),date};
                model.addRow(allDataRow);
              }
          }
     }
    public static boolean inCurrentMonth(Date givenDate) {
        ZoneId timeZone = ZoneOffset.ofHours(8); // Use whichever time zone makes sense for your use case
        LocalDateTime givenLocalDateTime = LocalDateTime.ofInstant(givenDate.toInstant(), timeZone);

        YearMonth currentMonth = YearMonth.now(timeZone);

        return currentMonth.equals(YearMonth.from(givenLocalDateTime));
}
    
    public static class FileManipulation extends InvoiceInfo {

        public void readFile() {
            ID.clear();
            userID.clear();
            unitID.clear();
            fees.clear();
            outstandingFees.clear();
            date.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("Payment.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    ID.add(values[0]);
                    userID.add(values[1]);
                    unitID.add(values[2]);
                    fees.add(values[3]);
                    outstandingFees.add(values[4]);
                    date.add(values[5]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void editFile(String ID, String userID, String unitID, String fee, String outstanding, String date) {
            readFile();
            for (int i = 0; i < this.ID.size(); i++) {
                if (ID.equals(this.ID.get(i))) {
                    this.ID.set(i, ID);
                    this.userID.set(i, userID);
                    this.unitID.set(i, unitID);
                    this.fees.set(i, fee);
                    this.outstandingFees.set(i, outstanding);
                    this.date.set(i, date);
                }
            }
            try ( FileWriter file = new FileWriter("Payment.txt");) {
                file.write("INVOICE ID,USER ID,UNIT ID,FEE,OUTSTANDING,DATE\n");
                for (int i = 0; i < this.ID.size(); i++) {
                    file.write(this.ID.get(i) + "," + 
                            this.userID.get(i) + "," + 
                            this.unitID.get(i) + "," + 
                            this.fees.get(i) + "," + 
                            this.outstandingFees.get(i) + "," + 
                            this.date.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void addFile(String userID, String unitID, String fee, String outstanding, String date) {
            readFile();
            try ( FileWriter file = new FileWriter("Payment.txt",true);) {
                String ID = "IV"+(this.ID.size()+1);
                file.write(ID + "," + userID + "," + unitID + "," + fee + "," + outstanding + "," + date + "\n");
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void deleteFile(String ID) {
            readFile();
            for (int i = 0; i < this.ID.size(); i++) {
                if (ID.equals(this.ID.get(i))) {
                    this.ID.remove(i);
                    this.userID.remove(i);
                    this.unitID.remove(i);
                    this.fees.remove(i);
                    this.outstandingFees.remove(i);
                    this.date.remove(i);
                }
            }
            try ( FileWriter file = new FileWriter("Payment.txt");) {
                file.write("INVOICE ID,USER ID,UNIT ID,FEE,OUTSTANDING,DATE\n");
                for (int i = 0; i < this.ID.size(); i++) {
                    file.write(this.ID.get(i) + "," + 
                            this.userID.get(i) + "," + 
                            this.unitID.get(i) + "," + 
                            this.fees.get(i) + "," + 
                            this.outstandingFees.get(i) + "," + 
                            this.date.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
    }
    
    public static ArrayList<Invoices> PAY(ArrayList<Invoices> invoices,String ID, int amount) {
            PrintWriter pr = null;
        try {
            for(Invoices i: invoices){
                String id = i.getInvoiceId();
                if(id.equals(ID)){
                    String userid = i.getUserId();
                    String unitid = i.getUnitId();
                    String fee = i.getFee();
                    String outstanding = i.getOutstanding();
                    String idate = new SimpleDateFormat("dd-MM-yyyy").format(i.getDate());
                    int newfee = Integer.parseInt(fee) - amount;
                    int newout = Integer.parseInt(outstanding);
                    if(newfee<0){
                        newout+=newfee;
                        newfee=0;
                    }
                    fee = String.valueOf(newfee);
                    outstanding = String.valueOf(newout);
                    i.setFee(fee);
                    i.setOutstanding(outstanding);
                    
                }
            }
            pr = new PrintWriter("Payment.txt");
            pr.println("INVOICE ID,USER ID,UNIT ID,FEE,OUTSTANDING,DATE");
            for(Invoices p: invoices){
                String id = p.getInvoiceId();
                String userid = p.getUserId();
                String unitid = p.getUnitId();
                String fee = p.getFee();
                String outstanding = p.getOutstanding();
                String idate = new SimpleDateFormat("dd-MM-yyyy").format(p.getDate());
                pr.println(id+","+userid+","+unitid+","+fee+","+outstanding+","+idate);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pr.close();
        }
        return invoices;
        }
    
    
}
