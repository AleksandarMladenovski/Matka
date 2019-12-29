package com.extremedesign.matka.ui.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.extremedesign.matka.R;
import com.extremedesign.matka.adapter.youtube_adapter.YoutubeRecyclerAdapter;
import com.extremedesign.matka.model.YoutubeVideo;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayout userNotConnected;
    private Button retryConnection;
    private ProgressBar progressBar;
    private YoutubeRecyclerAdapter recyclerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView=root.findViewById(R.id.gallery_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerAdapter=new YoutubeRecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                recyclerAdapter.setItems(prepareList());
            }
        }).start();
        userNotConnected =root.findViewById(R.id.linearLayout_fragment_galley_no_Internet);
        retryConnection=root.findViewById(R.id.try_connection_again);
        progressBar=root.findViewById(R.id.gallery_progressBar);
        checkConnectivity();
        return root;
    }
    private void checkConnectivity(){
        progressBar.setVisibility(View.VISIBLE);
        final ConnectivityManager conMgr = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
//        conMgr.addDefaultNetworkActiveListener(new ConnectivityManager.OnNetworkActiveListener() {
//            @Override
//            public void onNetworkActive() {
//
//            }
//        });

        if (activeNetwork != null && activeNetwork.isConnected()) {
            userConnectedListVideoItems();
        } else {
            userNotConnectedShowError();

        }
    }
    private void userNotConnectedShowError() {
        recyclerView.setVisibility(View.GONE);
        userNotConnected.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        retryConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNotConnected.setVisibility(View.GONE);
                checkConnectivity();
            }
        });
    }

    private void userConnectedListVideoItems(){
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
    private List<YoutubeVideo> prepareList() {
        ArrayList<YoutubeVideo> videoArrayList=new ArrayList<>();

        // add first item
        YoutubeVideo video1 = new YoutubeVideo();
        video1.setId(1l);
        video1.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Istorija-na-elektrifikatsija-vo-Makedonija-1200x675.jpg");
        video1.setTitle("History of electrification in Macedonia");
        video1.setVideoId("ci93H59m2IY");

        // add second item
        YoutubeVideo video2 = new YoutubeVideo();
        video2.setId(2l);
        video2.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Energetska-efikasnost-1200x675.jpg");
        video2.setTitle("Energy efficiency");
        video2.setVideoId("u8Yr9vqyU_8");

        // add third item
        YoutubeVideo video3 = new YoutubeVideo();
        video3.setId(3l);
        video3.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Patot-na-strujata-1200x675.jpg");
        video3.setTitle("The path of electricity");
        video3.setVideoId("mXEulg0a1Yk");

        // add four item
        YoutubeVideo video4 = new YoutubeVideo();
        video4.setId(4l);
        video4.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Kako-se-prenesuva-strujata-1200x675.jpg");
        video4.setTitle("How is electricity conducted?");
        video4.setVideoId("Y0roxYTwLwQ");

        // add four item
        YoutubeVideo video5 = new YoutubeVideo();
        video5.setId(5l);
        video5.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Obnovlivi-izvori-1200x675.jpg");
        video5.setTitle("Renewable sources of energy");
        video5.setVideoId("qwkQVShCklw");

        YoutubeVideo video6 = new YoutubeVideo();
        video6.setId(6l);
        video6.setImageUrl("http://matka.com.mk/wp-content/uploads/2018/05/Sto-e-struja-1200x676.jpg");
        video6.setTitle("What is electricity?");
        video6.setVideoId("ohWQvr7y93k");

        videoArrayList.add(video1);
        videoArrayList.add(video2);
        videoArrayList.add(video3);
        videoArrayList.add(video4);
        videoArrayList.add(video5);
        videoArrayList.add(video6);
        return videoArrayList;
    }
}
