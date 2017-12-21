package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_v;

import bwe.com.bawei.guoyulei20171221.xiangqing.Add_Bean;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xqbean.Xq_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface Xqview {
    void getxqdata(Xq_Bean xq_bean);
    String pid();
    void getAdddata(Add_Bean add_bean);
    String spid();
}
