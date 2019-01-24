package app.yss.com.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import app.yss.com.util.divider.DividerItem;

public class RecyclerActivity
        extends AppCompatActivity
{

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mRecyclerView = findViewById(R.id.recycler_view);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            data.add(i+"=============");
        }
        mRecyclerView.setAdapter(new ItemAdapter(data,RecyclerActivity.this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.addItemDecoration(new DividerItem(RecyclerActivity.this,25));

    }
}
