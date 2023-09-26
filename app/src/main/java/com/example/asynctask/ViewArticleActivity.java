package com.example.asynctask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class ViewArticleActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Bitmap>{
    ImageView iv_detail;
    TextView tv_detail_title, tv_detail_description;

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);

        iv_detail = findViewById(R.id.iv_detail);
        tv_detail_title = findViewById(R.id.tv_detail_title);
        tv_detail_description = findViewById(R.id.tv_detail_description);

        int id = (int) getIntent().getLongExtra("id",0);
        LoaderManager loaderManager = getSupportLoaderManager();
        loaderManager.initLoader(id, null, this );
        tv_detail_title.setText(ArticleData.getArticleFromId(id).getArticle_image());
        tv_detail_description.setText((ArticleData.getArticleFromId(id)).getGetArticle_description());
    }
    @Override
    public Loader<Bitmap> onCreateLoader(int id, @Nullable  Bundle args) {
        Article photoShow = null;
        for (Article photo: ArticleData.data.getArticles()) {
            if (photo.getArticle_id() == id)
                photoShow = photo;
        }
        return new ImageLoader(this, photoShow.getArticle_image());
    }
    @Override
    public void onLoadFinished(@NonNull  Loader<Bitmap> loader, Bitmap data) {
        if (data != null)
                iv_detail.setImageBitmap(data);
    }
    @Override
    public void onLoaderReset(@NonNull Loader<Bitmap> loader) {
    }
}