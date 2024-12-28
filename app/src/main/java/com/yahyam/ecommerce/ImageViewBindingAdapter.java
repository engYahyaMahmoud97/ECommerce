package com.yahyam.ecommerce;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.BindingAdapter;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageViewBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void bindImage(ImageView imageView, String imgUrl , ProgressBar progressBar , TextView textView) {
        if (imageView.getDrawable() == null) {
            progressBar.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.GONE);
            if (imgUrl != null) {
                String imgUri = Uri.parse(imgUrl).buildUpon().scheme("https").build().toString();

                Handler uiHandler = new Handler(Looper.getMainLooper());
                new Thread(() -> {
                    Bitmap bitmap = downloadBitmap(imgUri);
                   try {
                       if (bitmap == null){
                           imageView.setVisibility(View.GONE);
                           textView.setVisibility(View.VISIBLE);
                           progressBar.setVisibility(View.GONE);
                           textView.setText("Error Download");

                       }else {
                           uiHandler.post(() -> imageView.setImageBitmap(bitmap));
                           imageView.setVisibility(View.VISIBLE);
                           textView.setVisibility(View.GONE);
                           progressBar.setVisibility(View.GONE);
                       }
                   }catch (Exception e){
                       imageView.setVisibility(View.GONE);
                       textView.setVisibility(View.VISIBLE);
                       progressBar.setVisibility(View.GONE);
                       textView.setText("Error Download");
                   }
                }).start();

            }
        }
    }

    @SuppressLint("SetTextI18n")
    public static Bitmap downloadBitmap(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("TAG", "Exception " + e);
            return null;
        }
    }
}

