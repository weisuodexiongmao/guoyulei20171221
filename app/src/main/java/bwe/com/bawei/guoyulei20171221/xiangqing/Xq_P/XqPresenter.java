package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_P;

import bwe.com.bawei.guoyulei20171221.xiangqing.Add_Bean;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M.AddMod;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M.XqMod;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xq_v.Xqview;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xqbean.Xq_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class XqPresenter {
    private Xqview xqview;
    private XqMod xqMod;
    private AddMod mod;
    public XqPresenter(Xqview xqview) {
        this.xqview = xqview;
        this.xqMod=new XqMod();
        this.mod=new AddMod();
    }
    public void xqpresen(){
        xqMod.XqData1(new XqMod.getxqData() {
            @Override
            public void xqdata(Xq_Bean xq_bean) {
                xqview.getxqdata(xq_bean);
            }
        },xqview.pid());
    }
    public void addpresen(){
        mod.getAdddata(new AddMod.getaddData1() {
            @Override
            public void addData1(Add_Bean add_bean) {
                xqview.getAdddata(add_bean);
            }
        },xqview.spid());
    }
}
