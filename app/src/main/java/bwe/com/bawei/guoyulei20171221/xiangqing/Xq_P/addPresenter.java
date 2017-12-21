package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_P;

import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M.AddMod;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_v.addView;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class addPresenter {
    private addView addView;
    private AddMod mod;
    public addPresenter(bwe.com.bawei.guoyulei20171221.xiangqing.Xq_v.addView addView) {
        this.addView = addView;
        this.mod=new AddMod();
    }

}
