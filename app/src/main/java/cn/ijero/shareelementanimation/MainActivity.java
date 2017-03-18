package cn.ijero.shareelementanimation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Callback, ImageAdapter.OnItemClickListener {

    public static final String URL_BASE = "http://image.baidu.com/data/imgs?";

    private TextView errorTextView;
    private LinearLayout progressLayout;
    private ContentLoadingProgressBar progressBar;
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private OkHttpClient okHttpClient = new OkHttpClient();

    private Request.Builder builder = new Request.Builder().get();
    private Gson gson = new Gson();
    private int pageSize = 20;
    private int index = 0;
    private String col = "美女";
    private String tag = "小清新";
    private int sort = 0;
    private Intent intent = new Intent();
    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();
    }

    private void initData() {
        if (index > 0) {
            Toast.makeText(this, "正在加载更多数据", Toast.LENGTH_SHORT).show();
        }
        Request request = builder.url(URL_BASE + "col=" + col +
                "&tag=" + tag + "&sort=" + sort +
                "&pn=" + (index * pageSize) + "&rn=" + pageSize +
                "&p=channel&from=1").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(this);
    }

    private void initViews() {
        errorTextView = (TextView) findViewById(R.id.tv_main);
        progressLayout = (LinearLayout) findViewById(R.id.ll_progress);
        progressBar = (ContentLoadingProgressBar) findViewById(R.id.pb_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        recyclerView.setItemAnimator(new ScaleInLeftAnimator());
        recyclerView.getItemAnimator().setAddDuration(300);
        imageAdapter = new ImageAdapter();
        imageAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(imageAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (isLoading) {
                    return;
                }

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    GridLayoutManager layoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    int lastVisiblePosition = layoutManager.findLastVisibleItemPosition();
                    if (lastVisiblePosition >= layoutManager.getItemCount() - layoutManager.getSpanCount()) {
                        isLoading = true;
                        index++;
                        initData();
                    }
                }

                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE: // The RecyclerView is not currently scrolling.
                        //当屏幕停止滚动，加载图片
                        Glide.with(MainActivity.this).resumeRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING: // The RecyclerView is currently being dragged by outside input such as user touch input.
                        //当屏幕滚动且用户使用的触碰或手指还在屏幕上，停止加载图片
                        Glide.with(MainActivity.this).pauseRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING: // The RecyclerView is currently animating to a final position while not under outside control.
                        //由于用户的操作，屏幕产生惯性滑动，停止加载图片
                        Glide.with(MainActivity.this).pauseRequests();
                        break;
                }
            }

        });

        intent.setClass(this, DetailActivity.class);
    }

    @Override
    public void onFailure(Call call, IOException e) {
        if (index > 0)
            index--;
        isLoading = false;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "网络异常，请稍后重试", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        String json = response.body().string();

        Log.e(this.getClass().getSimpleName(), json);
        final ImageBean imageBean = gson.fromJson(json, ImageBean.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressLayout.setVisibility(View.GONE);
                List<ImageBean.ImgsBean> imgs = imageBean.getImgs();
                if (imgs == null || imgs.size() < 1) {
                    index--;
                    Toast.makeText(MainActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 最后一个元素是空的，需要移除掉
                imgs.remove(imgs.size() - 1);
                imageAdapter.addImgs(imgs);
                isLoading = false;
            }
        });
    }

    @Override
    public void onClickItem(View view, int position, ImageBean.ImgsBean imgsBean) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = view.getDrawingCache();

        byte[] bitmapByte = bitmap2Bytes(bitmap);

        intent.putExtra("bitmap", bitmapByte);
        intent.putExtra("imageUrl", imgsBean);
        Bundle options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, Contract.SHARED_IMAGE_ELEMENT_NAME).toBundle();
        ActivityCompat.startActivity(this,intent, options);
        view.setDrawingCacheEnabled(false);
    }

    /**
     * Bitmap转bytes
     * @param bitmap
     * @return
     */
    private byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }
}
