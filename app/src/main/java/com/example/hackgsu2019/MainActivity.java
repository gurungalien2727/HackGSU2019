package com.example.hackgsu2019;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database db;

    EditText email;
    EditText password;
    TextView registerHere;;
   // Button show;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new Database(this);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);

        //show=(Button)findViewById(R.id.show);
        login=(Button)findViewById(R.id.login);

        /*show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res=db.getCursor();

                if(res.getCount()==0){
                    Toast.makeText(getApplicationContext(),"No data in database",Toast.LENGTH_SHORT).show();
                }
                else{

                    StringBuffer sb=new StringBuffer();
                    while(res.moveToNext()){
                        sb.append(res.getString(0)+" "+res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+"\n");
                    }

                    display("Data",sb.toString());

                }
            }
        });*/


        registerHere=(TextView)findViewById(R.id.registerHere);
        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent gotoRegister=new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(gotoRegister);

            }
        });

    }

    public void display(String title,String data){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setMessage(data);

        builder.show();

    }



    public void login(View view){


        if(email.getText().toString().equals("")||password.getText().toString().equals("")){

            Toast.makeText(getApplicationContext(),"Enter email and password",Toast.LENGTH_SHORT).show();
        }

        else{

            boolean isThere;

            isThere=db.checkUser(email.getText().toString(),password.getText().toString());

            if(isThere) {

                Toast.makeText(getApplicationContext(),"Logged In", Toast.LENGTH_SHORT).show();
                Intent loggedIn=new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(loggedIn);


            }

            else{

                Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();

            }


            email.setText("");
            password.setText("");


        }



    }


}
