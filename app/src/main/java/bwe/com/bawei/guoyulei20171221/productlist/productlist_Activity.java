package bwe.com.bawei.guoyulei20171221.productlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwe.com.bawei.guoyulei20171221.R;
import bwe.com.bawei.guoyulei20171221.productlist.adapter.list_rlvadapter;
import bwe.com.bawei.guoyulei20171221.productlist.list_P.list_Presenter;
import bwe.com.bawei.guoyulei20171221.productlist.list_view.list_vview;
import bwe.com.bawei.guoyulei20171221.productlist.listbean.list_Bean;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_Activity;

public class productlist_Activity extends AppCompatActivity implements list_vview {

    @BindView(R.id.Rlv)
    RecyclerView Rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist_);
        ButterKnife.bind(this);
        Rlv.setLayoutManager(new LinearLayoutManager(this));
        list_Presenter presenter=new list_Presenter(this);
        presenter.listpresen();
    }

    @Override
    public void getlistdata(list_Bean list_bean) {
        list_rlvadapter list_rlvadapter=new list_rlvadapter(list_bean,this);
        Rlv.setAdapter(list_rlvadapter);
        list_rlvadapter.setOnitemclick(new list_rlvadapter.OnitemclickListenter() {
            @Override
            public void onitemclick(list_Bean.DataBean dataBean) {
                Intent intent=new Intent(productlist_Activity.this, Xq_Activity.class);
                intent.putExtra("pid",dataBean.getPid()+"");
                startActivity(intent);
            }
        });
    }
}
