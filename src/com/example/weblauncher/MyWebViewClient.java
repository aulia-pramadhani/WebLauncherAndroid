package com.example.weblauncher;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {
    private String webUrl;
    
    public MyWebViewClient(){
        webUrl = "";
    }
    
    public MyWebViewClient(String url){
        this.webUrl = url;
    }
    
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if(Uri.parse(url).getHost().contains(webUrl)) {
            return false;
        }
         
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);
        return true;
    }
}
