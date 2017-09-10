package ss.practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TOSHIBA on 09-09-2017.
 */
public class SimpleBrowser extends Activity implements View.OnClickListener {
    EditText url;
    WebView ourBrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        ourBrow=(WebView)findViewById(R.id.wvbrowser);
        ourBrow.getSettings().setJavaScriptEnabled(true); //this enables JavaScript as some sites like YT needs it
        ourBrow.getSettings().setLoadWithOverviewMode(true);    //zoomed out(bootstrap type)
        ourBrow.getSettings().setUseWideViewPort(true);     //sets up like normal browser's dimension

        ourBrow.setWebViewClient(new OurViewClient()); //as android uses its own browser to open links so we override this
        try {
            ourBrow.loadUrl("http://www.wikipedia.org"); //loads webpages
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Button go=(Button)findViewById(R.id.bGo);
        Button back=(Button)findViewById(R.id.bBAck);
        Button refresh=(Button)findViewById(R.id.bRefresh);
        Button forward=(Button)findViewById(R.id.bForward);
        Button clearHistory=(Button)findViewById(R.id.bHistory);
        url=(EditText)findViewById(R.id.etURL);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        refresh.setOnClickListener(this);
        forward.setOnClickListener(this);
        clearHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bGo:
                String website=url.getText().toString() ;
                ourBrow.loadUrl(website);
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); //setting up
                imm.hideSoftInputFromWindow(url.getWindowToken(),0); //hides keyboard when Go clicked(after using EditText)
                break;
            case R.id.bBAck:
                if(ourBrow.canGoBack())
                    ourBrow.goBack();
                break;
            case R.id.bForward:
                if(ourBrow.canGoForward())
                    ourBrow.goForward();
                break;
            case R.id.bRefresh:
            ourBrow.reload();
                break;
            case R.id.bHistory:
            ourBrow.clearHistory();
                break;

        }
    }
}
