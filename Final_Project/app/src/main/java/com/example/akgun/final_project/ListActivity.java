package com.example.akgun.final_project;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ArrayList<String> myList = new ArrayList<String>();
        ListView l = (ListView) findViewById(R.id.listDevice);

        try {

            Resources r = getResources();
            InputStream is = r.openRawResource(R.raw.devices);
            Scanner s = new Scanner(is);

            while (s.hasNext())
            {
                String a = new String(""+s.next()+"");
                myList.add(a);
            }
            ArrayAdapter<String> veriler =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myList);
            l.setAdapter(veriler);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
