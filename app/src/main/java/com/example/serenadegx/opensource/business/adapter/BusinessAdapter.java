package com.example.serenadegx.opensource.business.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.serenadegx.opensource.R;
import com.example.serenadegx.opensource.business.BusinessResult;

public class BusinessAdapter extends BaseQuickAdapter<BusinessResult, BaseViewHolder> {
    public BusinessAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, BusinessResult item) {
        helper.setText(R.id.tv_1, item.getName());
    }
}
