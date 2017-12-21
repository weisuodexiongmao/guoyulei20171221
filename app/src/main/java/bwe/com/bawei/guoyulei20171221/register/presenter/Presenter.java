package bwe.com.bawei.guoyulei20171221.register.presenter;

import bwe.com.bawei.guoyulei20171221.register.bean.reg_Bean;
import bwe.com.bawei.guoyulei20171221.register.model.Mod;
import bwe.com.bawei.guoyulei20171221.register.vview.V_View;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class Presenter {
    private V_View v_view;
    private Mod mod;
    public Presenter(V_View v_view) {
        this.v_view = v_view;
        this.mod=new Mod();
    }
    public void presen(){
        mod.regData(new Mod.Data1() {
            @Override
            public void data1(reg_Bean reg_bean) {
                v_view.regdata(reg_bean);
            }
        },v_view.name(),v_view.pass());
    }
}
