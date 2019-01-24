package app.yss.com.util;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;

import app.yss.com.util.util.EmojiFilter2;
import app.yss.com.util.util.NetworkUtils;
import app.yss.com.util.util.StrongLengthFilter;
import app.yss.com.util.util.ToastUtil;
import app.yss.com.util.view.ClearEditText;

public class MainActivity
        extends AppCompatActivity
{

    ClearEditText mEditText;
    Button mBtToast;
    Button mBtNetwork;
    Button mBtRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.cl_text);
        mBtToast = findViewById(R.id.bt_toast);
        mBtNetwork = findViewById(R.id.bt_net_work);
        mBtRecycler = findViewById(R.id.bt_recycler);
        initData();
        initListener();
    }


    private void initData(){
        mEditText.setFilters(new InputFilter[]{new StrongLengthFilter(MainActivity.this,5,"输入的字数超过限制"),new EmojiFilter2()});


        //Toast
        mBtToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String content = mEditText.getText().toString().trim();
                if (!"".equals(content)){
                    ToastUtil.showShortToast(MainActivity.this,content);
                } else
                    ToastUtil.showShortToast(MainActivity.this,"请输入内容");
            }
        });
        mBtNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (NetworkUtils.isNetworkConnected(MainActivity.this))ToastUtil.showShortToast(MainActivity.this,"没有网络");
             if (NetworkUtils.isWifiConnected(MainActivity.this))ToastUtil.showShortToast(MainActivity.this,"已连接wifi,网络可用");
            }
        });

        mBtRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
            }
        });


    }

    private void initListener(){

    }
}
