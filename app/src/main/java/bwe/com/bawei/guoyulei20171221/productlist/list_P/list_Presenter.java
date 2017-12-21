package bwe.com.bawei.guoyulei20171221.productlist.list_P;

import bwe.com.bawei.guoyulei20171221.productlist.list_M.list_Model;
import bwe.com.bawei.guoyulei20171221.productlist.list_view.list_vview;
import bwe.com.bawei.guoyulei20171221.productlist.listbean.list_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class list_Presenter {
    private list_vview vview;
    private list_Model model;
    public list_Presenter(list_vview vview) {
        this.vview = vview;
        this.model=new list_Model();
    }
    public void listpresen(){
        model.listData(new list_Model.getData() {
            @Override
            public void data(list_Bean list_bean) {
                vview.getlistdata(list_bean);
            }
        });
    }
}
