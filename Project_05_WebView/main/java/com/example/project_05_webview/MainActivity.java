package com.example.project_05_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView webView1;

    String tv01 = "https://www.ediya.com/";
    String tv03 = "https://www.ediya.com/C/";

    TextView textView01, textView03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView1 = (WebView)findViewById(R.id.webView1);
        webView1.setWebViewClient(new MyWebViewClient());

        WebSettings webSettings = webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView1.loadUrl(tv01);

        textView01 = (TextView)findViewById(R.id.tv01);
        textView03 = (TextView)findViewById(R.id.tv01);

        textView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView1.loadUrl(tv01);
            }
        });

        textView03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView1.loadUrl(tv03);
            }
        });

    }

    class MyWebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}