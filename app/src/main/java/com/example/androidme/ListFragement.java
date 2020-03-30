package com.example.androidme;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class ListFragement extends Fragment {

    OnSetImageListener mListener;

    public ListFragement() {
        // Required empty public constructor
    }
    public interface OnSetImageListener{
        void onImageClick(int position);
    }
    @Override
     public void onAttach(Context context)
     {
         super.onAttach(context);
         mListener = (OnSetImageListener) context;
     }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_fragement, container, false);
        GridView gridView = (GridView)view.findViewById(R.id.fraglist);
        MasterListAdapter adapter = new MasterListAdapter(inflater.getContext(),AndroidImageAssets.getAll());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onImageClick(i);
            }
        });
        return view;
    }

}
