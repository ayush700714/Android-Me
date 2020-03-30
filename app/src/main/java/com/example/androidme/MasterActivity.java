package com.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MasterActivity extends AppCompatActivity implements ListFragement.OnSetImageListener{

    private int mHead;
    private int mBody;
    private int mLeg;
    private Boolean mHas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        ListFragement listFragement = new ListFragement();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.ax,listFragement).commit();
        if(findViewById(R.id.android_me_linear_layout)!=null)
        {
            mHas=true;
            if(savedInstanceState==null) {
                Work head = new Work();
                Work body = new Work();
                Work legs = new Work();
                head.setList(AndroidImageAssets.getHeads());
                body.setList(AndroidImageAssets.getBodies());
                legs.setList(AndroidImageAssets.getLegs());
                head.setId(0);
                body.setId(0);
                legs.setId(0);
                fragmentManager.beginTransaction().add(R.id.headfrag, head).commit();
                fragmentManager.beginTransaction().add(R.id.bodyfrag, body).commit();
                fragmentManager.beginTransaction().add(R.id.legsfrag, legs).commit();
            }
        }
        else
        {
            mHas=false;
        }
    }
    @Override
    public void onImageClick(int position) {
        int c;
        c = position/12;
        int listIndex;
        FragmentManager fragmentManager = getSupportFragmentManager();
        listIndex = position - 12*c;
        if(mHas)
        {
            switch(c)
            {
                case 0:
                    Work head = new Work();
                    head.setList(AndroidImageAssets.getHeads());
                    head.setId(listIndex);
                    fragmentManager.beginTransaction().replace(R.id.headfrag, head).commit();
                    break;
                case 1:
                    Work body = new Work();
                    body.setList(AndroidImageAssets.getBodies());
                    body.setId(listIndex);
                    fragmentManager.beginTransaction().replace(R.id.headfrag, body).commit();
                    break;
                case 2:
                    Work leg = new Work();
                    leg.setList(AndroidImageAssets.getLegs());
                    leg.setId(listIndex);
                    fragmentManager.beginTransaction().replace(R.id.headfrag, leg).commit();
                    break;
            }
        }
        else
        {
            switch(c)
            {
                case 0:
                    mHead=listIndex;
                    break;
                case 1:
                    mBody=listIndex;
                    break;
                case 2:
                    mLeg=listIndex;
                    break;
            }
            Button bt = (Button)findViewById(R.id.next);
            Bundle b = new Bundle();
            b.putInt("head",mHead);
            b.putInt("body",mBody);
            b.putInt("leg",mLeg);
            final Intent intent = new Intent(MasterActivity.this,MainActivity.class);
            intent.putExtra("bundle",b);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }

    }

}
