package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, // The LayoutInflater object that can be used to inflate any views in the fragment
                             ViewGroup container,
                             Bundle savedInstance){
        return inflater.inflate(R.layout.fragment_two,container,false);
    }
}
