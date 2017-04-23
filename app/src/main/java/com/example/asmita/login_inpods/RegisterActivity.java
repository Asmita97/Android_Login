package com.example.asmita.login_inpods;


        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

        import android.content.Intent;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Context;
        import android.view.Menu;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

/**
 * Created by Asmita on 23-04-2017.
 */

public class RegisterActivity extends Activity {
    DatabaseHelper helper= new DatabaseHelper(this);

    Button SignUpButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
       EditText mFNameView=(EditText)findViewById(R.id.fName);
       EditText mLNameView=(EditText)findViewById(R.id.lName);
        EditText mEmailIdView=(EditText)findViewById(R.id.email_id);
        EditText mPasswordIdView=(EditText)findViewById(R.id.password_id);
        Button  SignUpButton=(Button)findViewById(R.id.sign_up_button);

        final String fnamestr= mFNameView.getText().toString();
        final String lnamestr =mLNameView.getText().toString();
        final String emailIdstr =mEmailIdView.getText().toString();
        final String passstr =mPasswordIdView.getText().toString();
        SignUpButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Details d =new Details();
                d.setFname(fnamestr);
                d.setLname(lnamestr);
                d.setemail(emailIdstr);
                d.setpass(passstr);
                helper.insertDetails(d);
                Intent o= new Intent(RegisterActivity.this,LoginActivity.class);
               startActivity(o);
            }
        });
    }



}