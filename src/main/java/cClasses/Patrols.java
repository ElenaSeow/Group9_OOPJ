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
import java.util.Date;

public class Patrols {
    public static class info {

        ArrayList<String> checkpointID = new ArrayList();
        ArrayList<String> securityID = new ArrayList();
        ArrayList<String> date = new ArrayList();
        ArrayList<String> time = new ArrayList();
        ArrayList<String> inOut = new ArrayList();
    }
    
public static class fileManipulation extends info {

        public void readFile() {
            checkpointID.clear();
            securityID.clear();
            date.clear();
            time.clear();
            inOut.clear();
            try ( BufferedReader file = new BufferedReader(new FileReader("patrols.txt"))) {
                String line;
                file.readLine();
                while ((line = file.readLine()) != null) {
                    String[] values = line.split(",");
                    checkpointID.add(values[0]);
                    securityID.add(values[1]);
                    date.add(values[2]);
                    time.add(values[3]);
                    inOut.add(values[4]);
                }
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void editFile(String checkID, String secID, String date, String time, String inOut) {
            readFile();
            for (int i = 0; i < this.checkpointID.size(); i++) {
                if (checkID.equals(this.checkpointID.get(i))) {
                    this.checkpointID.set(i, checkID);
                    this.securityID.set(i, secID);
                    this.date.set(i, date);
                    this.time.set(i, time);
                    this.inOut.set(i, inOut);
                }
            }
            try ( FileWriter file = new FileWriter("patrols.txt");) {
                file.write("﻿CHECKPOINT ID,SECURITY ID,DATE,TIME,IN/OUT\n");
                for (int i = 0; i < this.checkpointID.size(); i++) {
                    file.write(this.checkpointID.get(i) + "," + this.securityID.get(i) + "," + this.date.get(i) + "," + this.time.get(i) + "," + this.inOut.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void addFile(String checkID, String secID, String date, String time, String inOut) {
            readFile();
            try ( FileWriter file = new FileWriter("patrols.txt",true);) {
                file.write(checkID + "," + secID + "," + date + "," + time + "," + inOut + "\n");
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }

        public void deleteFile(String checkID) {
            readFile();
            for (int i = 0; i < this.checkpointID.size(); i++) {
                if (checkID.equals(this.checkpointID.get(i))) {
                    this.checkpointID.remove(i);
                    this.securityID.remove(i);
                    this.date.remove(i);
                    this.time.remove(i);
                    this.inOut.remove(i);
                }
            }
            try ( FileWriter file = new FileWriter("patrols.txt");) {
                file.write("﻿CHECKPOINT ID,SECURITY ID,DATE,TIME,IN/OUT\n");
                for (int i = 0; i < this.checkpointID.size(); i++) {
                    file.write(this.checkpointID.get(i) + "," + this.securityID.get(i) + "," + this.date.get(i) + "," + this.time.get(i) + "," + this.inOut.get(i) + "\n");
                }
                file.close();
            } catch (IOException e) {
                System.out.println("Incorrect File Path");
            }
        }
    }
}
