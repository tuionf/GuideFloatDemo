package com.example.tuionf.guidefloatdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView mImageView;
    private int[] pics = new int[]{R.drawable.floatview1,R.drawable.floatview2,R.drawable.floatview3};
    private static final String TAG = "MainActivity";
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        setGuideView();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGuideView();
            }
        });
    }

    private void setGuideView(){
        View rootView = getWindow().getDecorView();
        if (rootView ==  null) return;
        final FrameLayout frameLayout = (FrameLayout) rootView;
        mImageView = new ImageView(MainActivity.this);
        mImageView.setBackgroundResource(R.drawable.floatview1);
        //把图片不按比例扩大/缩小到View的大小显示
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mImageView.setLayoutParams(params);
        frameLayout.addView(mImageView);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i == 0) {
                    frameLayout.removeView(mImageView);
                    i = (i + 1) % 3;
                    Log.d(TAG, "onClick: --" + i);
                    mImageView.setBackgroundResource(pics[1]);
                    frameLayout.addView(mImageView);

                }else if (i == 1){
                    Log.d(TAG, "onClick: ------"+i);
                    frameLayout.removeView(mImageView);
                    i = (i+1) % 3;
                    Log.d(TAG, "onClick: -----------"+i);
                    mImageView.setBackgroundResource(pics[2]);
                    frameLayout.addView(mImageView);
                }else if (i == 2){  
//                    i = (i+1) % 3;
                    Log.d(TAG, "onClick: -------------------------"+i);
                    frameLayout.removeView(mImageView);
                    i = 0;
                }
                
            }
        });
    }
}
