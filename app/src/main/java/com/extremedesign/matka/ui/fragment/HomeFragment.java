package com.extremedesign.matka.ui.fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.extremedesign.matka.MainActivity;
import com.extremedesign.matka.R;


public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView exhibits=root.findViewById(R.id.home_fragment_exhibits);
        ImageView history=root.findViewById(R.id.home_fragment_history);
        ImageView videos=root.findViewById(R.id.home_fragment_videos);

        exhibits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.listener.openImage(0);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.listener.openImage(1);
            }
        });
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.listener.openImage(2);
            }
        });
        return root;

    }

}