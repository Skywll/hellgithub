package com.gogogo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class MainActivity extends AppCompatActivity {


    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mImageView = (ImageView) findViewById(R.id.iv);


        System.out.println();


    }

    public void loadimage(View view) {
        // 加载本地图片
        //File file = new File(getExternalCacheDir() + "/image.jpg");
        //Glide.with(this.getApplicationContext()).load(file).into(imageView);

        //加载应用资源 例如gif图片
        //int resource = R.drawable.loading;
        //Glide.with(this).load(resource).asGif().diskCacheStrategy(DiskCacheStrategy.NONE).into(mImageView);

        //// 加载二进制流
        //byte[] image = getImageBytes();
        //Glide.with(this.getApplicationContext()).load(image).into(imageView);

        //// 加载Uri对象网络上的如果是gif就默认为gif播放
        //Uri imageUri = getImageUri();
        //Glide.with(this.getApplicationContext()).load(imageUri).into(imageView);


         String url = "http://p1.pstatp.com/large/166200019850062839d3";//gif的地址
        try {
            Glide.with(this)
                    .load(url)
                    //.asBitmap()//将默认的gif变为静态图片
                    .asGif()
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)//这样就可以禁用掉Glide的缓存功能。
                    // 回复G_M_Dragon：那应该是因为你没有配置diskCacheStrategy，加载gif图一定要把diskCacheStrategy设置成NONE，或者是SOURCE，不配不行，因为不配默认就是ALL，这种情况下会把GIF图的每一帧都去压缩然后缓存，时间极长，可能要几分钟gif图才会显示出来。
                    //.override(100, 100)//分辨率修改为100*100,小一点会快一点
                    .into(mImageView);
        } catch (Exception e) {//You cannot start a load for a destroyed activity
            Log.d("xiaohui", "抛异常");
            e.printStackTrace();
        }


    }


    @Override
    protected void onDestroy() {
        Log.d("xiaohui", "销毁掉");
        super.onDestroy();
    }
}
