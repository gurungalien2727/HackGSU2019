package com.example.hackgsu2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VisionActivity  extends AppCompatActivity {


    Database db;
    EditText name;
    EditText email;
    EditText password;

    Button register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        register = (Button) findViewById(R.id.register);

        db= new Database(this);

    }

    public void onClick(View view){

        boolean isInserted;
        if(name.getText().toString().equals("")||email.getText().toString().equals("")||password.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Enter full details",Toast.LENGTH_SHORT).show();
        }


        else {
            isInserted=db.insertData(name.getText().toString(),email.getText().toString(),password.getText().toString());
            if (isInserted) {

                Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent gotoMain=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(gotoMain);

            } else {

                Toast.makeText(getApplicationContext(), "Could not register", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
