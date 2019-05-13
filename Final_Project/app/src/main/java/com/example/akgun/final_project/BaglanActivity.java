package com.example.akgun.final_project;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BaglanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baglan);

        ArrayList<String> myList = new ArrayList<String>();
        ListView l = (ListView) findViewById(R.id.DeviceList);

        try {

            Resources r = getResources();
            InputStream is = r.openRawResource(R.raw.devices);
            Scanner s = new Scanner(is);

            while (s.hasNext())
            {
                String a = new String(""+s.next()+"");
                myList.add(a);
            }
            ArrayAdapter <String> veriler =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, myList);
            l.setAdapter(veriler);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
