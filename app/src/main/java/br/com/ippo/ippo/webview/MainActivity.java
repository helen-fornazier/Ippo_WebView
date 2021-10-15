package br.com.ippo.ippo.webview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            //super.onBackPressed();
            webView.loadUrl("https://ippo.com.br/iniciomobile");
        }
    }
    private void enableHTML5AppCache(WebSettings settings) {
        settings.setDomStorageEnabled(true);
        settings.setAppCachePath(getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();

        settings.setUseWideViewPort(true);
        enableHTML5AppCache(settings);
        webView.loadUrl("https://ippo.com.br/iniciomobile");

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                findViewById(R.id.splash).setVisibility(View.GONE);
                findViewById(R.id.webview).setVisibility(View.VISIBLE);
            }
        });
    }
}