package com.extremedesign.matka.ui.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.extremedesign.matka.R;
import com.extremedesign.matka.adapter.youtube_adapter.YoutubeRecyclerAdapter;

public class Schedule_VisitFragment extends Fragment {
private ProgressBar progressBar;
private WebView webView;
private LinearLayout userNotConnected;
private Button retryConnection;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         View root = inflater.inflate(R.layout.fragment_schedule_a_visit, container, false);
         webView=root.findViewById(R.id.schedule_a_visit_webView);
        progressBar=root.findViewById(R.id.schedule_a_visit_progressBar);
        userNotConnected =root.findViewById(R.id.linearLayout_fragment_galley_no_Internet);
        retryConnection=root.findViewById(R.id.try_connection_again);
        checkConnectivity();

        return root;
    }
    private void checkConnectivity(){
        final ConnectivityManager conMgr = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
//        conMgr.addDefaultNetworkActiveListener(new ConnectivityManager.OnNetworkActiveListener() {
//            @Override
//            public void onNetworkActive() {
//
//            }
//        });

        if (activeNetwork != null && activeNetwork.isConnected()) {
            userConnectedOpenWeb();
        } else {
            userNotConnectedShowError();

        }
    }
    private void userNotConnectedShowError() {
        userNotConnected.setVisibility(View.VISIBLE);
        retryConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNotConnected.setVisibility(View.GONE);
                checkConnectivity();
            }
        });
    }

    private void userConnectedOpenWeb(){
        progressBar.setVisibility(View.VISIBLE);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setAllowFileAccess(true);
//        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webView.setWebChromeClient(new android.webkit.WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:(function() { " +
                        "(document.evaluate('/html/body/header', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).style.display='none';"+
                        "(document.evaluate('/html/body/footer', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).style.display='none';})()");
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);

            }

        });
        webView.loadUrl("http://matka.com.mk/kontakt/");

    }
}