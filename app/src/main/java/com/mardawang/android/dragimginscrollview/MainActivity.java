package com.mardawang.android.dragimginscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mardawang.android.dragimginscrollview.view.DragImageView;
import com.mardawang.android.dragimginscrollview.view.ObservableScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ObservableScrollView scroll_view;
    private DragImageView drag_img;
    private LinearLayout ll_view;
    private ArrayList<Object> mImgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initview();
        inflateview();
    }

    private void inflateview() {
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);

        mImgs = new ArrayList<>();
        int[] mUrls = {R.drawable.default_bg,R.drawable.default_bg};
        for (int item : mUrls)
        {
            ImageView img = new ImageView(this);
            img.setScaleType(ImageView.ScaleType.FIT_XY);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(outMetrics.widthPixels, outMetrics.heightPixels);
            img.setLayoutParams(param);

//            IImageFactory.getLoader().loadFormNet(img,item, IImageLoader.Options.defaultOptions().setScaleType(ImageView.ScaleType.FIT_XY));

            img.setImageResource(item);
            ll_view.addView(img);
            mImgs.add(img);
        }

        drag_img.setBackgroundResource(R.drawable.icon_kobe);
    }

    private void initview() {
        scroll_view = findViewById(R.id.scroll_view);
        drag_img = findViewById(R.id.drag_img);
        ll_view = findViewById(R.id.ll_view);
    }
}
