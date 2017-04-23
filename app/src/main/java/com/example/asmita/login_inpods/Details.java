package com.example.asmita.login_inpods;

import android.widget.EditText;

/**
 * Created by Asmita on 23-04-2017.
 */

public class Details {
    String fname,lname,email,pass;

    public void setFname(String fname){
        this.fname = fname;
    }
    public String  getFname(){
        return this.fname;
    }
    public void setLname(String lname){
        this.lname = lname;
    }
    public String  getLname(){
        return this.lname;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String  getemail(){
        return this.email;
    }
    public void setpass(String pass){
        this.pass = pass;
    }
    public String getpass(){
        return this.pass;
    }


}
