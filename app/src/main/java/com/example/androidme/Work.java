package com.example.androidme;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Work extends Fragment {
    private int mId;
    private List<Integer> list;

    public Work() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null)
        {
            list=savedInstanceState.getIntegerArrayList("worklist");
            mId=savedInstanceState.getInt("workmId");
        }
        View view = inflater.inflate(R.layout.fragment_work, container, false);
       final ImageView image  = (ImageView)view.findViewById(R.id.img);
        if(list!=null)
        {
            image.setImageResource(list.get(mId));
        }
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mId< list.size()-1)
                {
                    mId++;
                }
                else
                {
                    mId=0;
                }
                image.setImageResource(list.get(mId));
            }
        });
        return view;
    }

    public void setId(int id)
    {
        this.mId=id;
    }
    public void setList(List<Integer> l)
    {
        this.list=l;
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putIntegerArrayList("worklist",(ArrayList<Integer>) list);
        savedInstanceState.putInt("workmId",mId);
    }
}
