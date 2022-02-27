package com.eict.webbrowserapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class UrlSearch extends AppCompatActivity {
Button search2,home;
EditText text2;
WebView webview;
String url;
    ProgressDialog pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_search);
        search2=findViewById(R.id.search2);
        home=findViewById(R.id.home);
        text2=findViewById(R.id.text2);
        pb= new ProgressDialog(this);
        webview=findViewById(R.id.webview);
        url= getIntent().getExtras().get("url_address").toString();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.loadUrl(url);

        webview.setWebViewClient(new Browser());
        webview.setWebChromeClient(new WebChromeClient()
                                   {
                                       @Override
                                       public void onProgressChanged(WebView view, int newProgress) {
                                           if (newProgress<100)
                                           {
                                               pb.show();
                                           }
                                           else
                                           {
                                               pb.dismiss();
                                           }
                                           super.onProgressChanged(view, newProgress);
                                       }
                                   }

        );

    }
    private class Browser extends WebViewClient
    {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webview.loadUrl(String.valueOf(request.getUrl()));
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(webview!=null && webview.canGoBack())
        {
            webview.goBack();
        }
        else
            super.onBackPressed();
    }
}


