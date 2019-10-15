package tr.com.emrememis.androidglidefacecrop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import tr.com.emrememis.facedetectorlibrary.FaceDetectorView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FaceDetectorView faceDetectorView = findViewById(R.id.image);

        Drawable drawable = ActivityCompat.getDrawable(this,R.drawable.image);

        if (drawable == null) {
            return;
        }

        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        faceDetectorView.setImageBitmap(bitmap);
    }
}
