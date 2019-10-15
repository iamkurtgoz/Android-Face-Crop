FaceCrop for Android Studio
========
FaceDetectorView is a cropper image library Android.<br>

![Rewind](https://github.com/memishood/Android-Face-Crop/blob/master/Ads%C4%B1z4.png)
-------------------

Let me show how to use this library:

## Setup
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    implementation 'com.github.memishood:Android-Face-Crop:1.0'
}
```

## XML

```xml
<tr.com.emrememis.facedetectorlibrary.FaceDetectorView
                android:id="@+id/image"
                android:layout_width="96dp"
                android:layout_height="96dp"
                app:corners="200"
                android:layout_gravity="center"/>
```
## Params

| Params | Value |
| :------: | :------: |
| app:corners | 200 |
-------------------

## Java

```java  
        FaceDetectorView faceDetectorView = findViewById(R.id.image);
        Drawable drawable = ActivityCompat.getDrawable(this,R.drawable.image);
        if (drawable == null) {
            return;
        }
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        faceDetectorView.setImageBitmap(bitmap);
```

it works only with setImageBitmap, maybe i improve in the future



-------------------
## Some screenshot for better understanding
![Rewind](https://github.com/memishood/Android-Face-Crop/blob/master/Ads%C4%B1z.png)
-------------------
![Rewind](https://github.com/memishood/Android-Face-Crop/blob/master/Ads%C4%B1z2.png)
-------------------
![Rewind](https://github.com/memishood/Android-Face-Crop/blob/master/Ads%C4%B1z3.png)
