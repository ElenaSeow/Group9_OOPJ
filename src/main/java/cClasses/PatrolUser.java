package cClasses;

import java.util.ArrayList;

abstract public class PatrolUser {
    private String checkid;
    private String secid;
    private String date;
    private String time;
    
    public PatrolUser(String checkid, String secid, String date, String time){
        this.checkid=checkid;
        this.secid=secid;
        this.date=date;
        this.time=time; 
    }
    public PatrolUser(){}

    public PatrolUser(String id){
        this.checkid=id;
    }

    public String getcheckid(){
        return checkid;
    }
    public void setchecid(String checkid){
        this.checkid=checkid;
    }
    public String getsecid(){
        return secid;
    }
    public void setsecid(String secid){
        this.secid=secid;
    }
    public String getdate(){
        return date;
    }
    public void setdate(String date){
        this.date=date;
    }
    public String gettime(){
        return time;
    }
    public void settime(String time){
        this.time=time;
    }


    public abstract ArrayList<?> Import();
}

