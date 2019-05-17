package com.application.rattrapage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View view;
    RecyclerView cours_recycler;

    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = getLayoutInflater().inflate(R.layout.fragment_home,container,false);
        cours_recycler = view.findViewById(R.id.cours_recycler);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CoursAdapter adapter = new CoursAdapter(getContext(),MainActivity.cours,getActivity());
        cours_recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        cours_recycler.setAdapter(adapter);
    }
}
