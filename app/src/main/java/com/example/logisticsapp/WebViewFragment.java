package com.example.logisticsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;

public class WebViewFragment extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_webview, container, false);

        // Initialize WebView
        webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());  // Ensures links open inside the WebView
        webView.loadUrl("https://nisrajvats.github.io/LogisticsWEB/");

        return view;
    }
}
