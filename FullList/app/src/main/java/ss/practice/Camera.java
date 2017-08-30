    package ss.practice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TOSHIBA on 16-08-2017.
 */
public class Camera extends Activity implements View.OnClickListener {
ImageButton ib;
    Button b;
    ImageView iv;
    Intent i;
    final static int cameraData =0 ;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);
        initialize();
        InputStream is =getResources().openRawResource(R.raw.icon); //in some platform R.drawable but in mine only R.raw did work for getResources()
        bmp= BitmapFactory.decodeStream(is);
    }

    private void initialize() {
    iv=(ImageView)findViewById(R.id.ivReturnedPic);
    ib=(ImageButton)findViewById(R.id.ibTakePic);
    b=(Button)findViewById(R.id.bSetWall);
    b.setOnClickListener(this);
        ib.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSetWall   :
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ibTakePic:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //android.provider.MediaStore.ACTION_IMAGE_CAPTURE;it takes pic and gets that data back
                startActivityForResult(i,cameraData );//inbuild func to start acti. and get some data back
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){ //if operation succeeded
            Bundle extras=data.getExtras();
            bmp=(Bitmap)extras.get("data");
            iv.setImageBitmap(bmp ); //sets pic
        }
    }
}
