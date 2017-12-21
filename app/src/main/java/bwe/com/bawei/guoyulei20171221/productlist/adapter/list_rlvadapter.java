package bwe.com.bawei.guoyulei20171221.productlist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwe.com.bawei.guoyulei20171221.R;
import bwe.com.bawei.guoyulei20171221.productlist.listbean.list_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class list_rlvadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private list_Bean list_bean;
    private Context context;

    public list_rlvadapter(list_Bean list_bean, Context context) {
        this.list_bean = list_bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VHitem(LayoutInflater.from(context).inflate(R.layout.listrlv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       VHitem vHitem= (VHitem) holder;
        final list_Bean.DataBean dataBean = list_bean.getData().get(position);
        String images = list_bean.getData().get(position).getImages();
        String[] split = images.split("\\|");
        String s = split[0];
        Log.d("TAG1",s);
        vHitem.simpleDraweeView.setImageURI(s);
        vHitem.textView.setText(list_bean.getData().get(position).getTitle());
        vHitem.textView2.setText(list_bean.getData().get(position).getPrice()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclickListenter.onitemclick(dataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_bean.getData().size();
    }
    class VHitem extends RecyclerView.ViewHolder{
        SimpleDraweeView simpleDraweeView;
        TextView textView,textView2;
        public VHitem(View itemView) {
            super(itemView);
            simpleDraweeView= (SimpleDraweeView) itemView.findViewById(R.id.sdv);
            textView= (TextView) itemView.findViewById(R.id.textView);
            textView2= (TextView) itemView.findViewById(R.id.textView2);
        }
    }
    //点击条目的接口
    public interface OnitemclickListenter{
        void onitemclick(list_Bean.DataBean dataBean);

    }
    private OnitemclickListenter onitemclickListenter;
    public void setOnitemclick(OnitemclickListenter onitemclickListenter){
        this.onitemclickListenter=onitemclickListenter;

    }
}
