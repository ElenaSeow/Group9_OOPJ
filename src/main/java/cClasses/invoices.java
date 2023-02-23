package cClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class invoices {
    
    public static class InvoiceInfo {

        ArrayList<String> ID = new ArrayList();
        ArrayList<String> userID = new ArrayList();
        ArrayList<String> unitID = new ArrayList();
        ArrayList<String> fees = new ArrayList();
        ArrayList<String> outstandingFees = new ArrayList();
        ArrayList<String> date = new ArrayList();
    }

    public static class FileManipulation extends InvoiceInfo {

        public void readFile() {
            ID.clear();
            userID.clear();
            unitID.clear();
            fees.clear();
            outstandingFees.clear();
            date.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("Invoices.txt"))) {
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
            try ( FileWriter file = new FileWriter("Invoices.txt");) {
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
            try ( FileWriter file = new FileWriter("Invoices.txt",true);) {
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
            try ( FileWriter file = new FileWriter("Invoices.txt");) {
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
}
