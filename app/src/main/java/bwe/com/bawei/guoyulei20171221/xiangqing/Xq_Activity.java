package bwe.com.bawei.guoyulei20171221.xiangqing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.guoyulei20171221.R;
import bwe.com.bawei.guoyulei20171221.gouwuche.Gouwu_Activity;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_P.XqPresenter;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_v.Xqview;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xqbean.Xq_Bean;

public class Xq_Activity extends AppCompatActivity implements Xqview{

    @BindView(R.id.xqsdv)
    SimpleDraweeView xqsdv;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.button4)
    Button button4;
    private String pid;
    private int pid1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xq_);
        ButterKnife.bind(this);
        pid = getIntent().getStringExtra("pid");
        XqPresenter xqPresenter=new XqPresenter(this);
        xqPresenter.xqpresen();
    }

    @OnClick(R.id.button4)
    public void onViewClicked() {
//        XqPresenter xqPresenter=new XqPresenter(this);
//        xqPresenter.addpresen();
        startActivity(new Intent(Xq_Activity.this,Gouwu_Activity.class));
    }

    @Override
    public void getxqdata(Xq_Bean xq_bean) {
        String images = xq_bean.getData().getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        xqsdv.setImageURI(s);
        textView3.setText(xq_bean.getData().getTitle());
        textView4.setText(xq_bean.getData().getPrice()+"");
        textView5.setText(xq_bean.getSeller().getName());
        pid1 = xq_bean.getData().getPid();
    }

    @Override
    public String pid() {
        return pid;
    }


    @Override
    public void getAdddata(Add_Bean add_bean) {
        Toast.makeText(this,add_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String spid() {
        return pid1+"";
    }
}
