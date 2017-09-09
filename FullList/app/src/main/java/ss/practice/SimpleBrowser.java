package ss.practice;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by TOSHIBA on 09-09-2017.
 */
public class SimpleBrowser extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        WebView ourBrow=(WebView)findViewById(R.id.wvbrowser);
        ourBrow.loadUrl("http://www.wikipedia.org"); //loads webpages
    }
}
