package com.extremedesign.matka.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.extremedesign.matka.R;
import com.extremedesign.matka.adapter.ExhibitAdapter;
import com.extremedesign.matka.listener.RecyclerViewChangeLayout;
import com.extremedesign.matka.model.Exhibit;

import java.util.ArrayList;
import java.util.List;

public class ExhibitsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_exhibits, container, false);
        RecyclerView recyclerView= root.findViewById(R.id.home_recyclerView);
        ExhibitAdapter adapter=new ExhibitAdapter(getExhibitList(),getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        return root;
    }
    List<Exhibit> getExhibitList(){
        ArrayList<Exhibit> exhibits=new ArrayList<>();
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title)
                ,R.drawable.eksponati_1,getResources().getString(R.string.display_exhibit_content)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_2)
                ,R.drawable.eksponati_2,getString(R.string.display_exhibit_content_2)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_3)
                ,R.drawable.eksponati_3,getString(R.string.display_exhibit_content_3)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_4)
                ,R.drawable.eksponati_4,getString(R.string.display_exhibit_content_4)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_5)
                ,R.drawable.eksponati_5,getString(R.string.display_exhibit_content_5)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_6)
                ,R.drawable.eksponati_6,getString(R.string.display_exhibit_content_6)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_7)
                ,R.drawable.eksponati_7,getString(R.string.display_exhibit_content_7)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_8)
                ,R.drawable.eksponati_8,getString(R.string.display_exhibit_content_8)));
        exhibits.add(new Exhibit(getResources().getString(R.string.display_exhibit_title_9)
                ,R.drawable.eksponati_9,getString(R.string.display_exhibit_content_9)));
        return exhibits;
    }
}