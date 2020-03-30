package com.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
       Bundle bundle =  intent.getBundleExtra("bundle");
      int heads =  bundle.getInt("head",0);
       int bodys = bundle.getInt("body",0);
       int leg =  bundle.getInt("leg",0);
        if(savedInstanceState==null) {
            Work head = new Work();
            Work body = new Work();
            Work legs = new Work();
            head.setList(AndroidImageAssets.getHeads());
            body.setList(AndroidImageAssets.getBodies());
            legs.setList(AndroidImageAssets.getLegs());
            head.setId(heads);
            body.setId(bodys);
            legs.setId(leg);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.headfrag, head).commit();
            fragmentManager.beginTransaction().add(R.id.bodyfrag, body).commit();
            fragmentManager.beginTransaction().add(R.id.legsfrag, legs).commit();

        }
    }


}
