package ss.practice;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by TOSHIBA on 10-09-2017.
 */
public class OurViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url){
    v.loadUrl(url);
    return  true;
}
}
