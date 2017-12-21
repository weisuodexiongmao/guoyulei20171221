package bwe.com.bawei.guoyulei20171221.login.loginpressenter;

import bwe.com.bawei.guoyulei20171221.login.bean.Login_Bean;
import bwe.com.bawei.guoyulei20171221.login.loginmod.login_Mod;
import bwe.com.bawei.guoyulei20171221.login.loginvview.login_view;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class login_presenter {
    private login_view view;
    private login_Mod mod;
    public login_presenter(login_view view) {
        this.view = view;
        this.mod=new login_Mod();
    }
    public void presen(){
        mod.loginData1(new login_Mod.Logindata() {
            @Override
            public void data(Login_Bean login_bean) {
                view.loginData(login_bean);
            }
        },view.loginname(),view.loginpass());
    }
}
