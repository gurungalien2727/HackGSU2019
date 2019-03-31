package com.example.hackgsu2019;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//import butterknife.ButterKnife;
//import butterknife.InjectView;
//import butterknife.OnClick;

public class HomeActivity  extends AppCompatActivity {


    private cards cards_data[];
    private Button b_red, b_blue; // color buttons
    ImageButton b_green;
    private Button b_reset;
    private PaintPotView drawingPad;
    private ArrayAdapter arrayAdapter;

    private Button _b;
    private int i;
    Database db;


    ListView listView;
    List<cards> rowItem;

    private void init() {
//        b_red = (Button)findViewById(R.id.red_button);
//        b_blue = (Button)findViewById(R.id.blue_button);
          b_green = (ImageButton)findViewById(R.id.green_button);
//        b_reset = (Button)findViewById(R.id.reset_button);

//        b_red.setOnClickListener(this);
//        b_blue.setOnClickListener(this);
//        b_green.setOnClickListener(this);
//        b_reset.setOnClickListener(this);

        drawingPad = (PaintPotView)findViewById(R.id.image);
        if (drawingPad == null) {
            Log.d("null drawing pad init","null drawing pad init");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
       // ButterKnife.inject(this);

        db= new Database(this);
        db.createQuestions();


        Bundle str=getIntent().getExtras();
        String msg=str.getString("content_id");

        rowItem= db.getQuestion(msg);
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
        arrayAdapter = new arrayAdapter(this, R.layout.item, rowItem);

        final SwipeFlingAdapterView flingContainer=(SwipeFlingAdapterView)findViewById(R.id.frame);

        findViewById(R.id.green_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //drawingPad.setPenColor(Color.RED);
            }
        });
        findViewById(R.id.reject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectRight();
            }
        });

        findViewById(R.id.accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectLeft();
            }
        });
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                rowItem.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                db.insertResult(1);
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                db.insertResult(0);
            }

            @Override
           public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //myImages.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }



            public void onScroll(float scrollProgressPercent) {


            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(HomeActivity.this,"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        this.init();
    }





}