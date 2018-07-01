package corp.m.webrtcwebviewtest;

import android.util.Log;
import android.webkit.JavascriptInterface;

import java.lang.annotation.Annotation;

public class WebRTCJavascriptInterface implements JavascriptInterface {
    @Override
    public boolean equals(Object o) {
        Log.i(getClass().getName(), "> equals() called");

        return false;
    }

    @Override
    public int hashCode() {
        Log.i(getClass().getName(), "> hashCode() called");

        return 0;
    }

    @Override
    public String toString() {
        Log.i(getClass().getName(), "> toString() called");

        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        Log.i(getClass().getName(), "> annotationType() called");

        return null;
    }

    @JavascriptInterface
    private void showAlert() {
        Log.i(getClass().getName(), "> showAlert() called: ");
        Log.i(getClass().getName(), "> showAlert() called: ");
        Log.i(getClass().getName(), "> showAlert() called: ");
        Log.i(getClass().getName(), "> showAlert() called: ");
        Log.i(getClass().getName(), "> showAlert() called: ");
        Log.i(getClass().getName(), "> showAlert() called: ");
    }
}
