package tr.com.emrememis.facedetectorlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class FaceDetectorView extends AppCompatImageView {

    private FaceDetector detector;

    private int radius;
    private RectF mRect = new RectF();
    private Path mClip = new Path();


    public FaceDetectorView(Context context) {
        super(context);
        //init();
    }

    public FaceDetectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public FaceDetectorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.FaceDetectorView);

        try {
            radius = ta.getInt(R.styleable.FaceDetectorView_corners,15);
        }finally {
            ta.recycle();
        }


        detector = new FaceDetector.Builder(getContext())
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

    }

    public void setCorners(int radius) {
        this.radius = radius;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable dr = getDrawable();
        if (dr != null) {
            mRect.set(dr.getBounds());
            getImageMatrix().mapRect(mRect);
            mRect.offset(getPaddingLeft(), getPaddingTop());
            mClip.reset();
            mClip.addRoundRect(mRect, radius, radius, Path.Direction.CCW);
            canvas.clipPath(mClip);
            super.onDraw(canvas);
        }
    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        if (!detector.isOperational()) {
            return;
        }

        Frame frame = new Frame.Builder().setBitmap(bm).build();
        if (frame.getBitmap() == null) {
            return;
        }

        SparseArray<Face> faces = detector.detect(frame);

        if (!(faces.size() > 0)) {
            return;
        }

        Face face = faces.get(0);

        Bitmap bitmap = Bitmap.createBitmap(bm,(int)Math.abs(face.getPosition().x / 1.6) ,
                (int)Math.abs(face.getPosition().y / 3) ,
                bm.getWidth() / 2,bm.getHeight() / 2);
        super.setImageBitmap(bitmap);
    }
}
