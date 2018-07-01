package corp.m.webrtcwebviewtest;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.*;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });

        myWebView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                android.util.Log.d("WebView", consoleMessage.message());
                return true;
            }

           // @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                Log.i("permissionRequest", "|> onPermissionRequest");

                request.grant(request.getResources());

                /*MainActivity.this.runOnUiThread(new Runnable(){
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        Log.i("permissionRequest", "|> onPermissionRequest run");
                        request.grant(request.getResources());
                    }
                });*/
            }
        });

        WebRTCJavascriptInterface jsInterface = new WebRTCJavascriptInterface();

        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(jsInterface, "androidInterface");

        // myWebView.loadUrl("https://service.medimetry.in/video-call/684/70921");
        myWebView.loadUrl("https://service.medimetry.in/video-call/684");

        // myWebView.addJavascriptInterface(jsInterface, "androidInterface");
    }
}
