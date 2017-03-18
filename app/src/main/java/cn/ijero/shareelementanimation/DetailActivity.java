package cn.ijero.shareelementanimation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_detail);

        ImageView imageView = (ImageView) findViewById(R.id.iv_detail);
        ViewCompat.setTransitionName(imageView, Contract.SHARED_IMAGE_ELEMENT_NAME);

        TextView textView = (TextView) findViewById(R.id.tv_detail_desc);
        findViewById(R.id.rl_detail_root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAfterTransition(DetailActivity.this);
            }
        });

        Intent intent = getIntent();

        // Bitmap
        byte[] bis = intent.getByteArrayExtra("bitmap");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bis, 0, bis.length);
        imageView.setImageBitmap(bitmap);

        ImageBean.ImgsBean imgsBean = (ImageBean.ImgsBean) intent.getSerializableExtra("imageUrl");
        textView.setText(imgsBean.getDesc());
    }
}
