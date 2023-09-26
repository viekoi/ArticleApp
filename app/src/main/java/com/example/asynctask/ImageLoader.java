package com.example.asynctask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.loader.content.AsyncTaskLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader extends AsyncTaskLoader<Bitmap> {
    private String imageUrl;
    public ImageLoader(Context context, String imageUrl) {
        super(context);
        this.imageUrl = imageUrl;
    }

    @Override
    public Bitmap loadInBackground() {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            input.close();
            return bitmap;
        } catch (IOException e) {
            Log.e("ImageLoader", "Error loading image", e);
        }
        return null;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}

