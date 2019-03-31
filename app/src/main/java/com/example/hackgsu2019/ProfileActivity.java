package com.example.hackgsu2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

        // Array of strings for ListView Title
        String[] listviewTitle = new String[]{
                "Animals", "Plants", "Medical", "Sports",

        };


        int[] listviewImage = new int[]{
                R.drawable.cat, R.drawable.plant, R.drawable.medical, R.drawable.sport,

        };

        String[] listviewShortDescription = new String[]{
                "", "", "", "",
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.profile_main);

            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            for (int i = 0; i < 3; i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", listviewTitle[i]);
                hm.put("listview_discription", listviewShortDescription[i]);
                hm.put("listview_image", Integer.toString(listviewImage[i]));
                aList.add(hm);
            }

            String[] from = {"listview_title","listview_image", "listview_discription"};
            int[] to = {R.id.listview_item_title,R.id.listview_image,  R.id.listview_item_short_description};

            SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout, from, to);
            ListView androidListView = (ListView) findViewById(R.id.list_view);
            androidListView.setAdapter(simpleAdapter);
            androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    String selectedItem = parent.getItemAtPosition(position).toString();
                    String mainChapterNumber = selectedItem.split("\\,", 2)[0];
                    String data = mainChapterNumber.substring(mainChapterNumber.indexOf("=")+1);
                    String toBePassed="";
                    switch(position){
                        case 0:
                            toBePassed="Animals";
                            break;
                        case 1:
                            toBePassed="Plants";
                            break;
                        case 2:
                            toBePassed="Medical";
                            break;

                    }
                    //Toast.makeText(getApplicationContext(),toBePassed,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("content_id", toBePassed);
                    startActivity(intent);


                }
            });
        }
    }


