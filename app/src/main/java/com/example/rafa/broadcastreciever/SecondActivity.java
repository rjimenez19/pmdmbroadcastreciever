package com.example.rafa.broadcastreciever;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private WebView webView;
    private int[] listaLlamadasSalientes;
    private int[] listaLlamadasEntrantes;
    private Button btEntrantes, btSalientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        setTitle("Grafica de llamadas");
        webView = (WebView)findViewById(R.id.graficas);
        btEntrantes = (Button) findViewById(R.id.btEntrantes2);
        btSalientes = (Button) findViewById(R.id.btSalientes2);

        final Intent i = getIntent();
        listaLlamadasSalientes = i.getExtras().getIntArray("CursorSalientes");
        listaLlamadasEntrantes = i.getExtras().getIntArray("CursorEntrantes");

    }

    @JavascriptInterface
     public int enviarDiaEntrantes(int x) {
        return listaLlamadasEntrantes[x];
    }


    @JavascriptInterface
    public int enviarDiaSalientes(int x){
        return listaLlamadasSalientes[x];
    }

    public void btsalientes(View v){
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/canvas/salientes.html");

        webView.addJavascriptInterface(this, "InterfazAndroid");
    }

    public void btentrantes (View v){
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/canvas/entrantes.html");

        webView.addJavascriptInterface(this, "InterfazAndroid");
    }
}
