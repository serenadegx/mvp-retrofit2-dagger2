package com.example.serenadegx.opensource.business;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.serenadegx.opensource.R;
import com.example.serenadegx.opensource.business.adapter.BusinessAdapter;
import com.example.serenadegx.opensource.di.ActivityScoped;
import com.example.serenadegx.opensource.web.WebActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.DaggerActivity;

@ActivityScoped
public class BusinessActivity extends DaggerActivity implements BusinessContract.View {
    @Inject
    BusinessContract.Presenter presenter;
    private RecyclerView rv;
    private BusinessAdapter adapter;
    private List<BusinessResult> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
        presenter.takeView(this);
        presenter.getBusiness();
    }

    private void initAdapter() {
        adapter = new BusinessAdapter(R.layout.item_business);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BusinessActivity.this, mData.get(position).getName(), Toast.LENGTH_SHORT).show();
                WebActivity.start2WebActivity(BusinessActivity.this);
            }
        });
    }

    @Override
    public void loadDataSuccess() {
        Toast.makeText(this, "加载成功", Toast.LENGTH_SHORT).show();
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add(new BusinessResult("1335689229" + i));
        }
        adapter.setNewData(mData);
    }

    public static void start2BusinessActivity(Context context) {
        context.startActivity(new Intent(context, BusinessActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }
}
